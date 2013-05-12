package com.gg.example.springExample.tests;

import com.gg.example.springExample.service.PetClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.SocketTimeoutException;

/**
 * User: adurmaz
 * Date: 5/12/13
 * Time: 10:21 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/client.xml")
public class HttpInvokerTest {

    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testHttpInvoker(){
        System.out.println("Vet returned :" + petClinicService.loadVet(1L));
    }

}
