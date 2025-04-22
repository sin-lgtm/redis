package com.shenxuchen.jedis.homework;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 17:06
 */
public class HotSearch {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        List<String> events = new ArrayList<>();
        events.add("event1");
        events.add("event2");
        jedis.zadd("hot", 10, "event1");
        jedis.zadd("hot", 10, "event2");
        System.out.println("开始搜索,break输入结束搜索查看热度排行");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if ("break".equals(next)) break;
            if (events.contains(next)) {
                jedis.zincrby("hot", 10, next);
                System.out.println(next + "事件热度已加10");
            } else {
                jedis.zadd("hot", 10, next);
                events.add(next);
                System.out.println(next + "事件已被添加并赋热度初始值10");
            }
        }
        List<String> hot = jedis.zrange("hot", 0, -1);
        System.out.println("搜索热度 = " + hot);
    }
}
