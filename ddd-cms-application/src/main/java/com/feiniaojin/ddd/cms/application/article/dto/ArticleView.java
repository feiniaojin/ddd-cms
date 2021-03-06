package com.feiniaojin.ddd.cms.application.article.dto;

import lombok.Data;

@Data
public class ArticleView {
    private String articleId;
    private String title;
    private String content;
    private Integer pv;
}
