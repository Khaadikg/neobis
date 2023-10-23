package dao;

public interface BasketDao {
    void createBasket(Long userId);
    void createBasketTable();
    void removeBasketById(Long id);
    void dropAllBasketTable();
    void cleanBasket();
}
