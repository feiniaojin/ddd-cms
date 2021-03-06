package com.feiniaojin.ddd.cms.domain.article.primitive;

import com.feiniaojin.ddd.EntityId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class ArticleId implements EntityId<String> {
    private String value;

    public ArticleId() {
    }

    public ArticleId(String value) {
        this.check(value);
        this.value = value;
    }

    public void setValue(String value) {
        this.check(value);
        this.value = value;
    }

    private void check(String value) {
        Objects.requireNonNull(value);
        if ("".equals(value)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
