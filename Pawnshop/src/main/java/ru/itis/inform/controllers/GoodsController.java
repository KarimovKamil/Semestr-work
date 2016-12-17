package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Goods;
import ru.itis.inform.services.interfaces.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllGoods() {
        ModelAndView modelAndView = new ModelAndView("goods");
        Map<String, List<Goods>> params = new HashMap<>();
        params.put("goods", goodsService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getGood(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("good");
        Map<String, Goods> params = new HashMap<>();
        params.put("good", goodsService.getGoods(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteGoods(@PathVariable("id") int id) {
        goodsService.deleteGoods(id);
        return new ModelAndView("redirect:/goods/all");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addGoods() {
        return new ModelAndView("addGoods");
    }
}
