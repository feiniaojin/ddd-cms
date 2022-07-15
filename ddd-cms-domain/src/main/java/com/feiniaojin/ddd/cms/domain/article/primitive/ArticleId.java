package com.feiniaojin.ddd.cms.domain.article.primitive;

import com.feiniaojin.ddd.EntityId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ArticleId implements EntityId<String> {
    private String value;

    @Override
    public String getEntityIdValue() {
        return value;
    }
}
