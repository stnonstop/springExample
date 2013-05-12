package com.gg.example.springExample.model;

import com.gg.example.springExample.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="vets")
@PrimaryKeyJoinColumn
@Configurable
/*@XmlRootElement*/
public class Vet extends Person {
	
	private static final long serialVersionUID = 1L;

    @Autowired
    /*Hibernate veri tabanına eklenmesini istemediğimiz için serialize edilmesini engellememiz gerekiyordu o sebeple transient olarak işaretledik.*/
    private transient PetClinicService petClinicService;

	public Vet() {
	}

    public Vet(Long id, String firstName, String lastName){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

	@ManyToMany
	@JoinTable(name="vet_specialties",joinColumns={@JoinColumn(name="vets_id")},inverseJoinColumns={@JoinColumn(name="specialties_id")})
	private Set<Specialty> specialties = new HashSet<Specialty>();

	public Set<Specialty> getSpecialties() {
		return Collections.unmodifiableSet(specialties);
	}
	
	public void addSpecialty(Specialty specialty) {
		specialties.add(specialty);
	}

    public void save(){
        petClinicService.saveVet(this);
    }
}
