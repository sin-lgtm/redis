package com.shenxuchen.jedis;

import redis.clients.jedis.Jedis;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
//看得见吗
/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 16:35
 */
public class CodeTest {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        send("1190", jedis);
    }

    //生成6位随机的验证码
    private static String generateCode() {
        return new DecimalFormat("000000").format(new Random().nextInt(1000000));
    }

    //发送验证码
    private static void send(String phone, Jedis jedis) {
        String codeKey = "v:"+phone + ":code";
        String countKey ="v:"+ phone + ":count";
        String s = jedis.get(countKey);
        if (s == null) {
            jedis.setex(countKey, 60 * 60 * 24, "1");
        } else if (Integer.parseInt(s) < 3) {
            jedis.incr(countKey);
        } else {
            System.out.println("你今天已发送三次请求,请于24小时后再发送");
            jedis.close();
            return;
        }
        //验证码设置5分钟的有效期
        jedis.setex(codeKey, 60 * 5, generateCode());
        jedis.close();
        verify(phone,jedis);
    }

    //验证
    private static void verify(String phone,Jedis jedis) {
        System.out.println("请输入验证码");
        String code1 = new Scanner(System.in).next();
        String codeKey = "v:"+phone + ":code";
        String code = jedis.get(codeKey);
        if (code1.equals(code)) System.out.println("验证通过");
        else System.out.println("验证失败,验证码不正确");

    }
}
