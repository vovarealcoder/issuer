package ru.issuer.dao.repository;


import ru.issuer.dao.model.Users;

import java.util.List;

public interface UserRepository extends BaseRepository<Users>{
    List<Users> getAllUsers();
    Users getUserById(int id);
    Users getUserByLogin(String login);
    Users getUserByLoginPassword(String login,String password);

}
