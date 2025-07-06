import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
class first extends JFrame
{
    first()
    {
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 750, 800);
        p1.setBackground(new Color(183, 223, 250));
        p1.setLayout(null);

        JLabel l1 = new JLabel("Welcome Back!");
//        l1.setForeground(new Color(35, 41, 96));
        l1.setFont(new Font("Arial", Font.BOLD, 45));
        l1.setBounds(230, 200, 400, 50);
        p1.add(l1);

        JLabel l2 = new JLabel("Dont't have Account?");
//        l2.setForeground(new Color(35, 41, 96));
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(280, 280, 350, 40);
        p1.add(l2);

        JLabel l3 = new JLabel("keep connected with us ");
//        l3.setForeground(new Color(35, 41, 96));
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(280, 240, 450, 60);
        p1.add(l3);

        JButton b1 = new JButton("SIGN IN");
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(310, 340, 150, 40);
        b1.setBackground(new Color(35, 41, 96));
        b1.setForeground(Color.WHITE);
        p1.add(b1);
        addHoverEffect(b1);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(310, 400, 150, 40);
        back.setBackground(new Color(35, 41, 96));
        back.setForeground(Color.WHITE);
        p1.add(back);
        addHoverEffect(back);

        JPanel p2 = new JPanel();
        p2.setBounds(700, 0, 880, 850);
        p2.setBackground(new Color(255, 255, 255));
        p2.setLayout(null);

        JLabel l4 = new JLabel("Already have account");
        JLabel l5 = new JLabel("Login Here");
        l4.setFont(new Font("arial", Font.BOLD, 45));
        l5.setFont(new Font("calibari", Font.BOLD, 30));
        l4.setForeground(new Color(35, 41, 96));
        l5.setForeground(new Color(35, 41, 96));
        l4.setBounds(250, 170, 550, 40);
        l5.setBounds(380, 250, 350, 40);
        p2.add(l4);
        p2.add(l5);

        JLabel n = new JLabel("Username:");
        n.setBounds(250, 300, 200, 40);
        n.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField name = new JTextField(20);
        name.setFont(new Font("Calibri", Font.PLAIN, 26));
        name.setBounds(370, 300, 200, 40);
        p2.add(n);
        p2.add(name);

//        JTextField email = new JTextField(" Email");
//        email.setBounds(180, 310, 200, 40);
//        p2.add(email);

        JLabel n2 = new JLabel("Password:");
        n2.setFont(new Font("Arial", Font.BOLD, 20));
        n2.setBounds(250,370,200,40);
        JPasswordField pass = new JPasswordField(20);
        pass.setBounds(370, 370, 200, 40);
        pass.setFont(new Font("Calibri", Font.PLAIN, 26));
        p2.add(n2);
        p2.add(pass);

        JButton b2 = new JButton("LOGIN");
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBounds(390, 450, 150, 40);
        b2.setBackground(new Color(35, 41, 96));
        b2.setForeground(Color.WHITE);
        addHoverEffect(b2);
        p2.add(b2);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p1);
        c.add(p2);

        b1.addActionListener(
                a->{
                    new SignUp();
                    dispose();
                }
        );
        back.addActionListener(
                a->
                {
                    new LoginPage();
                    dispose();
                }
        );



        b2.addActionListener(
                a-> {
                    String url = "jdbc:mysql://localhost:3306/attendence";
                    try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                        String sql = "select * from teacher where username=? and password=?";
                        try (PreparedStatement pst = con.prepareStatement(sql)) {
                            pst.setString(1, name.getText());
                            String s1 = new String(pass.getPassword());

                            pst.setString(2,s1);

                            ResultSet rs = pst.executeQuery();

                            if(rs.next())
                            {
                                JOptionPane.showMessageDialog(null,"login successful");
                                new Menu(name.getText());
                                dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Users Does not Exist");
                            }

                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Login Unsuccesful");
                    }
                }
        );

        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Attendance Management System");
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
                                        button.setFont(new Font("arial", Font.BOLD, 20));
                                        button.setForeground(Color.WHITE);
                                    }
                                }
        );
    }
}
class landing
{
    public static void main(String[] args) {
        new first();
    }
}