package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Goods;

import java.util.List;

public interface GoodsDao {

    int saveGoods(Goods goods);

    void deleteGoods(int goodsId);

    Goods getGoods(int goodsId);

    List<Goods> getAll();

    void updateGoods(int goodsId, Goods goods);

}
