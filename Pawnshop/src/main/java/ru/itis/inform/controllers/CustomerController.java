package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Customer;
import ru.itis.inform.services.interfaces.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customers");
        Map<String, List<Customer>> params = new HashMap<>();
        params.put("customers", customerService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addCustomerGet() {
        ModelAndView modelAndView = new ModelAndView("addCustomer");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addCustomerPost() {
        ModelAndView modelAndView = new ModelAndView("addCustomer");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("customer");
        Map<String, Customer> params = new HashMap<>();
        params.put("customer", customerService.getCustomer(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/all");
    }

//    @RequestMapping(value = "/*/delete", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView deleteCustomerGet() {
//    }
}
