import dao.CustomerDaoImpl;
import service.WorldService;

public class Main {
    public static void main(String[] args) {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        WorldService.cleanWorld();

        dao.saveCustomer("Haadi", "Bolotbekov", "admin", "admin");
        dao.saveCustomer("Asel", "Aselova", "user", "user");
        dao.saveCustomer("Asenov", "Asan", "user2", "user2");

        dao.getAllCustomers().forEach(System.out::println);
        System.out.println("Deleting element #2");
        dao.removeCustomerById(2);
        dao.getAllCustomers().forEach(System.out::println);
        System.out.println("Updating element #1");
        dao.updateCustomerById(1, "Khaadi", "Jackson");
        dao.getAllCustomers().forEach(System.out::println);

    }
}
