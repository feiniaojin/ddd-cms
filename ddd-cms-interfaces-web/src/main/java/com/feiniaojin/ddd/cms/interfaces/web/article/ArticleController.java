package com.feiniaojin.ddd.cms.interfaces.web.article;

import com.feiniaojin.ddd.cms.application.article.ArticleApplicationService;
import com.feiniaojin.ddd.cms.application.article.dto.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleApplicationService articleApplicationService;

    @RequestMapping("/createArticleDraft")
    public void createArticleDraft(@RequestBody ArticleCreateCmd cmd) {
        articleApplicationService.newDraft(cmd);
    }

    @RequestMapping("/modifyTitle")
    public void modifyTitle(@RequestBody ArticleModifyTitleCmd cmd) {
        articleApplicationService.modifyTitle(cmd);
    }

    @RequestMapping("/modifyContent")
    public void modifyTitle(@RequestBody ArticleModifyContentCmd cmd) {
        articleApplicationService.modifyContent(cmd);
    }

    @RequestMapping("/readArticle")
    public ArticleView readArticle(@RequestBody ArticlePageQuery query) {
        return articleApplicationService.detail(query);
    }

}
