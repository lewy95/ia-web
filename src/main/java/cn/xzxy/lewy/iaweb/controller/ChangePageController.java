package cn.xzxy.lewy.iaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这个类其实就是专门用来做后台管理界面的页面跳转用的，
 * 为了后面开发利索，这里索性把后台管理界面的跳转都加进去了。
 * 台面访问地址localhost:8080/iaw/home
 */
@Controller
public class ChangePageController {

    //后台访问首页跳转
    @GetMapping(value = "/home")
    public String home() {
        return "redirect:toHomePage";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }
}

