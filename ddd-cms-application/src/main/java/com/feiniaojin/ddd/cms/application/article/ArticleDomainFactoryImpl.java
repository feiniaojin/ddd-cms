package com.feiniaojin.ddd.cms.application.article;

import com.feiniaojin.ddd.cms.domain.article.ArticleContent;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainFactory;
import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArticleDomainFactoryImpl implements ArticleDomainFactory {

    @Override
    public ArticleEntity newInstance(String title, String content) {

        ArticleEntity entity = new ArticleEntity();

        ArticleId articleId = new ArticleId(generateId());
        entity.setArticleId(articleId);

        entity.setTitle(title);

        ArticleContent articleContent = new ArticleContent();
        articleContent.setArticleId(articleId);
        articleContent.setContent(content);
        articleContent.setDeleted(0);

        entity.setContent(articleContent);
        entity.setDeleted(0);

        return entity;
    }

    /**
     * 生成唯一ID，未来在这个地方替换成基础设施的ID服务
     *
     * @return
     */
    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
