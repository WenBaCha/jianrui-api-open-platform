package com.fh.jrapiinterface.controller;

import com.fh.jrapiclientsdk.model.User;
import com.fh.jrapiinterface.domain.entity.BaiduNews;
import com.fh.jrapiinterface.service.BaiduNewsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author fanhe
 **/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private BaiduNewsService baiduNewsService;

    /**
     * 从百度热搜榜上获取数据
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/get")
    public List<BaiduNews> getBaiduNews(HttpServletRequest request) throws IOException {
        List<BaiduNews> baiduNews = baiduNewsService.getBaiduNews();
        return baiduNews;
    }
}
