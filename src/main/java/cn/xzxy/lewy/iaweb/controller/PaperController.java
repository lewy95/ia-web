package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.ItemType;
import cn.xzxy.lewy.iaweb.pojo.Paper;
import cn.xzxy.lewy.iaweb.pojo.PaperItem;
import cn.xzxy.lewy.iaweb.service.ItemTypeService;
import cn.xzxy.lewy.iaweb.service.PaperItemService;
import cn.xzxy.lewy.iaweb.service.PaperService;
import cn.xzxy.lewy.iaweb.util.RandomStringUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PaperController {

    @Resource
    PaperService paperService;

    @Resource
    ItemTypeService itemTypeService;

    @Resource
    PaperItemService paperItemService;

    //分页展示
    @GetMapping("/papers")
    public String list(Model model,
                       @RequestParam(value = "start", defaultValue = "0") Integer start,
                       @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;

        //还要改
        //int userId = 1;

        Page<Paper> papers = paperService.getAllByPage(start, limit);
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
        //自动生成试卷编号
        String rst = RandomStringUtil.getRandomCode(6,0);
        model.addAttribute("pcode","p" + rst);
        List<ItemType> its = itemTypeService.getAll();
        model.addAttribute("ptypes",its);
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "paper/add";
    }

    //试卷添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/paper")
    public String addPaper(Paper paper, PaperItem paperItem) {

        //根据试题类型确定主观题和客观题的题目数
        int[] ors = getOaNums(paperItem,paperItem.getoItems(),paperItem.getsItems());
        paperItem.setAllItems(ors[0] + ors[1]);
        paperItem.setoItems(ors[0]);
        paperItem.setsItems(ors[1]);
        paper.setPaperItem(paperItem);
        paperService.savePaper(paper);

        return "redirect:/papers";
    }

    //来到修改页面，查出当前试卷，在页面回显
    @GetMapping("/paper/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Paper paper = paperService.getById(id);
        model.addAttribute("paper",paper);
        List<ItemType> its = itemTypeService.getAll();
        model.addAttribute("ptypes",its);
        return "paper/edit";
    }

    //试卷修改；需要提交试卷id；
    @PutMapping("/paper")
    public String updateEmployee(Paper paper,PaperItem paperItem){
        int originPtId = paper.getPaperItem().getId();

        //根据试题类型确定主观题和客观题的题目数
        int[] ors = getOaNums(paperItem,paperItem.getoItems(),paperItem.getsItems());
        paperItem.setAllItems(ors[0] + ors[1]);
        paperItem.setoItems(ors[0]);
        paperItem.setsItems(ors[1]);
        paper.setPaperItem(paperItem);
        paperService.savePaper(paper);
        //先删除原来的记录
        paperItemService.deleteById(originPtId);
        return "redirect:/papers";
    }

    //试卷删除
    @DeleteMapping("/paper/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        paperService.deleteById(id);
        return "redirect:/papers";
    }

    private int[] getOaNums(PaperItem paperItem, int ots, int sts) {
        int[] ors = {ots,sts};
        if (paperItem.getPart1Type() != null && paperItem.getPart1Type() != 0){
            ors = getEveryOa(paperItem.getPart1Type(), ors);
        }
        if (paperItem.getPart2Type() != null && paperItem.getPart2Type() != 0){
            ors = getEveryOa(paperItem.getPart2Type(), ors);
        }
        if (paperItem.getPart3Type() != null && paperItem.getPart3Type() != 0){
            ors = getEveryOa(paperItem.getPart3Type(), ors);
        }
        if (paperItem.getPart4Type() != null && paperItem.getPart4Type() != 0){
            ors = getEveryOa(paperItem.getPart4Type(), ors);
        }
        if (paperItem.getPart5Type() != null && paperItem.getPart5Type() != 0){
            ors = getEveryOa(paperItem.getPart5Type(), ors);
        }
        if (paperItem.getPart6Type() != null && paperItem.getPart6Type() != 0){
            ors = getEveryOa(paperItem.getPart6Type(), ors);
        }
        if (paperItem.getPart7Type() != null && paperItem.getPart7Type() != 0){
            ors = getEveryOa(paperItem.getPart7Type(), ors);
        }
        if (paperItem.getPart8Type() != null && paperItem.getPart8Type() != 0){
            ors = getEveryOa(paperItem.getPart8Type(), ors);
        }
        return ors;
    }

    private int[] getEveryOa(Integer pt, int[] ors) {
        ItemType it = itemTypeService.getByItc(pt);
        if (it.getTypeKind().equals("0")) {
            ors[0] += 1;
        } else {
            ors[1] += 1;
        }
        return ors;
    }

}
