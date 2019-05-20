package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

    private static String timeStamp() {
        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);
    }

    public static void main(String[] args) {
        //String timeStamp = timeStamp();
        //System.out.println("timeStamp=" + timeStamp); //运行输出:timeStamp=1470278082
        //System.out.println(System.currentTimeMillis());//运行输出:1470278082980

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String rs= "1555355855023";
        Date date = new Date(Long.valueOf(rs));
        String parseDate = sdf.format(date);
        String path = "hdfs://hadoop01:9000/itemdata/reportTime=" + parseDate;
        System.out.println(path);
    }
}
