package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.AssuranceAutoDaoInt;
import org.example.assuranceapp.models.AssuranceAuto;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AssuranceAutoDaoImpl  implements AssuranceAutoDaoInt {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void insertAssuranceAuto(AssuranceAuto assuranceAuto) {
        entityManager.persist(assuranceAuto);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<AssuranceAuto> getAssurancesByUserId(Long userId){
        return entityManager.createQuery("SELECT a FROM AssuranceAuto a WHERE a.utilisateur.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }
}
