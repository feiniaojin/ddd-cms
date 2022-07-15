package com.feiniaojin.ddd.cms.domain.article;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ArticleState {
    TO_PUBLISH(1, "待发布"),
    PUBLISHED(2, "已发布"),
    ;
    private final Integer code;
    private final String msg;

    private static Map<Integer, ArticleState> map = Arrays.stream(ArticleState.values()).collect(Collectors.toMap(ArticleState::getCode, s -> s));

    public static ArticleState getByCode(Integer code) {
        return map.get(code);
    }
}
