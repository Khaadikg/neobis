package dao;

import model.Customer;
import util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    BasketDaoImpl basketDao = new BasketDaoImpl();

    public void createCustomerTable() {
        String SQL = """
                    CREATE TABLE if not exists customer (
                        id BIGSERIAL NOT NULL UNIQUE,
                        DATE DATE DEFAULT CURRENT_TIMESTAMP,
                        name VARCHAR(255),
                        password VARCHAR(255),
                        surname VARCHAR(255),
                        username VARCHAR(255),
                        PRIMARY KEY (id)
                    );""";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropCustomerTable() {
        String SQL = "DROP TABLE IF EXISTS customer;";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCustomer(String name, String surname, String username, String password) {
        String SQL = "INSERT INTO customer(name, surname, username, password)" +
                     "VALUES (?,?,?,?);";
        Long user_id = null;
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {;
                user_id = resultSet.getLong("id");
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        basketDao.createBasket(user_id);
    }

    public void removeCustomerById(long id) {
        String SQL = "DELETE FROM customer WHERE id = ?";
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        String SQL = "SELECT * FROM customer;";
        List<Customer> list = new ArrayList<>();
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPassword(resultSet.getString("password"));
                customer.setCreatedDate(resultSet.getDate("date").toLocalDate());
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanCustomersTable() {
        dropCustomerTable();
        createCustomerTable();
    }

    @Override
    public Customer getCustomerById(Long id) {
        String SQL = "SELECT FROM customer where id = ?";
        Customer customer = null;
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            customer.setId(resultSet.getLong("id"));
            customer.setName(resultSet.getString("name"));
            customer.setSurname(resultSet.getString("surname"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));
            customer.setCreatedDate(resultSet.getDate("date").toLocalDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomerById(long id, String newName, String newSurname) {
        String SQL = """
                    UPDATE customer 
                    SET name = ?, surname = ?
                    where customer.id = ?;""";
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, newName);
            statement.setString(2, newSurname);
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}