package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String CREATE_CUSTOMER_SQL =
            "INSERT INTO customer (passport, last_name, first_name, " +
                    "middle_name, date_of_birth, phone_number) VALUES (:passport, " +
                    ":lastName, :firstName, :middleName, :dateOfBirth, :phoneNumber) " +
                    "RETURNING customer_id;";
    private static final String DELETE_CUSTOMER_SQL =
            "DELETE FROM customer WHERE customer_id = :customerId;";
    private static final String GET_CUSTOMER_BY_ID_SQL =
            "SELECT * FROM customer WHERE customer_id = :customerId;";
    private static final String GET_ALL_CUSTOMERS_SQL =
            "SELECT * FROM customer ORDER BY(customer_id);";
    private static final String UPDATE_CUSTOMER_SQL =
            "UPDATE customer SET (passport, last_name, first_name, middle_name, date_of_birth, phone_number) " +
                    "= (:passport, :lastName, :firstName, :middleName, :dateOfBirth, :phoneNumber) " +
                    "WHERE customer_id = :customerId";

    private RowMapper<Customer> customerMapper() {
        return (resultSet, i) -> {
            Customer customer = new Customer.Builder()
                    .customerId(resultSet.getInt("customer_id"))
                    .passport(resultSet.getString("passport"))
                    .lastName(resultSet.getString("last_name"))
                    .firstName(resultSet.getString("first_name"))
                    .middleName(resultSet.getString("middle_name"))
                    .dateOfBirth(resultSet.getDate("date_of_birth"))
                    .phoneNumber(resultSet.getString("phone_number"))
                    .build();

            return customer;
        };
    }

    public int saveCustomer(Customer customer) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("passport", customer.getPassport());
        params.put("lastName", customer.getLastName());
        params.put("firstName", customer.getFirstName());
        params.put("middleName", customer.getMiddleName());
        params.put("dateOfBirth", customer.getDateOfBirth());
        params.put("phoneNumber", customer.getPhoneNumber());

        return namedParameterJdbcTemplate.queryForObject(CREATE_CUSTOMER_SQL, params, int.class);
    }

    public void deleteCustomer(int customerId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);

        namedParameterJdbcTemplate.update(DELETE_CUSTOMER_SQL, params);
    }

    public Customer getCustomer(int customerId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customerId", customerId);

        return namedParameterJdbcTemplate.queryForObject(GET_CUSTOMER_BY_ID_SQL, params, customerMapper());
    }

    public List<Customer> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_CUSTOMERS_SQL, customerMapper());
    }

    public int getCustomerDebts(int customerId) {
        return 0;
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("passport", customer.getPassport());
        params.put("lastName", customer.getLastName());
        params.put("firstName", customer.getFirstName());
        params.put("middleName", customer.getMiddleName());
        params.put("phoneNumber", customer.getPhoneNumber());
        params.put("dateOfBirth", customer.getDateOfBirth());
        params.put("customerId", customerId);
        namedParameterJdbcTemplate.update(UPDATE_CUSTOMER_SQL, params);
    }
}
