package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleContent;

public interface ArticleDomainFactory {
    ArticleEntity newInstance(String title, ArticleContent articleContent);
}
