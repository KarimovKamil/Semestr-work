package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.NewOperation;
import ru.itis.inform.models.Operation;
import ru.itis.inform.services.interfaces.OperationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 17.12.2016.
 */
@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllOperations() {
        ModelAndView modelAndView = new ModelAndView("operation/operations");
        Map<String, List<Operation>> params = new HashMap<>();
        params.put("operations", operationService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("operation/operation");
        Map<String, Operation> params = new HashMap<>();
        params.put("operation", operationService.getOperation(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteOperation(@PathVariable("id") int id) {
        operationService.deleteOperation(id);
        return new ModelAndView("redirect:/operation/all");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addOperation() {
        return new ModelAndView("operation/addOperation");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOperation(@RequestParam("customerId") int customerId,
                                     @RequestParam("goodsType") String goodsType,
                                     @RequestParam("goodsDescription") String goodsDescription,
                                     @RequestParam("price") int price,
                                     @RequestParam("timeOfReturn") int timeOfReturn) {
        operationService.saveOperation(new NewOperation.Builder()
                .customerId(customerId)
                .goodsType(goodsType)
                .goodsDescription(goodsDescription)
                .price(price)
                .timeOfReturn(timeOfReturn)
                .build());
        return new ModelAndView("redirect:/operation/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateOperation(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("operation/updateOperation");
        Map<String, Operation> params = new HashMap<>();
        params.put("operation", operationService.getOperation(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateOperation(@PathVariable("id") int id,
                                        @RequestParam("customerId") int customerId,
                                        @RequestParam("timeOfReturn") int timeOfReturn,
                                        @RequestParam("status") String status,
                                        @RequestParam("returnAmount") int returnAmount) {
        operationService.updateOperation(id, new Operation.Builder()
                .customerId(customerId)
                .timeOfReturn(timeOfReturn)
                .status(status)
                .returnAmount(returnAmount)
                .build());
        return new ModelAndView("redirect:/operation/all");
    }
}
