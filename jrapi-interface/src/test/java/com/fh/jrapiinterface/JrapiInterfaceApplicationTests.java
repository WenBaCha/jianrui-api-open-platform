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
        Document document = Jsoup.connect(BaiduConstants.BAIDUNEWS_URL).get();
        // 获取新闻列表
        Elements list = document.select("div.category-wrap_iQLoo");
        // 创建List存储所有的新闻
        LinkedList<BaiduNews> news = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getElementsByClass("c-single-text-ellipsis").html();
            String description = list.get(i).getElementsByClass("ellipsis_DupbZ").html();
            String searchNum = list.get(i).getElementsByClass("hot-index_1Bl1a").html();
            BaiduNews baiduNews = new BaiduNews();
            baiduNews.setKeyword(title);
            baiduNews.setSearchNum(Integer.valueOf(searchNum));
            baiduNews.setDescription(description.split("\n")[0]);
            System.out.println(baiduNews);
            news.add(baiduNews);
        }
        System.out.println(news);
    }

}
