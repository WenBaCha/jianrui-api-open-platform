package com.fh.project.service;

import com.fh.jrapiclientsdk.client.JrApiClient;
import com.fh.jrapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GatewayTest {
    @Test
    void testGetUser() {
        JrApiClient client = new JrApiClient("jiangrun", "yfh");
        User user = new User();
        user.setUsername("zhangsan");
        String username = client.getUsernameByPost(user);
        System.out.println(username);
    }

}
