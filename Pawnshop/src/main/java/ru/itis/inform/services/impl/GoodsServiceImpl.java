package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.GoodsDao;
import ru.itis.inform.models.Goods;
import ru.itis.inform.services.interfaces.GoodsService;
import ru.itis.inform.validation.VerificationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    VerificationFactory verificationFactory;

    @Override
    public void saveGoods(Goods goods) {
        verificationFactory.verifyGoods(goods);
        goods.setGoodsType(goods.getGoodsType().toUpperCase());
        goodsDao.saveGoods(goods);
    }

    @Override
    public void deleteGoods(int goodsId) {
        verificationFactory.verifyGoodsExistence(goodsId);
        goodsDao.deleteGoods(goodsId);
    }

    @Override
    public Goods getGoods(int goodsId) {
        verificationFactory.verifyGoodsExistence(goodsId);
        Goods goods = goodsDao.getGoods(goodsId);
        return goods;
    }

    @Override
    public List<Goods> getAll() {
        return goodsDao.getAll();
    }

    @Override
    public void updateGoods(int goodsId, Goods goods) {
        verificationFactory.verifyGoodsExistence(goodsId);
        verificationFactory.verifyGoods(goods);
        goodsDao.updateGoods(goodsId, goods);
    }
}
