package com.feiniaojin.ddd.cms.domain.article;

public interface ArticleDomainFactory {
    ArticleEntity newInstance(String title, String content);
}
