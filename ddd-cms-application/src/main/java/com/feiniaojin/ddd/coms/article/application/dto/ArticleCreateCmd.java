package com.feiniaojin.ddd.coms.article.application.dto;

import lombok.Data;

@Data
public class ArticleCreateCmd {
    private String title;
    private String content;
}
