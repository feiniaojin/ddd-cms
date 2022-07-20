package com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper;

import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.data.CmsArticleContent;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Generated;

/**
 * 表名称：cms_article_content自动生成的Mapper
 * 表注释：article扩展表
 * NOTICE:本文件由代码生成器naaf-generator生成，不要在本文件手工追加任何内容，因为随时可能重新生成替换
 * github：https://github.com/feiniaojin/naaf-generator
 */
@Generated("generator")
public interface CmsArticleContentMapper {
    int insert(CmsArticleContent record);
    CmsArticleContent findOneById(@Param("id")Long id);
}