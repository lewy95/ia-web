package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.spark.SubmitJobToSpark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/spark")
public class SparkController {

    private Logger logger = LoggerFactory.getLogger(SparkController.class);

    @RequestMapping(value = "/sparkSubmit", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String sparkSubmit() {
        logger.info("***********************come on*********************");
        SubmitJobToSpark.submitJob("hdfs://hadoop01:9000/itemdata/reportTime=2019-04-25",
                "915003", "1556232981122","2");
        return "thank you";
    }

}
