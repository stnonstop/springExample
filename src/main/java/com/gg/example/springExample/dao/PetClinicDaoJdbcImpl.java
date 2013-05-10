package com.gg.example.springExample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.gg.example.springExample.model.Owner;
import com.gg.example.springExample.model.Person;
import com.gg.example.springExample.model.Pet;
import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PetClinicDaoJdbcImpl implements PetClinicDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PetClinicDaoJdbcImpl(){
        System.out.println("PetClinicDaoJdbcImpl created");
    }

	@Override
	public Collection<Vet> getVets() {

		return jdbcTemplate.query("SELECT p.FIRST_NAME, p.LAST_NAME, p.ID FROM PERSONS AS p JOIN VETS ON VETS.ID = p.ID",
                new RowMapper<Vet>() {
                    @Override
                    public Vet mapRow(ResultSet resultSet, int i) throws SQLException {
                        Vet vet = new Vet();
                        vet.setId(resultSet.getLong("id"));
                        vet.setFirstName(resultSet.getString("FIRST_NAME"));
                        vet.setLastName(resultSet.getString("LAST_NAME"));
                        return vet;
                    }
                });
	}

	@Override
	public Collection<Owner> findOwners(String lastName) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Collection<Visit> findVisits(long petId) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Collection<Person> findAllPersons() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Owner loadOwner(long id) {
		return null;
	}

	@Override
	public Pet loadPet(long id) {
		return null;
	}

	@Override
	public Vet loadVet(long id) {
		return null;
	}

	@Override
	public void saveOwner(Owner owner) {
	}

	@Override
	public void saveVet(Vet vet) {
	}

	@Override
	public void deleteOwner(long ownerId) {
	}
}
