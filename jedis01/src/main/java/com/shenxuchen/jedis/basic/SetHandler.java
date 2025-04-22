package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 15:40
 */
//测试指令 sadd smembers sismember scard sdiff sinter
public class SetHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.sadd("k1","a","b","c");
        jedis.sadd("k2","b","c","d","e");
        Set<String> k2 = jedis.smembers("k2");
        System.out.println(k2);
        boolean sismember = jedis.sismember("k1", "e");
        System.out.println(sismember);
        Set<String> sdiff = jedis.sdiff("k2", "k1");
        System.out.println(sdiff);
        Set<String> sinter = jedis.sinter("k1", "k2");
        System.out.println(sinter);
    }
}
