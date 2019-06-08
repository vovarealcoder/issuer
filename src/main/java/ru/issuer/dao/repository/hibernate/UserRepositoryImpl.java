package ru.issuer.dao.repository.hibernate;

import org.springframework.stereotype.Repository;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<Users> implements UserRepository {


    @Override
    public List<Users> getAllUsers() {
        return queryList("from Users", Users.class);
    }

    @Override
    public Users getUserById(int id) {
        return querySingle("from Users where id = ?1", Users.class, id);
    }

    @Override
    public Users getUserByLogin(String login) {
        return querySingle("from Users where login = ?1", Users.class, login);
    }

    @Override
    public Users getUserByLoginPassword(String login, String password) {
        return querySingle("from Users where login = ?1 and password = ?2", Users.class, login, password);
    }
}
