package com.gg.example.springExample.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * User: adurmaz
 * Date: 5/10/13
 * Time: 9:51 AM
 */
@Component
public class PetClinicEventHandler implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        if(applicationEvent instanceof ContextRefreshedEvent){
            System.out.println("applicationEvent : ContextRefreshedEvent");
        }else if(applicationEvent instanceof ContextClosedEvent){
            System.out.println("applicationEvent : ContextClosedEvent");
        }
    }
}
