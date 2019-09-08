package ru.issuer.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.issuer.dao.model.Projects;
import ru.issuer.dao.model.ProjectsParticipants;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.ParticipantRepository;
import ru.issuer.dao.repository.ProjectsRepository;
import ru.issuer.dao.repository.UserRepository;
import ru.issuer.security.SecurityService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectManager {

    private final ProjectsRepository projectsRepository;
    private final ParticipantRepository participantRepository;
    private final SecurityService securityService;
    private final UserRepository userRepository;


    @Autowired
    public ProjectManager(@Qualifier("projectsRepository") ProjectsRepository projectsRepository,
                          @Qualifier("participantRepository") ParticipantRepository participantRepository,
                          @Qualifier("securityService") SecurityService securityService,
                          @Qualifier("userRepository") UserRepository userRepository) {
        this.projectsRepository = projectsRepository;
        this.participantRepository = participantRepository;
        this.securityService = securityService;
        this.userRepository = userRepository;
    }

    public List<Projects> getUserProject() {
        Users currentUser = securityService.getCurrentUser();
        List<ProjectsParticipants> participants = participantRepository.findProjectsParticipantsByUser(currentUser);
        return participants.stream()
                .map(ProjectsParticipants::getProject)
                .collect(Collectors.toList());
    }

    @Transactional
    @PreAuthorize("@securityService.userIsAdmin()")
    public Projects createProject(Projects pr) {
        return projectsRepository.save(pr);
        //todo версии и пр.
    }


}
