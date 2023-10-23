package model;

import java.util.Set;

public class Basket {

    private Long id;
    private Customer customer;
    private Set<Product> products;

    public Basket() {
    }

    public Basket(Long id, Customer customer, Set<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
