package ru.issuer.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.issuer.dao.model.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer> {
    Roles getRoleByIdRole(int id);

    Roles getRoleByName(String name);
}
