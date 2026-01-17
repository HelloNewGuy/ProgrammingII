package Banking;

public class CheckingAccount extends BankAccount{

    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.0;

    public CheckingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        balance -= amount;

        if (balance < 0) {
            balance -= OVERDRAFT_FEE;
            System.out.println("Overdraft! A $30 fee has been assessed.");
        }

        System.out.println("Current Balance: $" + balance);
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
