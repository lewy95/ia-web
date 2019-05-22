package cn.xzxy.lewy.iaweb.spark;

import org.apache.spark.deploy.SparkSubmit;

/**
 * 测试用
 */
public class SubmitJobToSpark2 {
    public static void submitJob() {
        String[] args = new String[] {
            //注意：master的端口要指定为通信端口(默认7077)为不要指定web端口(默认8080)
            "--master", "spark://hadoop01:7077",
                    "--name", "test java submit job to spark",
                    "--class", "cn.xzxy.yjt.demo.MaxMin",   //类名
                    "/home/ofo/bishe/jar/spark95.jar",  //执行jar路径
                    "/home/ofo/bishe/MaxMin.txt"  //输入文件
        };
        SparkSubmit.main(args);
    }
}
