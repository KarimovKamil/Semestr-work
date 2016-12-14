package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.Goods;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
public interface GoodsService {

    void saveGoods(Goods goods);

    void deleteGoods(int goodsId);

    Goods getGoods(int goodsId);

    List<Goods> getAll();

    void updateGoods(int goodsId, Goods goods);

}
