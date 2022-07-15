package com.feiniaojin.ddd.cms.interfaces.web.article;

import com.feiniaojin.ddd.cms.application.article.ArticleApplicationService;
import com.feiniaojin.ddd.cms.application.article.dto.ArticlePageQuery;
import com.feiniaojin.ddd.cms.application.article.dto.ArticleView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleApplicationService articleApplicationService;

    @RequestMapping("/readArticle")
    public ArticleView readArticle(ArticlePageQuery query) {
        return articleApplicationService.detail(query);
    }
}
