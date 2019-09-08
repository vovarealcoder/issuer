package ru.issuer.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.issuer.dao.model.ProjectsParticipants;
import ru.issuer.dao.model.Users;

import java.util.List;

@Repository
public interface ParticipantRepository extends CrudRepository<ProjectsParticipants, Integer> {
    List<ProjectsParticipants> findProjectsParticipantsByUser(Users user);
}
