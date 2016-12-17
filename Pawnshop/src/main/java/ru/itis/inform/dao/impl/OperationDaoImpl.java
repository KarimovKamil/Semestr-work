package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.OperationDao;
import ru.itis.inform.models.NewOperation;
import ru.itis.inform.models.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OperationDaoImpl implements OperationDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String CREATE_OPERATION_SQL =
            "SELECT add_operation(:customerId, :goodsType, :goodsDescription, :price, :timeOfReturn);";
    private static final String DELETE_OPERATION_SQL =
            "DELETE FROM operation WHERE operation_id = :operationId;";
    private static final String GET_OPERATION_BY_ID_SQL =
            "SELECT * FROM operation WHERE operation_id = :operationId;";
    private static final String GET_ALL_OPERATIONS_SQL =
            "SELECT * FROM operation ORDER BY(operation_id);";
    private static final String UPDATE_OPERATION_SQL =
            "UPDATE operation SET (customer_id, time_of_return, status, return_amount) = " +
                    "(:customerId, :timeOfReturn, :status, :returnAmount) " +
                    "WHERE operation_id = :operationId;";

    private RowMapper<Operation> operationMapper() {
        return (resultSet, i) -> {
            Operation operation = new Operation.Builder()
                    .operationId(resultSet.getInt("operation_id"))
                    .goodsId(resultSet.getInt("goods_id"))
                    .customerId(resultSet.getInt("customer_id"))
                    .pledgeDate(resultSet.getDate("pledge_date"))
                    .timeOfReturn(resultSet.getInt("time_of_return"))
                    .status(resultSet.getString("status"))
                    .returnAmount(resultSet.getInt("return_amount"))
                    .build();

            return operation;
        };
    }

    @Override
    public void saveOperation(NewOperation newOperation) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", newOperation.getCustomerId());
        params.put("goodsType", newOperation.getGoodsType());
        params.put("goodsDescription", newOperation.getGoodsDescription());
        params.put("price", newOperation.getPrice());
        params.put("timeOfReturn", newOperation.getTimeOfReturn());

        namedParameterJdbcTemplate.queryForObject(CREATE_OPERATION_SQL, params, String.class);
    }

    @Override
    public void deleteOperation(int operationId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("operationId", operationId);

        namedParameterJdbcTemplate.update(DELETE_OPERATION_SQL, params);
    }

    @Override
    public Operation getOperation(int operationId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("operationId", operationId);

        return namedParameterJdbcTemplate.queryForObject(GET_OPERATION_BY_ID_SQL, params, operationMapper());
    }

    @Override
    public List<Operation> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_OPERATIONS_SQL, operationMapper());
    }

    @Override
    public void updateOperation(int operationId, Operation operation) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", operation.getCustomerId());
        params.put("timeOfReturn", operation.getTimeOfReturn());
        params.put("status", operation.getStatus());
        params.put("returnAmount", operation.getReturnAmount());
        params.put("operationId", operationId);

        namedParameterJdbcTemplate.update(UPDATE_OPERATION_SQL, params);
    }
}
