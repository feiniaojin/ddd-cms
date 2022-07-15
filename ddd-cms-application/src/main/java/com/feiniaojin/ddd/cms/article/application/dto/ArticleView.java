package com.feiniaojin.ddd.cms.article.application.dto;

import lombok.Data;

@Data
public class ArticleView {
    private String title;
    private String content;
    private Integer pv;
}
