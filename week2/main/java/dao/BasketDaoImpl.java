package dao;

import util.Util;

import java.sql.*;

public class BasketDaoImpl implements BasketDao{
    @Override
    public void createBasket(Long customerId) {
        String SQL = """
                    INSERT INTO basket(customer_id) values (?)""";
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setLong(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBasketTable() {
        String SQL = """
                    CREATE TABLE if not exists basket (
                        id BIGSERIAL NOT NULL,
                        customer_id BIGINT,
                        PRIMARY KEY (id)
                    );""";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBasketById(Long id) {
        String SQL = "DELETE FROM basket WHERE id = ?";
        try(Connection connection = Util.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropAllBasketTable() {
        String SQL = "DROP TABLE basket CASCADE;";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createBasketTable();
    }

    @Override
    public void cleanBasket() {
        String SQL = "DROP TABLE basket CASCADE;";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createBasketTable();
    }
}
