package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {

    void createCustomerTable();

    void dropCustomerTable();

    void saveCustomer(String name, String surname, String username, String password);

    void removeCustomerById(long id);

    List<Customer> getAllCustomers();

    void cleanCustomersTable();
    Customer getCustomerById(Long id);
    void updateCustomerById(long id, String newName, String newSurname);
}
