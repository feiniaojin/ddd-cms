package com.feiniaojin.ddd.cms.domain.article.envents;

import com.feiniaojin.ddd.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedEvent implements DomainEvent {
    private String campusJobId;
}
