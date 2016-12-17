package ru.itis.inform.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.inform.controllers.CustomerController;
import ru.itis.inform.controllers.GoodsController;
import ru.itis.inform.controllers.OperationController;
import ru.itis.inform.controllers.ThePropertyController;
import ru.itis.inform.exceptions.IncorrectDataException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamil Karimov on 18.11.2016.
 */
@ControllerAdvice(assignableTypes = {
        CustomerController.class,
        GoodsController.class,
        OperationController.class,
        ThePropertyController.class
})
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectDataException.class)
    public ModelAndView incorrectData(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, String> params = new HashMap<>();
        params.put("message", e.getMessage());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }
}
