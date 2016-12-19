package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.validation.VerificationFactory;

import java.util.List;

/**
 * Проверка данных на корректность и вызов customerDao
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    VerificationFactory verificationFactory;
    @Autowired
    CustomerDao customerDao;

    @Override
    public void saveCustomer(Customer customer) {
        verificationFactory.verifyCustomer(customer);
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        verificationFactory.verifyCustomerExistence(customerId);
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public Customer getCustomer(int customerId) {
        verificationFactory.verifyCustomerExistence(customerId);
        Customer customer = customerDao.getCustomer(customerId);

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerDao.getAll();

        return customers;
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {
        verificationFactory.verifyCustomerExistence(customerId);
        verificationFactory.verifyDateOfBirth(customer.getDateOfBirth());
        Customer customerFromDB = customerDao.getCustomer(customerId);
        if (customer.getPassport() != null && !customer.getPassport().equals("")
                && !customer.getPassport().equals(customerFromDB.getPassport())) {
            verificationFactory.verifyPassport(customer.getPassport());
            verificationFactory.verifyPassportUnique(customer.getPassport());
        }
        if (customer.getPhoneNumber() != null && !customer.getPhoneNumber().equals("")
                && !customer.getPhoneNumber().equals(customerFromDB.getPhoneNumber())) {
            verificationFactory.verifyPhone(customer.getPhoneNumber());
            verificationFactory.verifyPhoneUnique(customer.getPhoneNumber());
        }

        customerDao.updateCustomer(customerId, customer);
    }
}
