package service;

import dao.BasketDaoImpl;
import dao.CustomerDaoImpl;

public class WorldService {
    private static CustomerDaoImpl customerDao = new CustomerDaoImpl();
    private static BasketDaoImpl basketDao = new BasketDaoImpl();

    public static void cleanWorld() {
        customerDao.cleanCustomersTable();
        basketDao.cleanBasket();
    }
}
