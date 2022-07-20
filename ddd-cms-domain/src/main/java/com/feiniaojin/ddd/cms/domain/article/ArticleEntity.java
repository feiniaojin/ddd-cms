package com.feiniaojin.ddd.cms.domain.article;

import com.feiniaojin.ddd.DomainEvent;
import com.feiniaojin.ddd.Entity;
import com.feiniaojin.ddd.cms.domain.ModelMask;
import com.feiniaojin.ddd.cms.domain.article.envents.CreatedEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.ModifyContentEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.ModifyTitleEvent;
import com.feiniaojin.ddd.cms.domain.article.envents.PublishedEvent;
import com.feiniaojin.ddd.cms.domain.article.primitive.ArticleId;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ArticleEntity extends ModelMask implements Entity {

    private List<DomainEvent> events = new ArrayList<>();

    private ArticleId articleId;

    private ArticleState articleState;

    private String title;

    private ArticleContent content;

    public void createDraft() {
        this.setArticleState(ArticleState.TO_PUBLISH);
        events.add(new CreatedEvent(this.articleId.getEntityIdValue()));
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

    public void publishOnWebsite() {
        this.setArticleState(ArticleState.TO_PUBLISH);
        events.add(new PublishedEvent(this.articleId.getEntityIdValue()));
    }

    public void modifyTitle(String title) {
        this.setTitle(title);
        events.add(new ModifyTitleEvent(this.articleId.getEntityIdValue(), title));
    }

    public void modifyContent(String content) {
        this.getContent().setContent(content);
        events.add(new ModifyContentEvent(this.getArticleId().getEntityIdValue(), content));
    }
}
