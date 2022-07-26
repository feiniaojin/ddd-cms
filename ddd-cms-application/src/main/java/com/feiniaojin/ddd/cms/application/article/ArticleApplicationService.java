package com.feiniaojin.ddd.cms.application.article;

import com.feiniaojin.ddd.cms.application.article.dto.*;
import com.feiniaojin.ddd.cms.domain.article.*;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleContent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleTitle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j

public class ArticleApplicationService {

    @Resource
    private ArticleDomainFactory domainFactory;

    @Resource
    private ArticleDomainRepository domainRepository;

    @Resource
    private ArticleDomainEventPublisher domainEventPublisher;

    @Resource
    private ArticleViewAssembler articleViewAssembler;

    /**
     * 创建Article的草稿
     *
     * @param cmd
     */
    public void newDraft(ArticleCreateCmd cmd) {
        ArticleEntity articleEntity = domainFactory.newInstance(new ArticleTitle(cmd.getTitle()),
                new ArticleContent(cmd.getContent()));
        articleEntity.createDraft();
        domainRepository.save(articleEntity);
        domainEventPublisher.publish(articleEntity.domainEvents());
    }

    /**
     * 将校招信息发布到就业信息办网站
     *
     * @param cmd
     */
    public void publishArticle(ArticlePublishCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.publishArticle();
        domainEventPublisher.publish(entity.domainEvents());
    }

    public ArticleView detail(ArticlePageQuery query) {

        ArticleEntity entity = domainRepository.load(new ArticleId(query.getArticleId()));

        return articleViewAssembler.assembler(entity);
    }

    @Retryable(value = OptimisticLockingFailureException.class, maxAttempts = 2)
    public void modifyTitle(ArticleModifyTitleCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyTitle(new ArticleTitle(cmd.getTitle()));
        domainRepository.save(entity);
        domainEventPublisher.publish(entity.domainEvents());
    }

    @Retryable(value = OptimisticLockingFailureException.class, maxAttempts = 2)
    public void modifyContent(ArticleModifyContentCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyContent(ArticleContent.newInstanceFrom(entity.getContent(),
                cmd.getContent()));
        domainRepository.save(entity);
        domainEventPublisher.publish(entity.domainEvents());
    }
}
