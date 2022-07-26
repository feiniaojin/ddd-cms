package com.feiniaojin.ddd.cms.domain.article.primitive;

import com.feiniaojin.ddd.ValueObject;
import com.feiniaojin.ddd.cms.domain.AbstractDomainMask;

import java.util.Objects;

public class ArticleContent extends AbstractDomainMask implements ValueObject<String> {

    private String value;

    public ArticleContent() {
    }

    public ArticleContent(String value) {
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

    /**
     * 从一个旧的ArticleContent中得到一个新的ArticleContent
     * @param old
     * @param value
     * @return
     */
    public static ArticleContent newInstanceFrom(AbstractDomainMask old, String value) {

        ArticleContent newContent = new ArticleContent();

        newContent.setDeleted(old.getDeleted());
        newContent.setCreatedBy(old.getCreatedBy());
        newContent.setCreatedTime(old.getCreatedTime());
        newContent.setModifiedBy(old.getModifiedBy());
        newContent.setModifiedTime(old.getModifiedTime());
        newContent.setVersion(old.getVersion());
        newContent.setId(old.getId());

        newContent.setValue(value);
        return newContent;
    }

}
