package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.OperationDao;
import ru.itis.inform.models.NewOperation;
import ru.itis.inform.models.Operation;
import ru.itis.inform.services.interfaces.OperationService;
import ru.itis.inform.validation.VerificationFactory;

import java.util.List;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationDao operationDao;
    @Autowired
    VerificationFactory verificationFactory;

    @Override
    public void saveOperation(NewOperation operation) {
        verificationFactory.verifyCustomerExistence(operation.getCustomerId());
        verificationFactory.verifyNewOperation(operation);
        operation.setGoodsType(operation.getGoodsType().toUpperCase());
        operationDao.saveOperation(operation);
    }

    @Override
    public void deleteOperation(int operationId) {
        verificationFactory.verifyOperationExistence(operationId);
        operationDao.deleteOperation(operationId);
    }

    @Override
    public Operation getOperation(int operationId) {
        verificationFactory.verifyOperationExistence(operationId);
        Operation operation = operationDao.getOperation(operationId);
        return operation;
    }

    @Override
    public List<Operation> getAll() {
        return operationDao.getAll();
    }

    @Override
    public void updateOperation(int operationId, Operation operation) {
        verificationFactory.verifyOperationExistence(operationId);
        verificationFactory.verifyCustomerExistence(operation.getCustomerId());
        verificationFactory.verifyOperation(operation);
        operation.setStatus(operation.getStatus().toUpperCase());
        operationDao.updateOperation(operationId, operation);
    }
}
