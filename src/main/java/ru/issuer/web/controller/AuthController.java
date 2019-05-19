package ru.issuer.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;
import ru.issuer.web.model.AuthModel;
import ru.issuer.web.model.SessionModel;

import javax.validation.Valid;
import java.util.Base64;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller("auth")
@SessionAttributes("sessionModel")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private UserManager manager;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute("sessionModel") SessionModel sessionModel, Locale locale) {
        logger.info("Welcome home! The client locale is {}.", locale);
        if (sessionModel.isAutorized()) {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("currentUser", sessionModel.getUser());
            return modelAndView;
        }

        return new ModelAndView("login", "user", new AuthModel());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("sessionModel") SessionModel sessionModel, @Valid @ModelAttribute(name = "user") AuthModel authModel, BindingResult bindingResult, Model modelAndView) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Users user = manager.getUser(authModel.getLogin(), authModel.getPassword());
        logger.info("user is {}", user);
        if (user != null) {
            modelAndView.addAttribute("currentUser", user);
            sessionModel.setAutorized(true);
            String sessionId = Base64.getEncoder().encodeToString((System.currentTimeMillis() + user.getLogin()).getBytes());
            sessionModel.setSessionId(sessionId);
            sessionModel.setUser(user);
        }
        return "redirect:/";
    }

    @Qualifier("defUserManager")
    @Autowired
    public void setManager(UserManager manager) {
        this.manager = manager;
    }

    @ModelAttribute("sessionModel")
    public SessionModel defSessionModel() {
        return new SessionModel();
    }

}