import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Div extends JFrame {
    Div(String username) {
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // Title
        JLabel title = new JLabel("Choose Division", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(new Color(35,41,96));
        title.setBounds(200,35,600,50);

        // Main panel
        JPanel p = new JPanel();
        int panelWidth = width - 550;
        int panelHeight = height - 250;
        p.setBounds(270, 90, panelWidth, panelHeight);
        p.setBackground(new Color(255, 255, 255));
        p.setLayout(null);
        p.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        // Buttons
        JButton A = new JButton("Div A");
        addHoverEffect(A);
        JButton B = new JButton("Div B");
        addHoverEffect(B);
        JButton C = new JButton("Div C");
        addHoverEffect(C);
        JButton bButton = new JButton("Back");
        addHoverEffect(bButton);

        Font btnFont = new Font("Arial", Font.BOLD, 20);
        Color btnColor = new Color(35, 41, 96);

        JButton[] buttons = {A, B, C};
        int btnWidth = 250;
        int btnHeight = 50;
        int btnX = panelWidth / 2 - btnWidth / 2;
        int gap = 100;

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = buttons[i];
            btn.setFont(btnFont);
            btn.setBackground(btnColor);
            btn.setForeground(Color.WHITE);
            btn.setBounds(btnX, 150 + (i * gap), btnWidth, btnHeight);
            p.add(btn);
        }

        // Back button
        bButton.setFont(btnFont);
        bButton.setBackground(new Color(35, 41, 96));
        bButton.setForeground(Color.WHITE);
        bButton.setBounds(50, panelHeight - 80, 200, 50);
        p.add(bButton);

        // Add components
        p.add(title);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(135, 197, 237));
        c.add(p);

        // Action Listeners
        bButton.addActionListener(e -> {
            new Student(username);
            dispose();
        });

        A.addActionListener(e -> {
            String username1 = JOptionPane.showInputDialog("Enter your name:");
            if (username1 != null && !username1.trim().isEmpty()) {
                new Table1(username1,username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username cannot be empty!");
                new Div(username);
            }
        });

        B.addActionListener(e -> {
            String username1 = JOptionPane.showInputDialog("Enter your name:");
            if (username1 != null && !username1.trim().isEmpty()) {
                new Table2(username1,username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username cannot be empty!");
                new Div(username);
            }
        });

        C.addActionListener(e -> {
            String username1 = JOptionPane.showInputDialog("Enter your name:");
            if (username1 != null && !username1.trim().isEmpty()) {
                new Table3(username1,username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username cannot be empty!");
                new Div(username);
            }
        });

        // Frame settings
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Choose Division");
        setVisible(true);
    }

    void addHoverEffect(JButton button)
    {
        button.addMouseListener(new MouseAdapter() {
                                    public void mouseEntered(MouseEvent e)
                                    {
                                        button.setBackground(new Color(100, 120, 180));
                                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                        button.setBorder(BorderFactory.createRaisedBevelBorder());
                                        button.setFont(new Font("Calibri", Font.BOLD, 22));

                                        button.setForeground(Color.YELLOW);
                                    }
                                    public void mouseExited(MouseEvent e)
                                    {
                                        button.setBackground(new Color(35, 41, 96));
                                        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
                                        button.setFont(new Font("Calibri", Font.PLAIN, 20));
                                        button.setForeground(Color.WHITE);
                                    }
                                }
        );
    }

    public static void main(String[] args) {
        new Div("Valaya");
    }
}
