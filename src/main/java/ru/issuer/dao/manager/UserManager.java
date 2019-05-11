package ru.issuer.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.issuer.dao.model.Roles;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.DaoException;
import ru.issuer.dao.repository.UserRepository;

import java.util.Date;
import java.sql.Timestamp;

@Component
public class UserManager {

    @Bean("defUserManager")
    UserManager getMgr() {
        return new UserManager();
    }

    private UserRepository repository;

    public Users getUser(String login){
        return repository.getUserByLogin(login);
    }


    public Users getUser(String login,String password){
        return repository.getUserByLoginPassword(login,password);
    }

    public Users getUser(int id) {
        return repository.getUserById(id);
    }

    @Transactional
    public int insertUser(Users user) throws DaoException {
        return repository.create(user);
//        build = Users.builder().login("test22").email("aaa@ff.ru").password("aassdd").build();
//        try {
//            int user = repository.create(build);
//        } catch (DaoException e) {
//        }
//        build = Users.builder().login("test234").email("aaa@ff.ru").password("aassdd").build();
//        try {
//            int user = repository.create(build);
//        } catch (DaoException e) {
//        }
       // throw new IllegalArgumentException();
    }

    @Autowired
    @Required
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
