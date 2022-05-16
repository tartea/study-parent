package org.tartea;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class ApiTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.delete("count");

        Long count = redisTemplate.opsForValue().increment("count",300);
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadAdd();
                }
            }).start();
        }

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    private void threadAdd() {
        for (int i = 0; i < 50; i++) {
            add();
        }
        System.out.println(Thread.currentThread().getName() + "当前方法--" + get());
    }

    private void add() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Long count = redisTemplate.opsForValue().increment("count");
    }

    private Object get() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get("count");
    }

}
