package com.shenxuchen.jedis.homework;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 17:04
 */
public class Prize {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.sadd("prize","zhangsan","lisi","wangwu","zhaoliu");
        String prizePerson = jedis.srandmember("prize");
        System.out.println(prizePerson+"中奖了");

    }
}
