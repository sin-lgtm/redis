package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 14:31
 */
//jedis测试redis常见指令
//ping flushDB
//set get mset mget setex(ttl key可查看key的过期时间)
public class StringHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.setex("k8",30,"v8");
    }
}
