package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Customer;
import ru.itis.inform.services.interfaces.CustomerService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customer/customers");
        Map<String, List<Customer>> params = new HashMap<>();
        params.put("customers", customerService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("customer/customer");
        Map<String, Customer> params = new HashMap<>();
        params.put("customer", customerService.getCustomer(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/all");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCustomer() {
        return new ModelAndView("customer/addCustomer");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCustomer(@RequestParam("lastName") String lastName,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("middleName") String middleName,
                                    @RequestParam("passport") String passport,
                                    @RequestParam("phoneNumber") String phone,
                                    @RequestParam("dateOfBirth") Date dateOfBirth) {
        customerService.saveCustomer(new Customer.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .phoneNumber(phone)
                .passport(passport)
                .dateOfBirth(dateOfBirth)
                .build());
        return new ModelAndView("redirect:/customer/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("customer/updateCustomer");
        Map<String, Customer> params = new HashMap<>();
        params.put("customer", customerService.getCustomer(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@PathVariable("id") int id,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("middleName") String middleName,
                                       @RequestParam("passport") String passport,
                                       @RequestParam("phoneNumber") String phone,
                                       @RequestParam("dateOfBirth") Date dateOfBirth) {
        customerService.updateCustomer(id, new Customer.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .phoneNumber(phone)
                .passport(passport)
                .dateOfBirth(dateOfBirth)
                .build());
        return new ModelAndView("redirect:/customer/all");
    }
}
