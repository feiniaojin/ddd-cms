package com.feiniaojin.ddd.cms.article.application.dto;

import lombok.Data;

@Data
public class ArticleCreateCmd {
    private String title;
    private String content;
}
