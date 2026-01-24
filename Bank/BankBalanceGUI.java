package Bank;

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
        account = new BankAccount(0.0);

        setTitle("Bank Balance Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        balanceLabel = new JLabel("Current Balance: $0.00");
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
        try {
            double amount = Double.parseDouble(amountField.getText());

            if (e.getSource() == depositButton) {
                account.deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                account.withdraw(amount);
            } else if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(this,
                        "Final Balance: $" + String.format("%.2f", account.getBalance()));
                System.exit(0);
            }

            balanceLabel.setText(
                    "Current Balance: $" + String.format("%.2f", account.getBalance()));
            amountField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new BankBalanceGUI();
    }
}


