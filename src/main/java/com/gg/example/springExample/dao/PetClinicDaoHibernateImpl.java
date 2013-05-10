package com.gg.example.springExample.dao;

import com.gg.example.springExample.model.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/10/13
 * Time: 3:27 PM
 */
@Repository("petClinicDao")
public class PetClinicDaoHibernateImpl implements PetClinicDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Collection<Vet> getVets() {

        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select distinct v from Vet v left join fetch  v.specialties ");
            return query.list();
        } finally {
            session.close();
        }

    }

    @Override
    public Collection<Owner> findOwners(String lastName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Person> findAllPersons() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Owner loadOwner(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pet loadPet(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vet loadVet(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOwner(Owner owner) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveVet(Vet vet) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteOwner(long ownerId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
