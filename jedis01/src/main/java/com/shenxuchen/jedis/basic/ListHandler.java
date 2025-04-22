package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 14:54
 */
// 测试指令 lpush lrange lpop lrem llen
public class ListHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.lpush("lovedGirls","wmz","xjb");
        List<String> girls= jedis.lrange("lovedGirls", 0, -1);
        System.out.println(girls);
        jedis.lpop("lovedGirls");
        List<String> lovedGirls = jedis.lrange("lovedGirls", 0, -1);
        System.out.println(lovedGirls);
    }
}
