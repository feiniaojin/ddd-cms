package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleContent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleTitle;

public interface ArticleDomainFactory {
    ArticleEntity newInstance(ArticleTitle articleTitle, ArticleContent articleContent);
}
