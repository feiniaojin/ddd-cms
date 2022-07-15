package com.feiniaojin.ddd.cms.infrastructure.persitrence;

import com.feiniaojin.ddd.cms.domain.article.ArticleDomainRepository;
import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import com.feiniaojin.ddd.cms.domain.article.ArticleState;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.data.CmsArticle;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.jdbc.CmsArticleRepository;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.mapper.CmsArticleMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ArticleDomainRepositoryImpl implements ArticleDomainRepository {

    @Resource
    private CmsArticleRepository cmsArticleRepository;

    @Resource
    private CmsArticleMapper cmsArticleMapper;

    @Override
    public ArticleEntity load(ArticleId articleId) {

        CmsArticle oneByBizId = cmsArticleMapper.findOneByBizId(articleId.getEntityIdValue());

        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(entity.getTitle());
        entity.setArticleState(ArticleState.getByCode(1));
        //TODO 填充ext信息

        return entity;
    }

    @Override
    public void save(ArticleEntity entity) {

        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setTitle(entity.getTitle());
        cmsArticle.setArticleId(entity.getArticleId().getEntityIdValue());

        cmsArticleRepository.save(cmsArticle);
    }
}
