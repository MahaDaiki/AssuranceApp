package org.example.assuranceapp.dao.daoImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DevisDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

}
