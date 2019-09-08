package ru.issuer.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.UserRepository;

@Service
public class UserManager {

    private UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Users getUser(String login) {
        return repository.getUserByLogin(login);
    }


    public Users getUser(String login, String password) {
        return repository.getUserByLoginAndPassword(login, password);
    }

    public Users getUser(int id) {
        return repository.getUserByIdUser(id);
    }

    @Transactional
    public Integer createUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user).getIdUser();
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("@securityService.hasAccessRand()")
    public void fakeMethod() {
        System.out.println("fake method");
    }
}
