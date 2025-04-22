package com.shenxuchen.test;

import com.shenxuchen.jedis.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassDescription:
 * @JdkVersion: 2.1
 * @Author: 沈诩宸
 * @Created: 2024/10/28 11:35
 */
public class JedisTest {
    private Jedis jedis;
    @BeforeEach
    void setUp() {
        // 1.建立连接
//         jedis = new Jedis("", 6379);
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        jedis.auth("123456");
        // 3.选择库
        jedis.select(0);
    }
    @Test
    void testSting(){
        String s = jedis.set("name", "杰克");
        System.out.println("s = " + s);
        String s1 = jedis.get("name");
        System.out.println("s1 = " + s1);

    }
    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
