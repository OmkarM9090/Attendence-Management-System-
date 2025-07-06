import javax.swing.*;
import java.awt.*;

class Alogin extends JFrame {
    Alogin() {
        // Set overall frame properties
        setTitle("Attendance Management System - Admin Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(2500, 850); // Adjusted for modern screen sizes
        setLocationRelativeTo(null);
        setLayout(null); // Using null layout for custom placement

        // Load image on left
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/admin.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(50, 150, 600, 500);


        // Title
        JLabel title = new JLabel("Admin Login");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setBounds(700, 70, 400, 50);
        title.setForeground(new Color(23, 27, 99));
        add(title);

        // Panel for login form
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(650, 150, 500, 400);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        add(loginPanel);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 20);

        JLabel l1 = new JLabel("Username");
        l1.setFont(labelFont);
        l1.setBounds(40, 30, 400, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(40, 70, 420, 35);
        t1.setFont(labelFont);

        JLabel l2 = new JLabel("Password");
        l2.setFont(labelFont);
        l2.setBounds(40, 130, 400, 30);
        JPasswordField p1 = new JPasswordField();
        p1.setBounds(40, 170, 420, 35);
        p1.setFont(labelFont);

        JButton b1 = new JButton("Login");
        b1.setFont(labelFont);
        b1.setBounds(40, 240, 180, 45);
        b1.setBackground(new Color(23, 27, 99));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);

        JButton b2 = new JButton("Back");
        b2.setFont(labelFont);
        b2.setBounds(280, 240, 180, 45);
        b2.setBackground(new Color(100, 100, 100));
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);

        Container c = getContentPane();
        c.add(image);
        c.setBackground(Color.white);

        // Add components to panel
        loginPanel.add(l1);
        loginPanel.add(t1);
        loginPanel.add(l2);
        loginPanel.add(p1);
        loginPanel.add(b1);
        loginPanel.add(b2);

        // Event handling
        b1.addActionListener(e -> {
            String s1 = t1.getText().toLowerCase();
            String s2 = new String(p1.getPassword());

            if (s1.equals("admin") && s2.equals("password")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                new Adashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Enter valid username and password");
            }
        });

        b2.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Alogin();
    }
}
