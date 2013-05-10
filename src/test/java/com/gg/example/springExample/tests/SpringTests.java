package com.gg.example.springExample.tests;

import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.service.PetClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/9/13
 * Time: 11:46 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appcontext/beans-*.xml")
@DirtiesContext /* Tekrar tekrar yarat demek*/
public class SpringTests {

    @Autowired
    private PetClinicService petClinicService;


    @Test
    public void testGetVets(){
        System.out.println("Context Created");

        Collection<Vet> vets = petClinicService.getVets();

        for (Vet vet : vets) {
            System.out.println(vet);
        }
    }

    @Test
    public void testSaveVet(){

        Vet vet = new Vet();
        vet.setFirstName("Aziz");
        vet.setLastName("Durmaz");
        petClinicService.saveVet(vet);
    }



}
