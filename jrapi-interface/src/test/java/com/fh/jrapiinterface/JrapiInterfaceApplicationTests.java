package com.fh.jrapiinterface;

import com.fh.jrapiclientsdk.client.JrApiClient;
import com.fh.jrapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 测试类
 *
   
 */
@SpringBootTest
class JrapiInterfaceApplicationTests {

    @Resource
    private JrApiClient jrApiClient;

    @Test
    void contextLoads() {
        String result = jrApiClient.getNameByGet("fh");
        User user = new User();
        user.setUsername("saf");
        String usernameByPost = jrApiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
