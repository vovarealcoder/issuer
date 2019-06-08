package ru.issuer.dao.repository.hibernate;

import ru.issuer.dao.model.Roles;
import ru.issuer.dao.repository.RoleRepository;


public class RoleRepositoryImpl extends BaseRepositoryImpl<Roles> implements RoleRepository {
    @Override
    public Roles getRoleBydId(int id) {
        return querySingle("from Roles where idRole=?1", Roles.class, id);
    }

    @Override
    public Roles getRoleByName(String name) {
        return querySingle("from Roles where name=?1", Roles.class, name);
    }
}
