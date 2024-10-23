package org.example.assuranceapp.dao.daoImplementation;

import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
import org.example.assuranceapp.models.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository

public class AuthenticationDaoImpl implements AuthenticationDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean Register(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
        return true;
    }

    @Override
    @Transactional
    public boolean Login(String email, String password) {
        try {
            Utilisateur utilisateur = entityManager.createQuery(
                            "SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motdepasse = :password", Utilisateur.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
                 return utilisateur != null;
            } catch (NoResultException e) {
            return false;
             }
    }
}
