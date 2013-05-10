package com.gg.example.springExample.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * User: adurmaz
 * Date: 5/10/13
 * Time: 10:04 AM
 */
@Component
public class PetClinicSaveEventHandler implements ApplicationListener<EntitySaveEvent>{
    @Override
    public void onApplicationEvent(EntitySaveEvent entitySaveEvent) {
        System.out.println("EntitySaveEvent : " + entitySaveEvent);
    }
}
