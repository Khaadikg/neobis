package model;


import java.time.LocalDate;


public class Customer {
    private Long id;

    private String name;
    private String surname;
    private String username;
    private String password;
    private LocalDate createdDate;
    private Basket basket;
}
