package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.NewOperation;
import ru.itis.inform.models.Operation;

import java.util.List;

public interface OperationDao {

    void saveOperation(NewOperation newOperation);

    void deleteOperation(int operationId);

    Operation getOperation(int operationId);

    List<Operation> getAll();

    void updateOperation(int operationId, Operation operation);

}
