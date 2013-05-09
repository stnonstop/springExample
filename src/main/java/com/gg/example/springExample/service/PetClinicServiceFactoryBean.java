package com.gg.example.springExample.service;

import com.gg.example.springExample.dao.PetClinicDao;
import org.springframework.beans.factory.FactoryBean;

/**
 * User: adurmaz
 * Date: 5/9/13
 * Time: 2:26 PM
 */
public class PetClinicServiceFactoryBean implements FactoryBean<PetClinicService> {

    private PetClinicDao petClinicDao;

    public void setPetClinicDao(PetClinicDao petClinicDao) {
        this.petClinicDao = petClinicDao;
    }

    @Override
    public PetClinicService getObject() throws Exception {
        return new PetClinicServiceImpl(petClinicDao);
    }

    @Override
    public Class<?> getObjectType() {
        return PetClinicService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
