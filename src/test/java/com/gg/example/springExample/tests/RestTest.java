package com.gg.example.springExample.tests;

import com.gg.example.springExample.model.Vet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * User: adurmaz
 * Date: 5/11/13
 * Time: 5:15 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appcontext/beans-*.xml")
@DirtiesContext /* Tekrar tekrar yarat demek*/
public class RestTest {

    @Test
    public void testLoadVet(){
        RestTemplate restTemplate = new RestTemplate();
        Vet vet = restTemplate.getForObject("http://localhost:8080/mvc/vet/{vetId}", Vet.class, 1L);
        System.out.println(vet);
    }

}
