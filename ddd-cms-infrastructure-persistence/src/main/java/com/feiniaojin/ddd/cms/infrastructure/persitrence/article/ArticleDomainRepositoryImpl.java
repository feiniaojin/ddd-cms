package com.feiniaojin.ddd.cms.infrastructure.persitrence.article;

import com.feiniaojin.ddd.cms.domain.article.ArticleDomainRepository;
import com.feiniaojin.ddd.cms.domain.article.ArticleEntity;
import com.feiniaojin.ddd.cms.domain.article.PublishState;
import com.feiniaojin.ddd.cms.domain.article.exceptions.NotFoundDomainException;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleContent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleTitle;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.data.CmsArticle;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.data.CmsArticleContent;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.jdbc.CmsArticleContentRepository;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.jdbc.CmsArticleRepository;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper.CmsArticleContentMapperEx;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper.CmsArticleMapper;
import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper.CmsArticleMapperEx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Slf4j
public class ArticleDomainRepositoryImpl implements ArticleDomainRepository {

    @Resource
    private CmsArticleRepository cmsArticleRepository;

    @Resource
    private CmsArticleContentRepository cmsArticleContentRepository;

    @Resource
    private CmsArticleMapper cmsArticleMapper;

    @Resource
    private CmsArticleMapperEx articleMapperEx;

    @Resource
    private CmsArticleContentMapperEx contentMapperEx;

    @Override
    public ArticleEntity load(ArticleId articleId) {

        CmsArticle article = articleMapperEx.findOneByBizId(articleId.getValue());
        if (article == null) {
            log.error("查询不到article,articleId=[{}]", articleId.getValue());
            throw new NotFoundDomainException();
        }

        ArticleEntity entity = new ArticleEntity();
        entity.setArticleTitle(new ArticleTitle(article.getTitle()));
        entity.setPublishState(PublishState.getByCode(article.getPublishState()).getCode());
        entity.setArticleId(articleId);

        entity.setVersion(article.getVersion());
        entity.setId(article.getId());
        entity.setCreatedBy(article.getCreatedBy());
        entity.setCreatedTime(article.getCreatedTime());
        entity.setModifiedTime(article.getModifiedTime());
        entity.setModifiedBy(article.getModifiedBy());
        entity.setDeleted(article.getDeleted());

        CmsArticleContent content = contentMapperEx.findOneByBizId(articleId.getValue());

        ArticleContent articleContent = new ArticleContent();
        articleContent.setValue(content.getContent());

        articleContent.setVersion(content.getVersion());
        articleContent.setId(content.getId());
        articleContent.setCreatedBy(content.getCreatedBy());
        articleContent.setCreatedTime(content.getCreatedTime());
        articleContent.setModifiedTime(content.getModifiedTime());
        articleContent.setModifiedBy(content.getModifiedBy());
        articleContent.setDeleted(content.getDeleted());

        entity.setContent(articleContent);

        return entity;
    }


    @Override
    @Transactional
    public void save(ArticleEntity entity) {

        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setTitle(entity.getArticleTitle().getValue());
        //region
        cmsArticle.setArticleId(entity.getArticleId().getValue());
        cmsArticle.setPublishState(entity.getPublishState());

        cmsArticle.setId(entity.getId());
        cmsArticle.setCreatedBy(entity.getCreatedBy());
        cmsArticle.setCreatedTime(entity.getCreatedTime());
        cmsArticle.setModifiedBy(entity.getModifiedBy());
        cmsArticle.setModifiedTime(entity.getModifiedTime());
        cmsArticle.setVersion(entity.getVersion());
        cmsArticle.setDeleted(entity.getDeleted());
        //endregion
        ArticleContent content = entity.getContent();
        CmsArticleContent cmsArticleContent = new CmsArticleContent();
        cmsArticleContent.setContent(content.getValue());
        //region
        cmsArticleContent.setArticleId(entity.getArticleId().getValue());

        cmsArticleContent.setId(content.getId());
        cmsArticleContent.setVersion(content.getVersion());
        cmsArticleContent.setDeleted(content.getDeleted());
        cmsArticleContent.setCreatedBy(content.getCreatedBy());
        cmsArticleContent.setCreatedTime(content.getCreatedTime());
        cmsArticleContent.setModifiedBy(content.getModifiedBy());
        cmsArticleContent.setModifiedTime(content.getModifiedTime());
        //endregion
        cmsArticleRepository.save(cmsArticle);
        cmsArticleContentRepository.save(cmsArticleContent);
    }
}
