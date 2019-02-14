public class Customer {

    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    Customer(String firstName, String lastName, String ssn, Account account){
        this.firstName =firstName;
        this.lastName =lastName;
        this.ssn =ssn;
        this.account =account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\\n" +
                ", ssn='" + ssn + "\n" +
                ", account=" + account +
                '}';
    }

     public String basicInfo() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", account number=" + account.getAccountNumber();
    }
}
