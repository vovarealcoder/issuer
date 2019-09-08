package ru.issuer.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.issuer.dao.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users getUserByIdUser(int id);

    Users getUserByLogin(String login);

    Users getUserByLoginAndPassword(String login, String password);

}
