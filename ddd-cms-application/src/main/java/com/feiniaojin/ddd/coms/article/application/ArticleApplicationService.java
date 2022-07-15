package com.feiniaojin.ddd.coms.article.application;

import com.feiniaojin.ddd.cms.domain.article.ArticleDomainEventPublisher;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainFactory;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainRepository;
import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import com.feiniaojin.ddd.coms.article.application.dto.ArticleCreateCmd;
import com.feiniaojin.ddd.coms.article.application.dto.ArticlePublishCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleApplicationService {

    @Resource
    private ArticleDomainFactory domainFactory;

    @Resource
    private ArticleDomainRepository domainRepository;


    private ArticleDomainEventPublisher domainEventPublisher;

    /**
     * 创建Article的草稿
     *
     * @param cmd
     */
    public void createDraft(ArticleCreateCmd cmd) {

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
}
