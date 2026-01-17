package Banking;

public class BankTest {

    public static void main(String[] args) {

        CheckingAccount account = new CheckingAccount(2.5);

        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountID(1001);

        account.deposit(100);
        account.processWithdrawal(150);

        System.out.println();
        account.displayAccount();
    }
}
