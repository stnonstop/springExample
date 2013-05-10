package com.gg.example.springExample.event;

import com.gg.example.springExample.model.BaseEntity;
import org.springframework.context.ApplicationEvent;

/**
 * User: adurmaz
 * Date: 5/10/13
 * Time: 9:57 AM
 */
public class EntitySaveEvent extends ApplicationEvent{

    private BaseEntity entity;

    public EntitySaveEvent(Object source) {
        super(source);
    }

    public BaseEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }
}
