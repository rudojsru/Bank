import java.util.ArrayList;
import java.util.List;

public class Bank {


    List customers = new ArrayList<Customer>() ;
    public void addCustomer(Customer customer) {
        customers.add(customer);

    }

      Customer getCustomer(int account) {
        return (Customer) customers.get(account);
    }

    ArrayList <Customer> getCustomers (){
        return (ArrayList<Customer>) customers;
    }
}
