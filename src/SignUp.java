import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class SignUp extends JFrame{

    SignUp()
    {
        Font f = new Font("Calibri", Font.PLAIN, 26);

        JPanel p = new JPanel();
        p.setBounds(420,80,640,600);
        p.setBackground(Color.WHITE);
        p.setLayout(null);

//        Border blackline = BorderFactory.createLineBorder(Color.BLACK,8);
        p.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));


        JLabel title = new JLabel("Sign Up");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setBounds(240, 30, 400, 50);
        title.setForeground(new Color(23, 27, 99));
        p.add(title);

        JLabel l1 = new JLabel("Username");
        JTextField t1 = new JTextField(20);
        l1.setFont(f);
        t1.setFont(f);
        l1.setBounds(100,150,200,30);
        t1.setBounds(320,150,200,30);
        p.add(l1);
        p.add(t1);

        JLabel l2 = new JLabel("Password");
        JTextField t2 = new JTextField(20);
        l2.setFont(f);
        t2.setFont(f);
        l2.setBounds(100,200,200,30);
        t2.setBounds(320,200,200,30);
        p.add(l2);
        p.add(t2);

        JLabel l3 = new JLabel("Confirm Password");
        JTextField t3 = new JTextField(20);
        l3.setFont(f);
        t3.setFont(f);
        l3.setBounds(100,250,200,30);
        t3.setBounds(320,250,200,30);
        p.add(l3);
        p.add(t3);

        JLabel l4 = new JLabel("Phone Number");
        JTextField t4 = new JTextField(20);
        l4.setFont(f);
        t4.setFont(f);
        l4.setBounds(100,300,200,30);
        t4.setBounds(320,300,200,30);
        p.add(l4);
        p.add(t4);

        JLabel l5 = new JLabel("Email Id");
        JTextField t5 = new JTextField(20);
        l5.setFont(f);
        t5.setFont(f);
        l5.setBounds(100,350,200,30);
        t5.setBounds(320,350,200,30);
        p.add(l5);
        p.add(t5);

        JLabel l6 = new JLabel("Gender");
        JComboBox<String> box = new JComboBox<>(new String[]{"Male", "Female"});
        l6.setFont(f);
        box.setFont(f);
        l6.setBounds(100,400,200,30);
        box.setBounds(320,400,200,30);
        p.add(l6);
        p.add(box);

        JButton b1 = new JButton("Back");
        b1.setBounds(120,500,100,40);
        b1.setFont(f);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(35, 41, 96));
        p.add(b1);

        JButton b2 = new JButton("Next");
        b2.setBounds(420,500,100,40);
        b2.setFont(f);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(35, 41, 96));
        p.add(b2);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/back.jpeg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(0,0,1600,1600);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p);
//        c.add(image);
        c.setBackground(new Color(183, 223, 250));

        b1.addActionListener(
                a->{
                    new first();
                    dispose();
                }
        );

        b2.addActionListener(
                a-> {
//
                    String s1 = t4.getText().trim();
                    String email = t5.getText().trim();

                    if (t2.getText().equals(t3.getText()) && s1.matches("\\d{10}") && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO teacher(username, password, phoneno, emailid, gender) VALUES(?, ?, ?, ?, ?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t4.getText());
                                pst.setString(4, t5.getText());
                                pst.setString(5, box.getSelectedItem().toString());

                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Sign up is successful");
                                new first();
                                  dispose();
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else {
                        if (!t2.getText().equals(t3.getText())) {
                            JOptionPane.showMessageDialog(null, "Password is not matching");
                        } else if (!s1.matches("\\d{10}")) {
                            JOptionPane.showMessageDialog(null, "Phone number should contain 10 digits");
                        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                            JOptionPane.showMessageDialog(null, "Invalid Email ID! Please include '@' in the email address.");
                        }
                    }
                }
        );


        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Attendance Management System");
    }

    public static void main(String[] args) {
        new SignUp();
    }
}