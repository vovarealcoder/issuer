package ru.issuer.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.DaoException;
import ru.issuer.dao.repository.UserRepository;

@Component
public class UserManager {

    private UserRepository repository;

    public Users getUser(String login) {
        return repository.getUserByLogin(login);
    }


    public Users getUser(String login, String password) {
        return repository.getUserByLoginPassword(login, password);
    }

    public Users getUser(int id) {
        return repository.getUserById(id);
    }

    @Transactional
    public int createUser(Users user) throws DaoException {
        return repository.create(user);
    }

    @Autowired
    @Required
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("@securityService.hasAccessRand()")
    public void fakeMethod() {
        System.out.println("fake method");
    }
}
