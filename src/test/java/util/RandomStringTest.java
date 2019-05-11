package util;

import cn.xzxy.lewy.iaweb.util.RandomStringUtil;

public class RandomStringTest {

    public static void main(String[] args) {

        String rst = RandomStringUtil.getRandomCode(6,0);

        System.out.println("p" + rst); ;
    }
}
