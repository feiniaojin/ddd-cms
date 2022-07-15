package com.feiniaojin.ddd.cms.application.article.dto;

import lombok.Data;

@Data
public class ArticleCreateCmd {
    private String title;
    private String content;
}
