package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.*;
import cn.xzxy.lewy.iaweb.service.*;
import cn.xzxy.lewy.iaweb.spark.SubmitJobToSpark;
import cn.xzxy.lewy.iaweb.util.MyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SubmissionController {

    private Logger logger = LoggerFactory.getLogger(SubmissionController.class);

    @Resource
    SubmissionService submissionService;

    @Resource
    ItemFpgService itemFpgService;

    @Resource
    ItemClusterService itemClusterService;

    @Resource
    PaperIndexService paperIndexService;

    @Resource
    KnowledgeService knowledgeService;

    @Resource
    Knowledge2Service knowledge2Service;

    //分页展示
    @GetMapping("/submissions")
    public String list(Model model,
                       @RequestParam(value = "start", defaultValue = "0") Integer start,
                       @RequestParam(value = "limit", defaultValue = "5") Integer limit) throws Exception {
        start = start < 0 ? 0 : start;

        //还要改
        int userId = 1;

        List<Submission> submissions0 = submissionService.getByUserIdAndStatus(userId, 0);
        Page<Submission> submissions1 = submissionService.getByUserIdAndStatus(start, limit, userId, 1);
        //放在请求域中
        model.addAttribute("submissions0", submissions0);
        model.addAttribute("submissions1", submissions1);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "submission/list";
    }

    //删除上传记录
    @DeleteMapping("/submission/{id}")
    public String deleteSubmission(@PathVariable("id") Integer id){
        submissionService.deleteById(id);
        return "redirect:/submissions";
    }

    //选择指定记录进行分析
    //ajax异步处理
    @RequestMapping(value = "/submission/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object doAnalysis(@PathVariable("id") Integer id) {
        Submission submission = submissionService.getById(id);
        //拼接路径
        //路径hdfs://hadoop01:9000/itemdata/reportTime=2019-04-25
        String nowDay = submission.getSubmitTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(Long.valueOf(nowDay));
        String parseDate = sdf.format(date);
        String path = "hdfs://hadoop01:9000/itemdata/reportTime=" + parseDate;

        logger.info("submission:" + id + "is resolving...");
        try {
            //提交spark任务
            SubmitJobToSpark.submitJob(path,submission.getPaper().getPaperCode(), nowDay,"123");
            //任务处理完成后，更新记录的状态

            return new MyMessage("0", "Success to submit, please wait");
        } catch (Exception e) {
            e.printStackTrace();
            return new MyMessage("1", "Fail to submit, please redo");
        }
    }

    //查看详情
    @GetMapping("/submission/{id}")
    public String showITDetail(@PathVariable("id") Integer id, Model model) {

        Submission submission = submissionService.getById(id);
        System.out.println(submission.toString());
        model.addAttribute("subItem", submission);

        String paperCode = submission.getPaper().getPaperCode();
        String createTime = submission.getSubmitTime();

        //获取整张试卷的指标
        PaperIndex pi = paperIndexService.getByPCodeAndCreate(paperCode, createTime);
        model.addAttribute("paperIndex", pi);

        //获取推荐规则
        //List<ItemFpg> itemFpgs = itemFpgService.getByPCodeAndCreate(paperCode, createTime);
        List<ItemFpg> itemFpgs = getFpgMap(paperCode, createTime);
        model.addAttribute("fpgInfos", itemFpgs);

        //获取聚类结果
        List<ItemCluster> clusterMap = getClusterMap(paperCode, createTime);
        model.addAttribute("clusters", clusterMap);

        return "item/index";
    }

    /**
     * 获取关联性性规则
     *
     * @param paperCode  试卷编号
     * @param createTime 创建时间
     * @return fpgMaps
     */
    private List<ItemFpg> getFpgMap(String paperCode, String createTime) {
        //List<ItemFpg> fpgMaps = new ArrayList<>();
        List<ItemFpg> fpgs = itemFpgService.getByPCodeAndCreate(paperCode, createTime);
        for (ItemFpg fpg : fpgs) {
            //ItemFpg newFpg = new ItemFpg();
            String preOrders = transferItemFpg(fpg.getPreOrder());
            //String sufOrders = transferItemFpg(fpg.getSufOrder());
            //拼接知识点信息，将id展示为name
            fpg.setPreOrder(preOrders);
            //newFpg.setSufOrder(fpg);
            //newFpg.setConfidence(fpg.getConfidence());
            //fpgMaps.add(newFpg);
        }
        return fpgs;
    }

    /**
     * 将关联性分析结果转化为知识点
     *
     * @param itemNums  试题号集合
     * @return sb
     */
    private String transferItemFpg(String itemNums) {

        StringBuilder sb = new StringBuilder();
        String[] its = itemNums.split(",");
        for (String it : its) {
            //这里去查知识点的信息，理论上需要根据科目id去查，但系统暂未实现
            //即需要一个学科信息类，有id和name
            //试卷信息类和学科类也应该是一对一的关系
            //即在创建试卷时需要通过下拉框去选择学科名称，然后将其对应id保存进数据库
            Knowledge2 kl = knowledge2Service.getOneById(Integer.parseInt(it));
            //在这里还可以在知识点后面添加其涉及的试题
            sb.append(kl.getKlContent()).append(";");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 获取聚类结果
     *
     * @param paperCode  试卷编号
     * @param createTime 创建时间
     * @return map
     */
    private List<ItemCluster> getClusterMap(String paperCode, String createTime) {
        List<ItemCluster> clusterMap = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            List<ItemCluster> ics = itemClusterService.getAllByPCodeAndCreate(paperCode, createTime, i);
            for (ItemCluster ic : ics) {
                sb.append(ic.getStuCode()).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);

            ItemCluster newIc = new ItemCluster();
            newIc.setStuCode(sb.toString());
            //处理试题序号转换为知识点
            String gIsb = transferItemCluster(ics.get(0).getGoodItem(), paperCode);
            String bIsb = transferItemCluster(ics.get(0).getBadItem(), paperCode);
            newIc.setGoodItem(gIsb);
            newIc.setBadItem(bIsb);
            newIc.setCenters(ics.get(0).getCenters());

            clusterMap.add(newIc);
        }
        return clusterMap;
    }


    /**
     * 转换聚类分析的试题号为知识点
     *
     * @param itemNums  试题号
     * @param paperCode 试卷编号
     * @return sb
     */
    private String transferItemCluster(String itemNums, String paperCode) {

        StringBuilder sb = new StringBuilder();
        if (!itemNums.equals("")) {
            String[] its = itemNums.split(",");
            for (String it : its) {
                Knowledge kl = knowledgeService.getOneById(Integer.parseInt(it), paperCode);
                sb.append(kl.getKlContent()).append("-").append(it).append(";");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return "无";
        }
    }
}
