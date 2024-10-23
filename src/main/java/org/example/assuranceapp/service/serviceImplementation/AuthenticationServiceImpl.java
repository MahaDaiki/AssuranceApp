package org.example.assuranceapp.service.serviceImplementation;

import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
import org.example.assuranceapp.models.Utilisateur;
import org.example.assuranceapp.service.serviceInterface.AuthenticationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthenticationServiceImpl implements AuthenticationServiceInt {

    @Autowired
    private AuthenticationDaoInt authenticationDao;

    @Override
    public boolean Register(Utilisateur utilisateur) {
        return authenticationDao.Register(utilisateur);
    }

    @Override
    public Utilisateur Login(String email, String password) {
        return authenticationDao.Login(email, password);
    }

    @Override
    public void logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }
}
