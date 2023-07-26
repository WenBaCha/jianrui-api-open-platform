package com.fh.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fh.project.exception.BusinessException;
import com.fh.project.mapper.UserInterfaceInfoMapper;
import com.fh.project.service.UserInterfaceInfoService;
import com.fh.project.common.ErrorCode;
import com.fh.project.mapper.InterfaceInfoMapper;
import com.fh.project.mapper.UserMapper;
import com.fh.jrapicommon.model.entity.InterfaceInfo;
import com.fh.jrapicommon.model.entity.User;
import com.fh.jrapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户接口信息服务实现类
 *
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }
    
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 根据接口信息 id和用户id去数据库中查找，判断是否存在
        UserInterfaceInfo us = this.query().eq("interfaceInfoId", interfaceInfoId).eq("userId", userId).one();
        // 若不存在 ，抛出异常
        if(us == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "不存在该记录，请联系管理员添加");
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

    /**
     * 为用户分配接口调用次数
     * @param interfaceId
     * @param userId
     * @param times
     * @return
     */
    @Override
    public boolean distributeInterfaceInvokeTimes(long interfaceId, long userId, int times) {
        // 判断id是否合法
        if (interfaceId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 判断接口id和用户 id是否存在
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectById(interfaceId);
        User user = userMapper.selectById(userId);
        if(interfaceInfo ==  null  || user == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"接口或用户不存在");
        }
        // 根据接口信息 id和用户id去数据库中查找，判断是否存在
        UserInterfaceInfo us = this.query().eq("interfaceInfoId", interfaceId).eq("userId", userId).one();
        // 若不存在，则插入
        if(us == null){
            UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
            userInterfaceInfo.setInterfaceInfoId(interfaceId);
            userInterfaceInfo.setUserId(userId);
            userInterfaceInfo.setTotalNum(times);
            userInterfaceInfo.setLeftNum(times);
            this.baseMapper.insert(userInterfaceInfo);
        }else{
            // 若存在，则leftNum + times
            us.setLeftNum(us.getLeftNum() + times);
            updateById(us);
        }
        return true;
    }

}




