package com.shenxuchen.springdata01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shenxuchen.springdata01.config.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springdata01ApplicationTests {
    @Autowired
    private StringRedisTemplate  redisTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("love","xjb");
        Object o = redisTemplate.opsForValue().get("love");
        System.out.println(STR."o = \{o}");
    }
    @Test
    void test1() throws JsonProcessingException {
        User user = new User("sxy",21);
        String s = mapper.writeValueAsString(user);
        redisTemplate.opsForValue().set("cg",s);
        String s1 = redisTemplate.opsForValue().get("cg");
        User user1 = mapper.readValue(s1, User.class);
        System.out.println("user1 = " + user1);
    }
    @Test
    void testHash(){
        redisTemplate.opsForHash().put("girl","1","小金宝" );
        Object o = redisTemplate.opsForHash().get("girl", "1");
        System.out.println("o = " + o);
    }
}
