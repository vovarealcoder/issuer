package ru.issuer.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;
import ru.issuer.dao.repository.DaoException;
import ru.issuer.web.model.RegisterModel;
import ru.issuer.web.model.SessionModel;

import javax.validation.Valid;
import java.util.Base64;

@Controller
@SessionAttributes("sessionModel")
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private UserManager manager;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute("sessionModel") SessionModel sessionModel) {
        if (sessionModel.isAutorized()) {
            return new ModelAndView("redirect:/", null);
        }
        return new ModelAndView("register", "regUser", new RegisterModel());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("sessionModel") SessionModel sessionModel, @Valid @ModelAttribute("regUser") RegisterModel registerModel, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes attributes) {
        if (!bindingResult.hasErrors()) {
            try {
                int insertUser = manager.createUser(registerModel.toORMModel());
                Users user = manager.getUser(insertUser);
                modelAndView.addObject("currentUser", user);
                sessionModel.setAutorized(true);
                sessionModel.setUser(user);
                String sessionId = Base64.getEncoder().encodeToString((System.currentTimeMillis() + user.getLogin()).getBytes());
                sessionModel.setSessionId(sessionId);
                attributes.addFlashAttribute("message", "success register");
                return "redirect:/";
            } catch (DaoException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return "register";
    }

    @ModelAttribute("sessionModel")
    public SessionModel sessionModel() {
        return new SessionModel();
    }


    @Autowired
    public void setManager(UserManager manager) {
        this.manager = manager;
    }
}
