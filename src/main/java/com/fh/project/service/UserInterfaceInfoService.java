package com.fh.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fh.jrapicommon.model.entity.UserInterfaceInfo;

/**
 * 用户接口信息服务
 *
   
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 为用户分配接口调用次数
     * @param interfaceId
     * @param userId
     * @param times
     * @return
     */
    boolean distributeInterfaceInvokeTimes(long interfaceId, long userId, int times);

    /**
     * 用户充值接口调用次数
     * @param interfaceName
     * @param userName
     * @param times
     * @return
     */
    boolean payInterface(String interfaceName, String userName, Integer times);
}
