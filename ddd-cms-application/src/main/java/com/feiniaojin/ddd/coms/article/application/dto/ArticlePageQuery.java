package com.feiniaojin.ddd.coms.article.application.dto;

import lombok.Data;

@Data
public class ArticlePageQuery {
    /**
     * 当前页，自然顺序，从1开始
     */
    private Integer page = 1;
    /**
     * 分页大小
     */
    private Integer pageSize = 20;
    /**
     * 校招信息搜索关键字
     */
    private String keyword;
}
