package com.gg.example.springExample.tests;

import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.service.PetClinicService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/9/13
 * Time: 11:46 AM
 */
public class SpringTests {

    private ClassPathXmlApplicationContext applicationContext;
    private PetClinicService petClinicService;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath*:/appcontext/beans-*.xml");
        petClinicService = applicationContext.getBean("petClinicService",PetClinicService.class);
    }

    @After
    public void destroy(){

    }

    @Test
    public void testGetVets(){
        System.out.println("Context Created");

        Collection<Vet> vets = petClinicService.getVets();

        for (Vet vet : vets) {
            System.out.println(vet);
        }

        //Standalone ortam için geçerli. Web containerlar bunu bir şekilde kendileri yapıyor.
        applicationContext.registerShutdownHook();
    }

    @Test
    public void testSaveVet(){

        Vet vet = new Vet();
        vet.setFirstName("Aziz");
        vet.setLastName("Durmaz");
        petClinicService.saveVet(vet);
    }

}
