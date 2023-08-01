package com.fh.project.service;

import com.fh.jrapicommon.model.entity.InterfaceInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户接口信息服务测试
 *
   
 */
@SpringBootTest
public class UserInterfaceInfoServiceTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private InterfaceInfoService interfaceInfoService;
    @Test
    public void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1L, 1L);
        Assertions.assertTrue(b);
    }

    @Test
    void testDistributeInterfaceInvokeTimes() {
        List<InterfaceInfo> interfaceInfos = interfaceInfoService.list();

        for(InterfaceInfo interfaceInfo : interfaceInfos){
            userInterfaceInfoService.distributeInterfaceInvokeTimes(interfaceInfo.getId(),1676894789951356931L,50);
        }

    }
}