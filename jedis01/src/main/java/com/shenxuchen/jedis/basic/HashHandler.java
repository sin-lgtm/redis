package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 15:19
 */
//测试指令 hset hget hgetall hkeys
public class HashHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        HashMap<String,String> map = new HashMap<>();
        map.put("name","xjb");
        map.put("characteristic","quiet");
        map.put("charm","9");
        jedis.hset("loving",map);
        String hget = jedis.hget("loving", "name");
        System.out.println(hget);
        Set<String> loving = jedis.hkeys("loving");
        System.out.println(loving);
        Map<String, String> loving1 = jedis.hgetAll("loving");
        System.out.println(loving1);
    }
}
