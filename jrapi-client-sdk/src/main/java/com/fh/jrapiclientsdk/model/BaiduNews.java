package com.fh.jrapiclientsdk.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName baidu_news
 */
@Data
public class BaiduNews implements Serializable {
    /**
     * id
     */

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


    private static final long serialVersionUID = 1L;
}