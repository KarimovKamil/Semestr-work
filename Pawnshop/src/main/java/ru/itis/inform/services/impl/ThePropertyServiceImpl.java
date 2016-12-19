package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.ThePropertyDao;
import ru.itis.inform.models.TheProperty;
import ru.itis.inform.services.interfaces.ThePropertyService;
import ru.itis.inform.validation.VerificationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 17.12.2016.
 */

/**
 * Проверка данных на корректность и вызов thePropertyDao
 */
@Service
public class ThePropertyServiceImpl implements ThePropertyService {

    @Autowired
    ThePropertyDao thePropertyDao;
    @Autowired
    VerificationFactory verificationFactory;

    @Override
    public void saveProperty(int goodsId, TheProperty property) {
        verificationFactory.verifyGoodsIsProperty(goodsId);
        verificationFactory.verifyThePropertyWithThisGoods(goodsId);
        verificationFactory.verifyTheProperty(property);
        property.setGoodsId(goodsId);
        thePropertyDao.saveTheProperty(property);
    }

    @Override
    public void deleteProperty(int propertyId) {
        verificationFactory.verifyThePropertyExistence(propertyId);
        thePropertyDao.deleteTheProperty(propertyId);
    }

    @Override
    public TheProperty getProperty(int propertyId) {
        verificationFactory.verifyThePropertyExistence(propertyId);
        return thePropertyDao.getTheProperty(propertyId);
    }

    @Override
    public List<TheProperty> getAll() {
        return thePropertyDao.getAll();
    }

    @Override
    public void updateProperty(int propertyId, TheProperty property) {
        verificationFactory.verifyThePropertyExistence(propertyId);
        verificationFactory.verifyTheProperty(property);
        thePropertyDao.updateTheProperty(propertyId, property);
    }
}
