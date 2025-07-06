
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class info extends JFrame
{
    info(String username)
    {
        Font f = new Font("futura", Font.BOLD, 30);
        Font f2 = new Font("Calibri", Font.PLAIN, 26);


        JPanel p = new JPanel();
        p.setBounds(450,80,630,600);
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        p.setLayout(null);

        JLabel j1 = new JLabel("Update Students",JLabel.CENTER);
        j1.setFont(new Font("SansSerif", Font.BOLD, 40));
        j1.setForeground(new Color(23, 27, 99));
        j1.setBounds(100,10,500,150);
        p.add(j1);

        JLabel j2 = new JLabel("Student Name");
        j2.setFont(f2);
        j2.setBounds(60,150,300,50);
        p.add(j2);

        JTextField t1 = new JTextField(10);
        t1.setBounds(320,150,200,35);
        p.add(t1);

        JLabel j3 = new JLabel("Student Roll No");
        j3.setFont(f2);
        j3.setBounds(60,200,300,50);
        p.add(j3);

        JTextField t2 = new JTextField(10);
        t2.setBounds(320,200,200,35);
        p.add(t2);

        JLabel j6 = new JLabel("Divison");
        j6.setFont(f2);
        j6.setBounds(60,250,300,50);
        p.add(j6);

        JTextField t5 = new JTextField(10);
        t5.setBounds(320,250,200,35);
        p.add(t5);

        JLabel j4 = new JLabel("Student EmailId");
        j4.setFont(f2);
        j4.setBounds(60,300,300,50);
        p.add(j4);

        JTextField t3 = new JTextField(10);
        t3.setBounds(320,300,200,35);
        p.add(t3);

        JLabel j5 = new JLabel("Student Phone no");
        j5.setFont(f2);
        j5.setBounds(60,350,300,50);
        p.add(j5);

        JTextField t4 = new JTextField(10);
        t4.setBounds(320,350,200,35);
        p.add(t4);

        JLabel j7 = new JLabel("Gender");
        j7.setFont(f2);
        j7.setBounds(60,400,300,50);
        p.add(j7);

        JComboBox<String> gender = new JComboBox<>(new String[]{"male", "female"});
        gender.setBounds(320,400,200,35);
        gender.setFont(new Font("Calibri", Font.PLAIN, 26));
        p.add(gender);

        JLabel j8 = new JLabel("Class");
        j8.setFont(f2);
        j8.setBounds(60,450,300,50);
        p.add(j8);

        JComboBox<String> year = new JComboBox<>(new String[]{"F.E", "S.E", "T.E","B.E"});
        year.setBounds(320,450,200,35);
        year.setFont(new Font("Calibri", Font.PLAIN, 26));
        p.add(year);

        JButton b1 = new JButton("Add");
        b1.setFont(f2);
        b1.setBounds(30,520,100,40);
        b1.setBackground(new Color(35, 41, 96));
        b1.setForeground(Color.WHITE);
        p.add(b1);
        addHoverEffect(b1);

        JButton b2 = new JButton("Delete");
        b2.setFont(f2);
        b2.setBounds(250,520,150,40);
        b2.setBackground(new Color(35, 41, 96));
        b2.setForeground(Color.WHITE);
        p.add(b2);
        addHoverEffect(b2);

        JButton b3 = new JButton("Back");
        b3.setFont(f2);
        b3.setBounds(500,520,100,40);
        b3.setBackground(new Color(35, 41, 96));
        b3.setForeground(Color.WHITE);
        p.add(b3);
        addHoverEffect(b3);



        b1.addActionListener(
                a-> {
                    String s1 = year.getSelectedItem().toString();
                    if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("F.E"))
                    {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO fea(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("F.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO feb(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("F.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO fec(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO sea(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("b") || t5.getText().equals("B"))&& s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO seb(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO sec(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO tea(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO teb(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO tec(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO tea(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }

                    else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO beb(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO bec(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "INSERT INTO bea(name,roll,email,phone,gender,class) VALUES(?, ?, ?, ?, ?,?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t1.getText());
                                pst.setString(2, t2.getText());
                                pst.setString(3, t3.getText());
                                pst.setString(4, t4.getText());
                                pst.setString(5, gender.getSelectedItem().toString());
                                pst.setString(6, s1);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Added Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        b2.addActionListener(
                a->
                {
                    String s1 = year.getSelectedItem().toString();
                    if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("F.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM fea where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("F.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM feb where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("F.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM fec where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM sea where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM seb where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("S.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM sec where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM tea where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM teb where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }

                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("T.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM tec where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else if ((t5.getText().equals("a") || t5.getText().equals("A")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM bea where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }

                    else if ((t5.getText().equals("b") || t5.getText().equals("B")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM beb where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }

                    else if ((t5.getText().equals("c") || t5.getText().equals("C")) && s1.equals("B.E")) {
                        String url = "jdbc:mysql://localhost:3306/attendence";
                        try (Connection con = DriverManager.getConnection(url, "root", "Omk@r9090")) {
                            String sql = "DELETE FROM bec where roll=?";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1, t2.getText());
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "deleted Successfully");


                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        b3.addActionListener(a->
        {
            new Menu(username);
            dispose();
        });


        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(183, 223, 250));
        c.add(p);




        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update Students");
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
                                        button.setFont(new Font("Calibri", Font.PLAIN, 26));
                                        button.setForeground(Color.WHITE);
                                    }
                                }
        );
    }
}
class Update
{
    public static void main(String[] args) {
        info a = new info("username");

    }
}
