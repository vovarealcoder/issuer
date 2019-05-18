package ru.issuer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.issuer.web.model.SessionModel;

@Controller("/")
@SessionAttributes("sessionModel")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute("sessionModel") SessionModel sessionModel) {
        return new ModelAndView("index", "currentUser", sessionModel.getUser());
    }

    @ModelAttribute("sessionModel")
    public SessionModel defSessionModel() {
        return new SessionModel();
    }
}
