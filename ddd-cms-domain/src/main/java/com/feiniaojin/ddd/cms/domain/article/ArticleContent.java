package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.cms.domain.ModelMask;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import lombok.Data;

@Data
public class ArticleContent extends ModelMask {

    ArticleId articleId;

    private String content;

}
