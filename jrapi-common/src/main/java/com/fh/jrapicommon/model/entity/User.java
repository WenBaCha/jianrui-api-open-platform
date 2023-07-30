package com.fh.jrapicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fh.jrapicommon.model.constants.Constants;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
   
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 签名 accessKey
     */
    private String accessKey;

    /**
     * 签名 secretKey
     */
    private String secretKey;

    /**
     * 创建时间
     */
    @JsonFormat(pattern=Constants.DATETIME_FORMAT, timezone = Constants.TIME_ZONE)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern= Constants.DATETIME_FORMAT, timezone = Constants.TIME_ZONE)
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}