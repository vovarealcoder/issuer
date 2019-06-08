package ru.issuer.dao.repository;

import ru.issuer.dao.model.Roles;

public interface RoleRepository {
    Roles getRoleBydId(int id);

    Roles getRoleByName(String name);
}
