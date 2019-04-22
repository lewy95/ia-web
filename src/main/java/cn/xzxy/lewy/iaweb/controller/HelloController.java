package cn.xzxy.lewy.iaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @GetMapping(value = "/toItemIndex")
    public ModelAndView sparkDemo() {
        return new ModelAndView("itemIndex");
    }
}

