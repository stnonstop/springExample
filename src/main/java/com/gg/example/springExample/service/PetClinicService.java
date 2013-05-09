package com.gg.example.springExample.service;

import java.util.Collection;

import com.gg.example.springExample.model.Owner;
import com.gg.example.springExample.model.Person;
import com.gg.example.springExample.model.Pet;
import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.model.Visit;


public interface PetClinicService {

	Collection<Vet> getVets();

	Collection<Owner> findOwners(String lastName);
	
	Collection<Visit> findVisits(long petId);
	
	Collection<Person> findAllPersons();

	Owner loadOwner(long id);

	Pet loadPet(long id);
	
	Vet loadVet(long id);

	long saveOwner(Owner owner);

	void saveVet(Vet vet);

	void deleteOwner(long ownerId);
}
