import javax.swing.*;
import java.awt.*;

class LoginPage extends JFrame {

    LoginPage() {
        // Custom Font
        Font titleFont = new Font("FORTE", Font.BOLD, 50);
        Font buttonFont = new Font("Calibri", Font.BOLD, 22);

        // Background Panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(60, 90, 153), 0, getHeight(), new Color(158, 200, 247));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Title
        JLabel title = new JLabel("Attendance Management System", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setBounds(350, 30, 900, 60);
        backgroundPanel.add(title);

        // Image Panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/landing.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(100, 150, 600, 500);
        backgroundPanel.add(image);

        // Login Panel
        JPanel p = new JPanel();
        p.setBounds(950, 180, 450, 400);
        p.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent white
        p.setLayout(null);
        p.setBorder(BorderFactory.createLineBorder(new Color(74, 98, 138), 3, true)); // Rounded border
        backgroundPanel.add(p);

        // Buttons
        JButton adminLogin = createStyledButton("Admin Login", 125, 100, buttonFont);
        JButton userLogin = createStyledButton("User Login", 125, 200, buttonFont);

        // Add buttons to panel
        p.add(adminLogin);
        p.add(userLogin);

        adminLogin.addActionListener(
                a->{
                    new Alogin();
                    dispose();
                }
        );

        userLogin.addActionListener(
                a->{
                    new first();
                    dispose();
                }
        );

        // Frame Settings
        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Attendance Management System");
    }

    // Method to create styled buttons
    private JButton createStyledButton(String text, int x, int y, Font font) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 50);
        button.setFont(font);
        button.setBackground(new Color(74, 98, 138));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        return button;
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
