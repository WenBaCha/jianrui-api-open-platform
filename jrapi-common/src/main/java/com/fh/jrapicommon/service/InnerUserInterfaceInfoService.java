package com.fh.jrapicommon.service;

/**
 * 内部用户接口信息服务
 *
   
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 是否有调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean isLeft(long interfaceInfoId, long userId);
}
