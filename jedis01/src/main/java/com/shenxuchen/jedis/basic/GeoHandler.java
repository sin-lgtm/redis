package com.shenxuchen.jedis.basic;

import com.shenxuchen.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.GeoUnit;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2025/2/4 16:13
 */
//测试指令 geoadd geodist
public class GeoHandler {
    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.geoadd("love", 129.520497, 42.899438, "wife");
        jedis.geoadd("love", 118.340801, 35.060867, "husband");
        Double geodist = jedis.geodist("love", "wife", "husband", GeoUnit.KM);
        System.out.println("geodist = " + geodist + "km");

    }
}
