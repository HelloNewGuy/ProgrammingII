import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuUI extends JFrame {

    private JTextField textField;
    private JPanel mainPanel;
    private Color savedGreenHue = null; // Stores initial Hue
    private final JMenuItem colorMenuItem;

    public MenuUI() {
        setTitle("Menu UI");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Main Panel (to change color background)
        mainPanel = new JPanel(new GridLayout());
        mainPanel.setBackground(Color.WHITE);
        setContentPane(mainPanel);

        // Text Box
        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setOpaque(false);
        textField.setEditable(false);
        add(textField, BorderLayout.CENTER);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem dateTimeItem = new JMenuItem("Show Date & Time");
        JMenuItem saveItem = new JMenuItem("Save to log.txt");
        colorMenuItem = new JMenuItem("Change Background (Green Hue)");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Menu Actions

        // 1. Show Date & Time
        dateTimeItem.addActionListener(e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateTime = LocalDateTime.now().format(formatter);
            textField.setText(dateTime);
        });

        // 2. Save to log.txt
        saveItem.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textField.getText());
                JOptionPane.showMessageDialog(this, "Saved to log.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file.");
            }
        });

        // 3. Change Background to random Green Hue
        colorMenuItem.addActionListener(e -> {
            if (savedGreenHue == null) {
                savedGreenHue = generateRandomGreen();
                String hex = String.format("#%02x%02x%02x" ,
                        savedGreenHue.getRed(),
                        savedGreenHue.getGreen(),
                        savedGreenHue. getBlue());
                colorMenuItem.setText("Green Hue: " + hex);
            }

            mainPanel.setBackground(savedGreenHue);
            mainPanel.repaint();
        });

        // 4. Exit
        exitItem.addActionListener(e -> System.exit(0));

        // Add items to Menu
        menu.add(dateTimeItem);
        menu.add(saveItem);
        menu.add(colorMenuItem);
        menu.add(exitItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    // Generate Random Green Hue
    private Color generateRandomGreen() {
        Random rand = new Random();
        int red = rand.nextInt(100);
        int green = 150 + rand.nextInt(106); //Strong green
        int blue = rand.nextInt(100);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuUI::new);
    }
}
