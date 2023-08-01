package com.fh.jrapiinterface.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @TableName baidu_news
 */
@Data
public class BaiduNews implements Serializable {
    /**
     * id
     */
    @TableId
    private Integer id;

    /**
     * 关键词
     */
    private String keyword;


    /**
     * 简要描述
     */
    private String description;

    /**
     * 热搜指数
     */
    private Integer searchNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}