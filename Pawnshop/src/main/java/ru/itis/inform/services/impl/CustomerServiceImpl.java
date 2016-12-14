package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Goods;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.validation.VerificationFactory;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    VerificationFactory verificationFactory;
    @Autowired
    CustomerDao customerDao;

    public void saveCustomer(Customer customer) {
        verificationFactory.verifyPhone(customer.getPhoneNumber());
        verificationFactory.verifyPassport(customer.getPassport());
        verificationFactory.verifyPhoneUnique(customer.getPhoneNumber());
        verificationFactory.verifyPassportUnique(customer.getPassport());

        customerDao.saveCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        verificationFactory.verifyCustomerExistence(customerId);
        customerDao.deleteCustomer(customerId);
    }

    public Customer getCustomer(int customerId) {
        verificationFactory.verifyCustomerExistence(customerId);
        Customer customer = customerDao.getCustomer(customerId);

        return customer;
    }

    public List<Customer> getAll() {
        List<Customer> customers = customerDao.getAll();

        return customers;
    }

    public List<Goods> getCustomerGoods(int customerId) {
        verificationFactory.verifyCustomerExistence(customerId);
        return null;
    }

    public int getCustomerDebts(int customerId) {
        return 0;
    }

    public void updateCustomer(int customerId, Customer customer) {
        verificationFactory.verifyCustomerExistence(customerId);
        Customer customerFromDB = customerDao.getCustomer(customerId);
        if (customer.getDateOfBirth() != null) {
            customerFromDB.setDateOfBirth(customer.getDateOfBirth());
        }
        if (customer.getFirstName() != null && !customer.getFirstName().equals("")) {
            customerFromDB.setFirstName(customer.getFirstName());
        }
        if (customer.getLastName() != null && !customer.getLastName().equals("")) {
            customerFromDB.setLastName(customer.getLastName());
        }
        if (customer.getMiddleName() != null && !customer.getMiddleName().equals("")) {
            customerFromDB.setMiddleName(customer.getMiddleName());
        }
        if (customer.getPassport() != null && !customer.getPassport().equals("")) {
            verificationFactory.verifyPassport(customer.getPassport());
            verificationFactory.verifyPassportUnique(customer.getPassport());
            customerFromDB.setPassport(customer.getPassport());
        }
        if (customer.getPhoneNumber() != null && !customer.getPhoneNumber().equals("")) {
            verificationFactory.verifyPhone(customer.getPhoneNumber());
            verificationFactory.verifyPhoneUnique(customer.getPhoneNumber());
            customerFromDB.setPhoneNumber(customer.getPhoneNumber());
        }

        customerDao.updateCustomer(customerId, customerFromDB);
    }
}
