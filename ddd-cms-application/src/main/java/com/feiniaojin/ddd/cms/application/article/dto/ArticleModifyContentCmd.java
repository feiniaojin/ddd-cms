package com.feiniaojin.ddd.cms.application.article.dto;

import lombok.Data;

@Data
public class ArticleModifyContentCmd {
    private String articleId;
    private String content;
}
