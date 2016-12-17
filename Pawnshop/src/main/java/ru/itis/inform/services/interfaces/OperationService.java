package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.NewOperation;
import ru.itis.inform.models.Operation;

import java.util.List;

public interface OperationService {

    void saveOperation(NewOperation operation);

    void deleteOperation(int operationId);

    Operation getOperation(int operationId);

    List<Operation> getAll();

    void updateOperation(int operationId, Operation operation);

}
