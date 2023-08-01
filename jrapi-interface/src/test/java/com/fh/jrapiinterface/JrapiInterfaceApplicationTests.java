package com.fh.jrapiinterface;

import com.fh.jrapiinterface.domain.constants.BaiduConstants;
import com.fh.jrapiinterface.domain.entity.BaiduNews;
import com.fh.jrapiinterface.service.BaiduNewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 测试类
 *
   
 */
@SpringBootTest
class JrapiInterfaceApplicationTests {

    @Resource
    private BaiduNewsService baiduNewsService;


    @Test
    void testCrawler() throws IOException {


    }

}
