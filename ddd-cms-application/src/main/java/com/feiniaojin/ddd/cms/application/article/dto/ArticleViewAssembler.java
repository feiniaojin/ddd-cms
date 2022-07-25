package com.feiniaojin.ddd.cms.application.article.dto;

import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ArticleViewAssembler {

    public ArticleView assembler(ArticleEntity entity) {

        ArticleView view = new ArticleView();
        view.setArticleId(entity.getArticleId().getValue());
        view.setTitle(entity.getArticleTitle().getValue());
        view.setContent(entity.getContent().getValue());
        view.setPv(ThreadLocalRandom.current().nextInt(999999));
        return view;
    }
}
