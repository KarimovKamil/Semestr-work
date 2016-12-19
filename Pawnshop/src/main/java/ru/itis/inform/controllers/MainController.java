package ru.itis.inform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kamil Karimov on 19.12.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public ModelAndView pageNotFound() {
        return new ModelAndView("notFound");
    }
}
