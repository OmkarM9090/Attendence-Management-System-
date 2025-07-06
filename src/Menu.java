import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Menu extends JFrame {
    Menu(String username) {
        String teacher = username;
        Font f2 = new Font("Calibri", Font.PLAIN, 20);

        JPanel p = new JPanel();
        p.setBounds(350, 170, 800, 450);
        p.setBackground(new Color(255, 255, 255));
        p.setLayout(null);
        p.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JLabel title = new JLabel("Welcome " + username, JLabel.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 50));
        title.setForeground(new Color(0x100909));
        title.setBounds(260, 40, 1000, 50);

        JLabel subtitle = new JLabel("Main Menu", JLabel.CENTER);
        subtitle.setFont(new Font("Arial", Font.BOLD, 40));
        subtitle.setForeground(new Color(35, 41, 96));
        subtitle.setBounds(160, 10, 500, 40);
        p.add(subtitle);

        JButton[] buttons = {
                new JButton("Update Students"),
                new JButton("Log Out"),
                new JButton("Delete Account"),
                new JButton("Profile Setting"),
                new JButton("Attendance Sheet"),
                new JButton("Student Information")
        };

        int xPositions[] = {50, 50, 450, 50, 450, 450};
        int yPositions[] = {100, 200, 300, 300, 100, 200};

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = buttons[i];
            btn.setBounds(xPositions[i], yPositions[i], 300, 50);
            btn.setFont(f2);
            btn.setBackground(new Color(35, 41, 96));
            btn.setForeground(Color.WHITE);
            addHoverEffect(btn);
            p.add(btn);
        }

        buttons[0].addActionListener(
                a -> {
                    new info(username);
                    dispose();
                }
        );
        buttons[1].addActionListener(
                a -> {
                    JOptionPane.showMessageDialog(null, "LogOut Successful");
                    dispose();
                }
                );

        buttons[2].addActionListener(
                a->{
                    String user = teacher;
                    String url = "jdbc:mysql://localhost:3306/attendence";
                    try (Connection con = DriverManager.getConnection(url, "root", "Sid@53da$e")){
                        String sql = "DELETE FROM teacher WHERE username = ?";
                        try(PreparedStatement pst = con.prepareStatement(sql))
                        {
                            pst.setString(1,user);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Account deleted successfully");
                            new LoginPage();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
        );

        buttons[3].addActionListener(
                a -> {
                    new Setting(username);
                    dispose();
                }
                );
        buttons[4].addActionListener(
                a -> {
                    new Student(username);
                    dispose();
                }
                );
        buttons[5].addActionListener(a -> {
            new Student1(username);
            dispose();
        }
        );

        Container c = getContentPane();
        c.setLayout(null);
        c.add(title);
        c.setBackground(new Color(183, 223, 250));
        c.add(p);

        setVisible(true);
        setSize(2000, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home");
    }

     void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter()
        {
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
        new Menu("ADINATH");
    }
}
