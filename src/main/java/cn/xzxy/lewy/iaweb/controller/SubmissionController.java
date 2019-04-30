package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.Submission;
import cn.xzxy.lewy.iaweb.service.SubmissionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SubmissionController {

    @Resource
    SubmissionService submissionService;

    @GetMapping("/submissions")
    public String list(Model model,
                       @RequestParam(value = "start", defaultValue = "0") Integer start,
                       @RequestParam(value = "limit", defaultValue = "5") Integer limit) throws Exception{
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
}
