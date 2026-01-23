import javax.swing.*;

public class ExFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");

        JLabel label = new JLabel("Welcome to my GUI!");
        frame.add(label);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
