package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Operation;

import java.util.List;

public interface OperationDao {

    int saveOperation(Operation operation);

    void deleteOperation(int operationId);

    Operation getOperation(int operationId);

    List<Operation> getAll();

    //void updateOperation(int operationId, Operation operation);

}
