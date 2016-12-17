package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Goods;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);

    Customer getCustomer(int customerId);

    List<Customer> getAll();

    void updateCustomer(int customerId, Customer customer);

}
