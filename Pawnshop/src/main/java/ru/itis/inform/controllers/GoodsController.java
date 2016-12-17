package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        ModelAndView modelAndView = new ModelAndView("goods/goods");
        Map<String, List<Goods>> params = new HashMap<>();
        params.put("goods", goodsService.getAll());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getGood(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("goods/good");
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
        return new ModelAndView("goods/addGoods");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addGoods(@RequestParam("goodsType") String goodsType,
                                 @RequestParam("price") int price,
                                 @RequestParam("description") String description) {
        goodsService.saveGoods(new Goods.Builder()
                .goodsType(goodsType)
                .goodsPrice(price)
                .description(description)
                .build());
        return new ModelAndView("redirect:/goods/all");
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateGoods(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("goods/updateGoods");
        Map<String, Goods> params = new HashMap<>();
        params.put("goods", goodsService.getGoods(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateGoods(@PathVariable("id") int id,
                                    @RequestParam("goodsType") String goodsType,
                                    @RequestParam("description") String description,
                                    @RequestParam("price") int price) {
        goodsService.updateGoods(id, new Goods.Builder()
                .goodsType(goodsType)
                .description(description)
                .goodsPrice(price)
                .build());
        return new ModelAndView("redirect:/goods/all");
    }
}
