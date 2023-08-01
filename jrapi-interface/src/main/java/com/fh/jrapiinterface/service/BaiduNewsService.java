package com.fh.jrapiinterface.service;

import com.fh.jrapiinterface.domain.entity.BaiduNews;

import java.io.IOException;
import java.util.List;

/**
* @author Administrator
* @description 针对表【baidu_news】的数据库操作Service
* @createDate 2023-07-30 16:28:01
*/
public interface BaiduNewsService  {

     List<BaiduNews> getBaiduNews() throws IOException;
}
