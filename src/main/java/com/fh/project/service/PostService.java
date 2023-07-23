package com.fh.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fh.project.model.entity.Post;

/**
 * 帖子服务
 *
   
 */
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post
     * @param add 是否为创建校验
     */
    void validPost(Post post, boolean add);
}
