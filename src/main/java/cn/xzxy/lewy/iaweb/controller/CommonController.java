package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.Paper;
import cn.xzxy.lewy.iaweb.pojo.Submission;
import cn.xzxy.lewy.iaweb.service.PaperService;
import cn.xzxy.lewy.iaweb.service.SubmissionService;
import cn.xzxy.lewy.iaweb.service.UserService;
import cn.xzxy.lewy.iaweb.util.MyMessage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Controller
public class CommonController {

    @Resource
    PaperService paperService;

    @Resource
    SubmissionService submissionService;

    @Resource
    UserService userService;

    //来到主页面
    @GetMapping("/toHomePage")
    public String toAddPage(Model model) {

        //理论上根据用户id获取所有试卷
        //获取的试卷将展示在下拉框中
        //用户部分暂时先不做，后面再完善
        List<Paper> papers = paperService.getAll();
        model.addAttribute("papers", papers);
        return "commons/home";
    }

    @PostMapping("/uploadData")
    @ResponseBody
    public Object upload(@RequestParam(value = "paperInfoId") Integer pid,
                         @RequestParam(value = "comments") String comment,
                         @RequestParam(value = "file") MultipartFile fileUpload){
        //System.out.println(pid + "," + comment);
        //获取原有文件名
        //String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //System.out.println(fileName + suffixName);
        //重新生成文件名
        Paper paper = paperService.getById(pid);
        Submission submission = new Submission();
        submission.setStatusno(0);
        submission.setUser(userService.getById(1));
        submission.setPaper(paper);
        submission.setComments(comment);
        submission.setSubmitTime(String.valueOf(System.currentTimeMillis()));

        String fileName = paper.getPaperCode();
        //指定本地文件夹存储图片
        String filePath = "/home/ofo/bishe/flume/";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath + fileName));
            //保存成功，往数据库插入一条数据
            submissionService.saveOne(submission);
            return new MyMessage("0","Success to upload");
        } catch (Exception e) {
            e.printStackTrace();
            return new MyMessage("1","Fail to upload");
        }
    }

}
