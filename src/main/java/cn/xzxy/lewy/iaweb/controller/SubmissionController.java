package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.ItemCluster;
import cn.xzxy.lewy.iaweb.pojo.ItemFpg;
import cn.xzxy.lewy.iaweb.pojo.Submission;
import cn.xzxy.lewy.iaweb.service.ItemClusterService;
import cn.xzxy.lewy.iaweb.service.ItemFpgService;
import cn.xzxy.lewy.iaweb.service.SubmissionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubmissionController {

    @Resource
    SubmissionService submissionService;

    @Resource
    ItemFpgService itemFpgService;

    @Resource
    ItemClusterService itemClusterService;

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

        //获取推荐规则
        List<ItemFpg> itemFpgs =
                itemFpgService.getByPCodeAndCreate(paperCode, createTime);
        model.addAttribute("fpgInfos", itemFpgs);

        //获取聚类结果
        List<ItemCluster> clusterMap = getClusterMap(paperCode,createTime);
        model.addAttribute("clusters",clusterMap);

        return "item/index";
    }

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
            newIc.setGoodItem(ics.get(0).getGoodItem());
            newIc.setBadItem(ics.get(0).getBadItem());
            newIc.setCenters(ics.get(0).getCenters());

            clusterMap.add(newIc);
        }
        return clusterMap;
    }

}
