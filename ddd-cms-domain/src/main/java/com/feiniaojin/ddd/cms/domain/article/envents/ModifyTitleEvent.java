package com.feiniaojin.ddd.cms.domain.article.envents;

import com.feiniaojin.ddd.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyTitleEvent implements DomainEvent {
    private String articleId;
    private String title;
}
