package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.DomainEvent;
import com.feiniaojin.ddd.Entity;
import com.feiniaojin.ddd.cms.domain.AbstractDomainMask;
import com.feiniaojin.ddd.cms.domain.article.envents.CreatedEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.ModifyContentEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.ModifyTitleEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.PublishedEvent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleContent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleTitle;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ArticleEntity extends AbstractDomainMask implements Entity {

    private List<DomainEvent> events = new ArrayList<>();

    private ArticleId articleId;

    private Integer publishState;

    private ArticleTitle articleTitle;

    private ArticleContent content;

    public void createDraft() {
        this.setPublishState(PublishState.TO_PUBLISH.getCode());
        events.add(new CreatedEvent(this.articleId.getValue()));
    }

    @Override
    public List<DomainEvent> domainEvents() {
        if (events.size() == 0) {
            return Collections.emptyList();
        }
        List<DomainEvent> tempList = new ArrayList<>(events);
        events.clear();
        return tempList;
    }

    public void publishArticle() {
        this.setPublishState(PublishState.TO_PUBLISH.getCode());
        events.add(new PublishedEvent(this.articleId.getValue()));
    }

    public void modifyTitle(ArticleTitle articleTitle) {
        this.setArticleTitle(articleTitle);
        events.add(new ModifyTitleEvent(this.articleId.getValue(), articleTitle.getValue()));
    }

    public void modifyContent(ArticleContent articleContent) {
        this.setContent(articleContent);
        events.add(new ModifyContentEvent(this.getArticleId().getValue(),
                articleContent.getValue()));
    }
}
