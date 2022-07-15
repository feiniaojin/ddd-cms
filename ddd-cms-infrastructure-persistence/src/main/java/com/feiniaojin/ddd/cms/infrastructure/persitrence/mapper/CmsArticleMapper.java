package com.feiniaojin.ddd.cms.infrastructure.persitrence.mapper;

import com.feiniaojin.ddd.cms.infrastructure.persitrence.data.CmsArticle;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Generated;

/**
 * 表名称：cms_article自动生成的Mapper
 * 表注释：article主表
 * NOTICE:本文件由代码生成器naaf-generator生成，不要在本文件手工追加任何内容，因为随时可能重新生成替换
 * github：https://github.com/feiniaojin/naaf-generator
 */
@Generated("generator")
public interface CmsArticleMapper {
    int insert(CmsArticle record);
    CmsArticle findOneByBizId(@Param("bizId")String bizId);
}