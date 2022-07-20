package com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper;

import com.feiniaojin.ddd.cms.infrastructure.persitrence.article.data.CmsArticle;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

/**
 * 表名称：cms_article自动生成的Mapper
 * 表注释：article主表
 * NOTICE:本文件由代码生成器naaf-generator生成
 * github：https://github.com/feiniaojin/naaf-generator
 */
@Generated("generator")
public interface CmsArticleMapperEx {

    /**
     * 分页查询：统计总数
     * @param paramMap
     * @return
     */
    int pageListTotal(Map<String, Object> paramMap);

    /**
     * 分页查询：分页获取数据
     * @param paramMap
     * @return
     */
    List<CmsArticle> pageList(Map<String, Object> paramMap);

    CmsArticle findOneByBizId(@Param("articleId") String articleId);
}