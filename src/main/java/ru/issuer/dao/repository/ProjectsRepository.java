package ru.issuer.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.issuer.dao.model.Projects;

@Repository
public interface ProjectsRepository extends CrudRepository<Projects, Integer> {
    Projects getProjectByIdProject(int id);
}
