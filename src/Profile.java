import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

class Setting extends JFrame
{
    Setting(String username)
    {
        Font f = new Font("Calibri", Font.PLAIN, 26);

        JPanel p = new JPanel();
        p.setBounds(300,80,670,600);
        p.setBackground(new Color(255, 255, 255));
        p.setLayout(null);

        p.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));


        JLabel title = new JLabel("Profile Settings");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setBounds(180, 30, 400, 50);
        title.setForeground(new Color(23, 27, 99));
        p.add(title);

        JLabel l1 = new JLabel("Select to Update");
        JComboBox<String> box = new JComboBox<>(new String[]{"Username","Password", "PhoneNo", "Email"});
        l1.setFont(f);
        box.setFont(f);
        l1.setBounds(100,150,400,30);
        box.setBounds(350,150,200,30);
        p.add(l1);
        p.add(box);

        JLabel l2 = new JLabel("Enter new value");
        JTextField t2 = new JTextField();
        l2.setFont(f);
        t2.setFont(f);
        l2.setBounds(100,300,400,30);
        t2.setBounds(350,300,200,30);
        p.add(l2);
        p.add(t2);

        JButton b1 = new JButton("Back");
        b1.setFont(f);
        b1.setBounds(90,450,150,40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(35, 41, 96));
        p.add(b1);

        JButton b2 = new JButton("Update");
        b2.setFont(f);
        b2.setBounds(440,450,150,40);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(35, 41, 96));
        p.add(b2);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p);
        c.setBackground(new Color(183, 223, 250));


        b2.addActionListener(
                a->
                {
                    String s1= box.getSelectedItem().toString().toLowerCase();
                    String s2=t2.getText();

                    if(s2.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Cannot enter value");
                        return;
                    }

                    //database
                    String url="jdbc:mysql://localhost:3306/attendence";
                    try(Connection con= DriverManager.getConnection(url,"root","Sid@53da$e"))
                    {
                        String sql="update teacher set "+s1+"=? where username=?";
                        try(PreparedStatement pst= con.prepareStatement(sql))
                        {
                            pst.setString(1,s2);
                            pst.setString(2,username);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null,"Successfully updated");
                            t2.setText("");

                        }
                    }catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                        return;
                    }

                    if(s1.equals("username"))
                    {
                        dispose();
                        new Setting(s2);
                        //String url = "jdbc:mysql://localhost:3306/batch2";
                        try(Connection con = DriverManager.getConnection(url,"root","Sid@53da$e"))
                        {
                            String sql = "update teacher set username = ? where username = ?";
                            try(PreparedStatement pst = con.prepareStatement(sql))
                            {
                                pst.setString(1,s2);
                                pst.setString(2,username);
                                pst.executeUpdate();
                            }
                            catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }

                    }
                }
        );

        b1.addActionListener(
                a->{
                    new Menu(username);
                    dispose();
                }
        );

        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Profile Setting");
    }

}
class Profile
{
    public static void main(String[] args)
    {
        Setting s1 = new Setting("username");
    }
}