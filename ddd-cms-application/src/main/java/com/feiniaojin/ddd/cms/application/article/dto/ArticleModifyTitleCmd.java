package com.feiniaojin.ddd.cms.application.article.dto;

import lombok.Data;

@Data
public class ArticleModifyTitleCmd {
    private String articleId;
    private String title;
}
