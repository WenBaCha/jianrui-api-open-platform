package com.fh.project.service.impl.inner;

import com.fh.project.service.UserInterfaceInfoService;
import com.fh.jrapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部用户接口信息服务实现类
 *
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    /**
     * 该用户是否还有该接口的调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean isLeft(long interfaceInfoId, long userId) {
        // 当前用户调用该接口的剩余次数
        Integer leftNum = userInterfaceInfoService.query()
                .eq("interfaceInfoId", interfaceInfoId)
                .eq("userId",userId)
                .one().getLeftNum();
        if(leftNum <= 0||leftNum == null){
            return false;
        }
        return true;
    }


}
