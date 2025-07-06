import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Forget extends JFrame {
    Forget() {

        Font f = new Font("Calibri", Font.PLAIN, 26);

        JPanel p = new JPanel();
        p.setBounds(0,0,700,1600);
        p.setBackground(new Color(183, 223, 250));
        p.setLayout(null);

        JLabel title = new JLabel("Forget Password");
        title.setFont(new Font("ITALIC", Font.BOLD, 40));
        title.setBounds(100, 100, 500, 50);
        p.add(title);

        JLabel l1 = new JLabel("Username");
        JTextField t1 = new JTextField(20);
        l1.setFont(f);
        t1.setFont(f);
        l1.setBounds(100,250,200,30);
        t1.setBounds(320,250,200,30);
        p.add(l1);
        p.add(t1);

        JLabel l2 = new JLabel("New Password");
        JTextField t2 = new JTextField(20);
        l2.setFont(f);
        t2.setFont(f);
        l2.setBounds(100,350,200,30);
        t2.setBounds(320,350,200,30);
        p.add(l2);
        p.add(t2);

        JButton b1 = new JButton("Back");
        b1.setBounds(100,500,100,30);
        b1.setFont(f);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(35, 41, 96));
        p.add(b1);

        JButton b2 = new JButton("Next");
        b2.setBounds(400,500,100,30);
        b2.setFont(f);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(35, 41, 96));
        p.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/forget.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(700,50,600,800);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p);
        c.add(image);
        c.setBackground(Color.WHITE);

        setVisible(true);
        setSize(2000, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Attendance Management System");
    }

    public static void main(String[] args) {
        new Forget();
    }
}