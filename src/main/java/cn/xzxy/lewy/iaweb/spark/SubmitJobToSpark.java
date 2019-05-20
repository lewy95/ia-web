package cn.xzxy.lewy.iaweb.spark;

import org.apache.spark.deploy.SparkSubmit;

public class SubmitJobToSpark {

    public static void submitJob(String path, String paperCode, String createTime, String step) {
        String[] args = new String[]{
                //注意：master的端口要指定为通信端口(默认7077)而不要指定web端口(默认8080)
                "--master", "spark://hadoop01:7077",
                "--name", "spark job of paper:" + paperCode,
                "--class", "cn.xzxy.lewy.etl.ItemETLPro",
                "/home/ofo/bishe/packmas_jarPro/itemAnalysis.jar",
                path,
                paperCode,
                createTime,
                step
        };
        SparkSubmit.main(args);
    }
}
