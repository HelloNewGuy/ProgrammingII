package bankapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceGUI extends JFrame implements ActionListener {

    private BankAccount account;

    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;

    public BankBalanceGUI() {

        // Get starting balance from user
        double initialBalance = 0.0;

        String input = JOptionPane.showInputDialog(
                this,
                "Enter starting balance:",
                "Initial Balance",
                JOptionPane.QUESTION_MESSAGE
        );

        try {
            initialBalance = Double.parseDouble(input);
            if (initialBalance < 0) {
                initialBalance = 0;
            }
        } catch (Exception e) {
            initialBalance = 0;
        }

        account = new BankAccount(initialBalance);

        setTitle("Bank Balance Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        balanceLabel = new JLabel("Current Balance: $" +
                String.format("%.2f", account.getBalance()));

        amountField = new JTextField();

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel.add(new JLabel("Enter Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this,
                    "Final Balance: $" +
                            String.format("%.2f", account.getBalance()));
            System.exit(0);
        }

        try {
            double amount = Double.parseDouble(amountField.getText());

            if (e.getSource() == depositButton) {
                if (!account.deposit(amount)) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid deposit amount.");
                }
            }

            if (e.getSource() == withdrawButton) {
                if (!account.withdraw(amount)) {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient funds or invalid amount.");
                }
            }

            balanceLabel.setText("Current Balance: $" +
                    String.format("%.2f", account.getBalance()));

            amountField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new BankBalanceGUI();
    }
}
