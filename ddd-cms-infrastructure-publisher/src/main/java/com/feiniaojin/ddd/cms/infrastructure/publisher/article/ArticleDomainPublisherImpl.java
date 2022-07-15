package com.feiniaojin.ddd.cms.infrastructure.publisher.article;

import com.feiniaojin.ddd.DomainEvent;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDomainPublisherImpl implements ArticleDomainEventPublisher {

    @Override
    public void publish(List<DomainEvent> list) {

    }
}
