package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Customer;

import java.util.List;

public interface CustomerDao {

    int saveCustomer(Customer customer);

    void deleteCustomer(int customerId);

    Customer getCustomer(int customerId);

    List<Customer> getAll();

    void updateCustomer(int customerId, Customer customer);

}
