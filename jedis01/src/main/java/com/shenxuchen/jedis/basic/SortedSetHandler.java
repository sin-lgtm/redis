package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 15:55
 */
//测试指令 zadd zscore zrank zrange zrangebyscore
public class SortedSetHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.zadd("k1",7,"sixiao");
        jedis.zadd("k1",9,"liuzhong");
        jedis.zadd("k1",3,"sizhong");
        jedis.zadd("k1",10,"liaogong");
        Double zscore = jedis.zscore("k1", "liuzhong");
        System.out.println(zscore);
        Long zrank = jedis.zrank("k1", "liaogong");
        System.out.println(zrank);
        List<String> k1 = jedis.zrange("k1", 0, 2);
        System.out.println(k1);
        List<String> k2 = jedis.zrangeByScore("k1", 0, 100);
        System.out.println(k2);
    }
}
