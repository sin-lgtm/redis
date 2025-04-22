package com.shenxuchen.jedis.homework;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.Scanner;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 17:24
 */
public class Login {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.set("zhangliang:password", "666");
        System.out.println("请输入用户");
        Scanner scanner = new Scanner(System.in);
        String nextUser = scanner.next();
        System.out.println("请输入密码");
        String nextPwd = scanner.next();
        String s = jedis.get("count");

        if (nextPwd.equals(jedis.get(nextUser + ":password"))) {
            System.out.println("登陆成功");
            jedis.set("count", "0");
        } else {
            System.out.println("登录失败,账号或密码错误");
            if (s == null) {
                jedis.setex("count", 60 * 60 * 24, "1");
            } else if (Integer.parseInt(s) < 3) {
                jedis.incr("count");
            } else {
                System.out.println("你已三次登录失败,请24h后再重试");
            }
        }
    }

}
