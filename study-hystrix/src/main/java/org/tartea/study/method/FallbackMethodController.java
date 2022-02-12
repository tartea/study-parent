package org.tartea.study.method;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {


    @RequestMapping("getUserName")
    public String getUserName() {
        try {
            //模拟停顿时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is method";
    }


    @RequestMapping("getUserNameFallBack")
    @HystrixCommand(
            fallbackMethod = "getFallbackMethod"// 服务降级方法
    )
    public String getUserNameFallBack(@RequestParam String timeout) {
        System.out.println("---------------");
        try {
            //模拟停顿时间
            Thread.sleep(Integer.parseInt(timeout));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is a success method";
    }

    /**
     * fall back method
     *
     * @return
     */
    private String getFallbackMethod(String timeout) {

        return "this is a fallback method";
    }


}
