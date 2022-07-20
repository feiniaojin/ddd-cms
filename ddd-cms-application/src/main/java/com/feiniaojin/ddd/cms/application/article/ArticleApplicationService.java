package com.feiniaojin.ddd.cms.application.article;

import com.feiniaojin.ddd.cms.application.article.dto.*;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainEventPublisher;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainFactory;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainRepository;
import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import lombok.extern.slf4j.Slf4j;
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

        if (log.isInfoEnabled()) {
            log.info("创建草稿,cmd=[{}]", cmd.toString());
        }

        ArticleEntity articleEntity = domainFactory.newInstance(cmd.getTitle(), cmd.getContent());

        articleEntity.createDraft();

        domainRepository.save(articleEntity);

        domainEventPublisher.publish(articleEntity.domainEvents());
    }

    /**
     * 将校招信息发布到就业信息办网站
     *
     * @param cmd
     */
    public void publishOnWebsite(ArticlePublishCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.publishOnWebsite();
        domainEventPublisher.publish(entity.domainEvents());
    }

    public ArticleView detail(ArticlePageQuery query) {

        ArticleEntity entity = domainRepository.load(new ArticleId(query.getArticleId()));

        return articleViewAssembler.assembler(entity);
    }

    public void modifyTitle(ArticleModifyTitleCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyTitle(cmd.getTitle());
        domainRepository.save(entity);
        domainEventPublisher.publish(entity.domainEvents());
    }

    public void modifyContent(ArticleModifyContentCmd cmd) {
        ArticleEntity entity = domainRepository.load(new ArticleId(cmd.getArticleId()));
        entity.modifyContent(cmd.getContent());
        domainRepository.save(entity);
        domainEventPublisher.publish(entity.domainEvents());
    }
}
