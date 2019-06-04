package ru.issuer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringSecurityAuthController {

    @RequestMapping(value = "/loginspring", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Invalid login pass");
        }
        modelAndView.setViewName("loginspring");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }


}
