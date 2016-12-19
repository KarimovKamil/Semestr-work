package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.*;
import ru.itis.inform.validation.dao.CustomerValidator;
import ru.itis.inform.validation.dao.GoodsValidator;
import ru.itis.inform.validation.dao.OperationValidator;
import ru.itis.inform.validation.dao.ThePropertyValidator;

import java.sql.Date;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */

/**
 * Проверка данных на коректность
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

    public void verifyCustomer(Customer customer) {
        verifyPhone(customer.getPhoneNumber());
        verifyPassport(customer.getPassport());
        verifyPhoneUnique(customer.getPhoneNumber());
        verifyPassportUnique(customer.getPassport());
        verifyDateOfBirth(customer.getDateOfBirth());
    }

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

    public void verifyOperation(Operation operation) {
        if (operation.getTimeOfReturn() <= 0) {
            throw new IncorrectDataException("Incorrect time of return");
        }

        if (operation.getReturnAmount() <= 0) {
            throw new IncorrectDataException("Incorrect return amount");
        }

        String status = operation.getStatus().toUpperCase();
        if (!"REPAID".equals(status) && !"OVERDUE".equals(status)
                && !"DEPT".equals(status)) {
            throw new IncorrectDataException("Incorrect status");
        }
    }

    public void verifyNewOperation(NewOperation operation) {
        if (operation.getGoodsType() == null || operation.getGoodsType().equals("")) {
            throw new IncorrectDataException("Incorrect goods type");
        }

        if (operation.getTimeOfReturn() <= 0) {
            throw new IncorrectDataException("Incorrect time of return");
        }

        if (operation.getPrice() <= 0) {
            throw new IncorrectDataException("Incorrect price");
        }
    }

    public void verifyGoodsIsProperty(int goodsId) {
        if (!goodsValidator.verifyGoodsIsProperty(goodsId)) {
            throw new IncorrectDataException("Incorrect goods id");
        }
    }

    public void verifyTheProperty(TheProperty theProperty) {
        if (theProperty.getDwellingSpace() <= 0) {
            throw new IncorrectDataException("Incorrect dwelling space");
        }
    }

    public void verifyThePropertyWithThisGoods(int goodsId) {
        if (thePropertyValidator.verifyThePropertyWithThisGoods(goodsId)) {
            throw new IncorrectDataException("The property is already exists");
        }
    }

    public void verifyDateOfBirth(Date date) {
        Date date1 = new Date(20, 1, 1);
        Date date2 = new Date(100, 1, 1);
        if (date.before(date1) || date.after(date2)) {
            throw new IncorrectDataException("Incorrect date of birth");
        }
    }
}
