package com.feiniaojin.ddd.coms.article.application.dto;

import lombok.Data;

@Data
public class ArticleView {
    private String title;
    private String content;
    private Integer pv;
}
