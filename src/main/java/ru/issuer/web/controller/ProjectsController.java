package ru.issuer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.issuer.dao.manager.ProjectManager;
import ru.issuer.dao.model.Projects;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/issuer")
public class ProjectsController {

    private final ProjectManager projectManager;

    @Autowired
    public ProjectsController(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ModelAndView getAllUserProjects() {
        Map<String, List<Projects>> projects = Collections.singletonMap("projects", projectManager.getUserProject());
        return new ModelAndView("projects", projects);
    }

}
