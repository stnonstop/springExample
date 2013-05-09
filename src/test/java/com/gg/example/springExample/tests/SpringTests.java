package com.gg.example.springExample.tests;

import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.service.PetClinicService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/9/13
 * Time: 11:46 AM
 */
public class SpringTests {

    @Test
    public void testGetVets(){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/appcontext/beans-dao.xml","/appcontext/beans-service.xml", "/appcontext/beans-config.xml");

        System.out.println("Context Created");

        PetClinicService petClinicService = applicationContext.getBean("petClinicService",PetClinicService.class);

        Collection<Vet> vets = petClinicService.getVets();

        for (Vet vet : vets) {
            System.out.println(vet);
        }

        //Standalone ortam için geçerli. Web containerlar bunu bir şekilde kendileri yapıyor.
        applicationContext.registerShutdownHook();
    }

}
