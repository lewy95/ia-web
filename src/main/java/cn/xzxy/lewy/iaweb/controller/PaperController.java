package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.Paper;
import cn.xzxy.lewy.iaweb.service.PaperService;
import cn.xzxy.lewy.iaweb.util.RandomStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
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

    //来到试卷添加页面
    @GetMapping("/paper")
    public String toAddPage(Model model) {
        //来到添加页面,查出所有的部门，在页面显示
        String rst = RandomStringUtil.getRandomCode(6,0);
        model.addAttribute("pcode","p" + rst);
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "paper/add";
    }

    //试卷添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/paper")
    public String addPaper(Paper paper) {
        //来到员工列表页面
        System.out.println("保存的试卷信息：" + paper);
        //保存员工
        paperService.savePaper(paper);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/papers";
    }

    //来到修改页面，查出当前试卷，在页面回显
    @GetMapping("/paper/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Paper paper = paperService.getById(id);
        model.addAttribute("paper",paper);

        //页面要显示所有的部门列表
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "paper/add";
    }

    //试卷修改；需要提交试卷id；
    @PutMapping("/paper")
    public String updateEmployee(Paper paper){
        System.out.println("修改的试卷信息：" + paper);
        paperService.savePaper(paper);
        return "redirect:/papers";
    }

    //试卷删除
    @DeleteMapping("/paper/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        paperService.deleteById(id);
        return "redirect:/papers";
    }


}
