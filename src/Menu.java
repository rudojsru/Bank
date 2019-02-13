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
        String firstName, lastName, ssn;
        double initialDeposit;
    }

    private void makeADeposit() {
    }

    private void makeAWithdrawal() {
    }

    private void listBalances() {
    }

}
