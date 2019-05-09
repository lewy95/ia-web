package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.*;
import cn.xzxy.lewy.iaweb.service.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SubmissionController {

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
        List<ItemFpg> itemFpgs =
                itemFpgService.getByPCodeAndCreate(paperCode, createTime);
        model.addAttribute("fpgInfos", itemFpgs);

        //获取聚类结果
        List<ItemCluster> clusterMap = getClusterMap(paperCode,createTime);
        model.addAttribute("clusters",clusterMap);

        return "item/index";
    }

    /**
     * 获取聚类结果
     * @param paperCode 试卷编号
     * @param createTime 创建时间
     * @return map
     */
    private List<ItemCluster> getClusterMap(String paperCode, String createTime) {
        List<ItemCluster> clusterMap = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            List<ItemCluster> ics = itemClusterService.getAllByPCodeAndCreate(paperCode, createTime, i);
            for (ItemCluster ic: ics) {
                sb.append(ic.getStuCode()).append(",");
            }
            sb.deleteCharAt(sb.length() -1);

            ItemCluster newIc = new ItemCluster();
            newIc.setStuCode(sb.toString());
            //处理试题序号转换为知识点
            String gIsb =  transferItem(ics.get(0).getGoodItem(), paperCode);
            String bIsb =  transferItem(ics.get(0).getBadItem(), paperCode);
            newIc.setGoodItem(gIsb);
            newIc.setBadItem(bIsb);
            newIc.setCenters(ics.get(0).getCenters());

            clusterMap.add(newIc);
        }
        return clusterMap;
    }

    /**
     * 转换聚类分析的试题号为知识点
     * @param itemNums 试题号
     * @param paperCode 试卷编号
     * @return sb
     */
    private String transferItem(String itemNums, String paperCode) {

        StringBuilder sb = new StringBuilder();
        if (!itemNums.equals("")){
            String[] its = itemNums.split(",");
            for (String it : its) {
                Knowledge kl = knowledgeService.getOneById(Integer.parseInt(it), paperCode);
                sb.append(kl.getKlContent()).append("-").append(it).append(";");
            }
            return sb.deleteCharAt(sb.length() -1).toString();
        } else {
            return "无";
        }
    }
}
