package com.feiniaojin.ddd.cms.domain;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractDomainMask {

    /**
     * 自增主键
     */
    private Long id;
    /**
     * 逻辑删除标记[0-正常；1-已删除]
     */
    private Integer deleted;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String modifiedBy;
    /**
     * 更新时间
     */
    private Date modifiedTime;
    /**
     * 乐观锁
     */
    private Long version;
}
