package util;

import java.util.Date;

public class DateFormatTest {

    private static String timeStamp() {
        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);
    }

    public static void main(String[] args) {
        String timeStamp = timeStamp();
        System.out.println("timeStamp=" + timeStamp); //运行输出:timeStamp=1470278082
        System.out.println(System.currentTimeMillis());//运行输出:1470278082980


        String rs= "1555355855023";
        Date date = new Date(Long.valueOf(rs));
        System.out.println(date);
    }
}
