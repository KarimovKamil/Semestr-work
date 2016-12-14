package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Goods;
import ru.itis.inform.validation.dao.CustomerValidator;
import ru.itis.inform.validation.dao.GoodsValidator;
import ru.itis.inform.validation.dao.OperationValidator;
import ru.itis.inform.validation.dao.ThePropertyValidator;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@Component
public class VerificationFactory {

    @Autowired
    CustomerValidator customerValidator;
    @Autowired
    GoodsValidator goodsValidator;
    @Autowired
    OperationValidator operationValidator;
    @Autowired
    ThePropertyValidator thePropertyValidator;
    @Autowired
    DataValidation dataValidation;

    public void verifyCustomerExistence(int id) {
        if (!customerValidator.verifyCustomer(id)) {
            throw new IncorrectDataException("Incorrect customer");
        }
    }

    public void verifyGoodsExistence(int id) {
        if (!goodsValidator.verifyGoods(id)) {
            throw new IncorrectDataException("Incorrect goods");
        }
    }

    public void verifyOperationExistence(int id) {
        if (!operationValidator.verifyOperation(id)) {
            throw new IncorrectDataException("Incorrect operation");
        }
    }

    public void verifyThePropertyExistence(int id) {
        if (!thePropertyValidator.verifyTheProperty(id)) {
            throw new IncorrectDataException("Incorrect the property");
        }
    }

    public void verifyPhone(String phone) {
        if (!dataValidation.verifyPhone(phone)) {
            throw new IncorrectDataException("Incorrect phone");
        }
    }

    public void verifyPassport(String passport) {
        if (!dataValidation.verifyPassport(passport)) {
            throw new IncorrectDataException("Incorrect passport");
        }
    }

    public void verifyPhoneUnique(String phone) {
        if (customerValidator.verifyPhoneExistence(phone)) {
            throw new IncorrectDataException("Phone number is already exists");
        }
    }

    public void verifyPassportUnique(String passport) {
        if (customerValidator.verifyPassportExistence(passport)) {
            throw new IncorrectDataException("Passport is already exists");
        }
    }

    public void verifyGoods(Goods goods) {
        if (goods.getGoodsPrice() <= 0) {
            throw new IncorrectDataException("Incorrect price");
        }

        if (goods.getGoodsType() == null || goods.getGoodsType().equals("")) {
            throw new IncorrectDataException("Incorrect goods type");
        }
    }
}
