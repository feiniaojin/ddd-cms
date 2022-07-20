package com.feiniaojin.ddd.cms.infrastructure.publisher.article;

import com.feiniaojin.ddd.DomainEvent;
import com.feiniaojin.ddd.cms.domain.article.ArticleDomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@Slf4j
public class ArticleDomainPublisherImpl implements ArticleDomainEventPublisher {

    @Override
    public void publish(List<DomainEvent> list) {
        if (CollectionUtils.isEmpty(list)) {
            log.info("article消息发送:list为空,无需发送");
            return;
        }
        //TODO 消息发送逻辑
        log.info("article消息发送:list={}", list);
    }
}
