package com.gg.example.springExample.service;

import java.util.Collection;

import com.gg.example.springExample.dao.PetClinicDao;
import com.gg.example.springExample.model.Owner;
import com.gg.example.springExample.model.Person;
import com.gg.example.springExample.model.Pet;
import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.model.Visit;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("petClinicService")
public class PetClinicServiceImpl implements PetClinicService, InitializingBean, DisposableBean {
	
	private PetClinicDao petClinicDao;

    @Autowired
	public PetClinicServiceImpl(PetClinicDao petClinicDao) {
        System.out.println("PetClinicService created");
        this.petClinicDao = petClinicDao;
	}

	public Collection<Vet> getVets() {
		return petClinicDao.getVets();
	}

	public Collection<Owner> findOwners(String lastName) {
		return petClinicDao.findOwners(lastName);
	}

	public Collection<Visit> findVisits(long petId) {
		return petClinicDao.findVisits(petId);
	}

	public Collection<Person> findAllPersons() {
		return petClinicDao.findAllPersons();
	}

	public Owner loadOwner(long id) {
		return petClinicDao.loadOwner(id);
	}

	public Pet loadPet(long id) {
		return petClinicDao.loadPet(id);
	}

	public Vet loadVet(long id) {
		return petClinicDao.loadVet(id);
	}

	public long saveOwner(Owner owner) {
		petClinicDao.saveOwner(owner);
		return owner.getId();
	}

	public void saveVet(Vet vet) {
		petClinicDao.saveVet(vet);
	}

	public void deleteOwner(long ownerId) {
		petClinicDao.deleteOwner(ownerId);
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PetClinicService init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PetClinicService destroyed");
    }
}
