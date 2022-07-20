package com.feiniaojin.ddd.cms.domain.article.envents;

import com.feiniaojin.ddd.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyContentEvent implements DomainEvent {
    private String articleId;
    private String content;
}
