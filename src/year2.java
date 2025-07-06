import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class Student1 extends JFrame
{
    Student1(String username)
    {
        Font f = new Font("futura", Font.BOLD, 40);
        Font f2 = new Font("Calibri", Font.PLAIN, 22);

        JPanel p = new JPanel();
        p.setBounds(440,100,600,600);
        p.setBackground(new Color(255, 255, 255));

        p.setLayout(null);


        p.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JLabel j1 = new JLabel("Choose Your Year",JLabel.CENTER);
        j1.setFont(new Font("SansSerif", Font.BOLD, 40));
        j1.setForeground(new Color(23, 27, 99));
        j1.setForeground(Color.BLACK);

        JButton b1 = new JButton("Fe");
        b1.setFont(f2);
        addHoverEffect(b1);
        JButton b2 = new JButton("Se");
        addHoverEffect(b2);
        b2.setFont(f2);
        JButton b3 = new JButton("Te");
        addHoverEffect(b3);
        b3.setFont(f2);
        JButton b4 = new JButton("Be");
        addHoverEffect(b4);
        b4.setFont(f2);
        JButton b5 = new JButton("Back");
        addHoverEffect(b5);
        b5.setFont(f2);
        JButton b6 = new JButton("Next");
        b6.setFont(f2);

        Color c1 = new Color(35, 41, 96);

        b1.setBackground(c1);
        b1.setForeground(Color.WHITE);
        b2.setBackground(c1);
        b2.setForeground(Color.WHITE);
        b3.setBackground(c1);
        b3.setForeground(Color.WHITE);
        b4.setBackground(c1);
        b4.setForeground(Color.WHITE);
        b5.setBackground(c1);
        b5.setForeground(Color.WHITE);
        b6.setBackground(c1);
        b6.setForeground(Color.WHITE);


        p.add(j1);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
//        p.add(b6);




        Container c = getContentPane();
        c.setLayout(null);

        j1.setBounds(30, 50, 600, 80);

        b1.setBounds(50, 200, 200, 50);
        b2.setBounds(350, 200, 200, 50);

        b3.setBounds(50, 300, 200, 50);
        b4.setBounds(350, 300, 200, 50);

        b5.setBounds(30,500,100,50);
        b6.setBounds(480,500,100,50);

        c.add(p);
        c.setBackground(new Color(183, 223, 250));

//       c.add(j1);
//       c.add(b1);
//       c.add(b2);
//       c.add(b3);
//       c.add(b4);
//       c.add(b5);

        b1.addActionListener(
                a->{
                    new Div4(username);
                    dispose();
                }
        );
        b2.addActionListener(
                a->{
                    new Div5(username);
                    dispose();
                }
        );
        b3.addActionListener(
                a->{
                    new Div6(username);
                    dispose();
                }
        );
        b4.addActionListener(
                a->{
                    new Div7(username);
                    dispose();
                }
        );

        b5.addActionListener(
                a->{
                    new Menu(username);
                    dispose();
                }
        );





        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Choose year");
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
}
class year2
{
    public static void main(String[] args) {
        Student1 a = new Student1("");


    }
}


