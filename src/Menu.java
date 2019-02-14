import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner keybord =new Scanner(System.in);
    Bank bank =new Bank ();
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public  void runMenu(){
        printHeader();
        while (!exit){
            printMenu();
            int choise = getInput();
            performAction(choise);

        }

    }

    private void printHeader() {
        System.out.println("+-------------------+");
        System.out.println("| Welcom to Mr RS   |");
        System.out.println("|Avesome Bank App   |");
        System.out.println("+-------------------+");

    }
    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println(" 1) Create a new account");
        System.out.println(" 2) Make a deposit");
        System.out.println(" 3) Make a withdrawal");
        System.out.println(" 4) List account balance");
        System.out.println(" 0) EXIT");
    }

    private int getInput() {
        int choise =- 1;
        do {
            System.out.println("Enter your choice: ");
            try {
                choise = Integer.parseInt(keybord.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Number only please");
            }
            if (choise < 0 || choise > 4) {
                System.out.println("Choice outside of range. Please chose again");
            }
        }while (choise < 0 || choise > 4);

        return choise;
    }

    private void performAction( int choise) {
        switch (choise){
            case 0:
                System.out.println("Thank you for using our application");
                System.exit(0);  break;
            case 1:
                 createAnAccount();
                break;
            case 2:
                  makeADeposit();
                break;
            case 3:
                 makeAWithdrawal();
                break;
            case 4:
                 listBalances();
                break;
            default:
                    System.out.println("Unknown error has occured.");

        }
    }

    private void createAnAccount() {
        String firstName, lastName, ssn, accountType="";
        double initialDeposit=0;
        boolean valid=false;
        while (!valid){
            System.out.println("Please enter an account type(checking/saving): ");
            accountType=keybord.nextLine();
            if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("saving")){
                valid =true;
            }
            else {
                System.out.println("Invalid account type selected. Please enter checking or savings.");
            }
        }
        System.out.println("Please enter your first name: ");
        firstName=keybord.nextLine();
        System.out.println("Please enter your last name: ");
        lastName=keybord.nextLine();
        System.out.println("Please enter your social security number: ");
        ssn = keybord.nextLine();
        valid =false;
        while (!valid){
            System.out.println("Please enter an initial deposit: ");
            try{
                initialDeposit=Double.parseDouble(keybord.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Deposit must be a number");
            }
            if( accountType.equalsIgnoreCase("checking")){
               if (initialDeposit <100 )  {
                 System.out.println("Checking account require a minimum of 100");
               }else {
                      valid=true;
               }
            }else  if( accountType.equalsIgnoreCase("saving")) {
                if (initialDeposit < 50) {
                    System.out.println("Savings account require a minimum of 50 PLN to open");
                } else {
                    valid = true;
                }
            }
        }
        //We can create an account now
        Account account;
        if (accountType.equalsIgnoreCase("checking")){
            account =new Checking(initialDeposit);
        } else {
           account =new Savings(initialDeposit);
        }
        Customer customer = new Customer(firstName,lastName, ssn, account);
        bank.addCustomer(customer);
    }

    private void makeADeposit() {
        int account = selectAccount();
        if(account >=0){
        System.out.println(" How much would you like to deposit?: ");
        double amount=0;
        try{
            amount=Double.parseDouble(keybord.nextLine());
        }catch (NumberFormatException e) {
            amount=0;
        }
        bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private void makeAWithdrawal() {
        int account = selectAccount();
        if(account >=0){
            System.out.println(" How much would you like to withdraw?: ");
            double amount=0;
            try{
                amount=Double.parseDouble(keybord.nextLine());
            }catch (NumberFormatException e) {
                amount=0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }
    }

    private void listBalances() {
        int account = selectAccount();
        if(account >=0){

            System.out.println(bank.getCustomer(account).getAccount());
        }
    }

    private int selectAccount() {
        List<Customer> customers = bank.getCustomers();
        if(customers.size() <=0){
            System.out.println("No customers at your bank.");
            return -1;
        }
        System.out.println("Select an account");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i+1) + ")" +customers.get(i).basicInfo());
        }
        int account =0;
        System.out.println("Please enter your selection");
        try{
            account = Integer.parseInt(keybord.nextLine())-1;
        }
        catch (NumberFormatException e ){
            account =-1;
        }
        if (account <0 || account >customers.size()){
            System.out.println("Invalid account selected.");
            return -1;
        }
        return account;
    }

}
