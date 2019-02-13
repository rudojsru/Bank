public class BankMain {
    public static void main(String[] args) {


        //create cust2;
        Account cust1 =new Account();
        cust1.deposit(500);

        //create cust2
        Account cust2 =new Account();
        cust2.deposit(100);

        cust1.withdraw(800);


        System.out.print("Cust1 has a balance of ");
        System.out.println(cust1.getBalance());
        System.out.print("Cust2 has a balance of ");
        System.out.println(cust2.getBalance());


    }
}
