package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;

public interface ArticleDomainRepository {

    ArticleEntity load(ArticleId articleId);

    void save(ArticleEntity entity);
}
