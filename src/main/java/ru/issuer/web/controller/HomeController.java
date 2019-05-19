package ru.issuer.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import ru.issuer.web.model.SessionModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller("/")
@SessionAttributes("sessionModel")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute("sessionModel") SessionModel sessionModel, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            for (Map.Entry<String, ?> value : inputFlashMap.entrySet()) {
                logger.info("key={}, value={}", value.getKey(), value.getValue());
            }
        }
        return new ModelAndView("index", "currentUser", sessionModel.getUser());
    }

    @ModelAttribute("sessionModel")
    public SessionModel defSessionModel() {
        return new SessionModel();
    }
}
