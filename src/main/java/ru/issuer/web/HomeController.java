package ru.issuer.web;


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
import org.springframework.web.servlet.ModelAndView;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;

import javax.validation.Valid;
import java.net.BindException;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    private UserManager manager;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView home(Locale locale) {
        logger.info("Welcome home! The client locale is {}.", locale);
//
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//        String formattedDate = dateFormat.format(date);
//
//        Users users = Users
//                .builder()
//                .role(Roles.builder().idRole(1).build())
//                .name("vvovan")
//                .login("testuser")
//                .password("1234567")
//                .build();
//      //  try {
//     //       int insertUser = manager.insertUser(users);
//            model.addAttribute("user", manager.getUser("testuser").toString());
//      //  } catch (DaoException e) {
//     //       logger.error(e.toString(), e);
//      //  }
//        //  ;
//        model.addAttribute("serverTime", formattedDate);

        return new ModelAndView("login", "user", new Users());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute(name = "user") Users users, BindingResult bindingResult, Model modelAndView) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Users user = manager.getUser(users.getLogin(), users.getPassword());
        logger.info("user is {}", user);
        modelAndView.addAttribute("currentUser", user);
        return "index";
    }

    @Qualifier("defUserManager")
    @Autowired
    public void setManager(UserManager manager) {
        this.manager = manager;
    }
}