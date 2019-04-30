package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.Paper;
import cn.xzxy.lewy.iaweb.service.PaperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PaperController {

    @Resource
    PaperService paperService;

    @GetMapping("/papers")
    public String list(Model model) {
        List<Paper> papers = paperService.getAll();
        //放在请求域中
        model.addAttribute("papers", papers);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "paper/list";
    }

}
