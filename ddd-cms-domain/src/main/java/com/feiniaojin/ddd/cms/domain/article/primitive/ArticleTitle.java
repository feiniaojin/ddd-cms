package com.feiniaojin.ddd.cms.domain.article.primitive;

import com.feiniaojin.ddd.ValueObject;

import java.util.Objects;

public class ArticleTitle implements ValueObject<String> {

    private String value;

    public ArticleTitle() {
    }

    public ArticleTitle(String value) {
        this.check(value);
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.check(value);
        this.value = value;
    }

    private void check(String value) {
        Objects.requireNonNull(value, "title不能为空");
        if ("".equals(value) || value.length() > 64) {
            throw new IllegalArgumentException();
        }
    }
}
