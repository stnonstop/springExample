package com.gg.example.springExample.dao;

import com.gg.example.springExample.model.*;
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
        return sessionFactory.getCurrentSession().createQuery("from Owner o where o.lastName = :lastName").setParameter("lastName", lastName).list();
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        return sessionFactory.getCurrentSession().createQuery("from Visit v where v.pet_id = ?").setParameter(0,petId).list();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Person> findAllPersons() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Owner loadOwner(long id) {

        return (Owner) sessionFactory.getCurrentSession().get(Owner.class,id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pet loadPet(long id) {
        return (Pet) sessionFactory.getCurrentSession().createQuery("from Pet p where p.id = ?").setParameter(0,id).uniqueResult();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vet loadVet(long id) {
        return (Vet) sessionFactory.getCurrentSession().get(Vet.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOwner(Owner owner) {
        sessionFactory.getCurrentSession().saveOrUpdate(owner);
    }

    @Override
    public void saveVet(Vet vet) {
        sessionFactory.getCurrentSession().save(vet);
    }

    @Override
    public void deleteOwner(long ownerId) {
        Owner owner= new Owner();
        owner.setId(ownerId);
        sessionFactory.getCurrentSession().delete(owner);
    }
}
