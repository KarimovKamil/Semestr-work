package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.TheProperty;
import ru.itis.inform.services.interfaces.ThePropertyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 17.12.2016.
 */

/**
 * Принимаются запросы связанные с property и вызываются соответствующие методы в сервисе
 */
@Controller
@RequestMapping("/property")
public class ThePropertyController {

    @Autowired
    ThePropertyService thePropertyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllProperties() {
        ModelAndView modelAndView = new ModelAndView("property/properties");
        Map<String, List<TheProperty>> params = new HashMap<>();
        params.put("properties", thePropertyService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getGood(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("property/property");
        Map<String, TheProperty> params = new HashMap<>();
        params.put("property", thePropertyService.getProperty(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteGoods(@PathVariable("id") int id) {
        thePropertyService.deleteProperty(id);
        return new ModelAndView("redirect:/property/all");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addProperty() {
        return new ModelAndView("property/addProperty");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProperty(@RequestParam ("goodsId") int goodsId,
                                    @RequestParam("address") String address,
                                    @RequestParam("dwellingSpace") int dwellingSpace) {
        thePropertyService.saveProperty(goodsId, new TheProperty.Builder()
                .address(address)
                .dwellingSpace(dwellingSpace)
                .build());
        return new ModelAndView("redirect:/property/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateProperty(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("property/updateProperty");
        Map<String, TheProperty> params = new HashMap<>();
        params.put("property", thePropertyService.getProperty(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateProperty(@PathVariable("id") int id,
                                       @RequestParam("address") String address,
                                       @RequestParam("dwellingSpace") int dwellingSpace) {
        thePropertyService.updateProperty(id, new TheProperty.Builder()
                .address(address)
                .dwellingSpace(dwellingSpace)
                .build());
        return new ModelAndView("redirect:/property/all");
    }
}
