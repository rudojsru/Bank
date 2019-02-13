public class Checking extends Account {
    private static String accountType="Checking";

    Checking(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
         if(initialDeposit >10000){
             this.setInterest(5);
         }else {
             this.setInterest(2);
         }
    }

    @Override
    public String toString() {
        return  "Account Type " + accountType+ "Account\n"+
                "Account Number "+this.getAccountNumber()+"\n"+
                "Balance"+this.getBalance()+"\n"+
                "Interest Rate"+this.getInterest()+"\n";

    }
}
