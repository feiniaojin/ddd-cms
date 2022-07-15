package com.feiniaojin.ddd.cms.interfaces.web;

import com.feiniaojin.ddd.cms.article.application.ArticleApplicationService;
import com.feiniaojin.ddd.cms.article.application.dto.ArticlePageQuery;
import com.feiniaojin.ddd.cms.article.application.dto.ArticleView;
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
