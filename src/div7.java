import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Div7 extends JFrame {
    Div7(String username) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        JLabel title = new JLabel("Choose Division", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(new Color(35,41,96));
        title.setBounds(200,35,600,50);

        JPanel p = new JPanel();
        int panelWidth = width - 550;
        int panelHeight = height - 250;
        p.setBounds(270, 90, panelWidth, panelHeight);
        p.setBackground(new Color(255, 255, 255));
        p.setLayout(null);
        p.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        JButton A = new JButton("Div A");
        addHoverEffect(A);
        JButton B = new JButton("Div B");
        addHoverEffect(B);
        JButton C = new JButton("Div C");
        addHoverEffect(C);

        p.add(title);
        p.add(A);
        p.add(B);
        p.add(C);




        A.setFont(new Font("Arial", Font.BOLD, 20));
        B.setFont(new Font("Arial", Font.BOLD, 20));
        C.setFont(new Font("Arial", Font.BOLD, 20));

        A.setBackground(new Color(35, 41, 96));
        B.setBackground(new Color(35, 41, 96));
        C.setBackground(new Color(35, 41, 96));

        A.setForeground(Color.WHITE);
        B.setForeground(Color.WHITE);
        C.setForeground(Color.WHITE);

        JButton bButton = new JButton("Back");
        addHoverEffect(bButton);
        bButton.setFont(new Font("Arial", Font.BOLD, 20));
        bButton.setBackground(new Color(35, 41, 96));
        bButton.setForeground(Color.WHITE);
        p.add(bButton);

        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(135, 197, 237));

//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(screenSize);
//        setUndecorated(true);
//        setResizable(false);

//        int windowWidth = screenSize.width;
//        int windowHeight = screenSize.height;

        A.setBounds(350,150,250,50);
        B.setBounds(350,250,250,50);
        C.setBounds(350,350,250,50);
        bButton.setBounds(80,510,200,50);

//        c.add(title);
//        c.add(A);
//        c.add(B);
//        c.add(C);
        c.add(p);
//        c.add(bButton);

        bButton.addActionListener(
                a->{
                    new Student1(username);
                    dispose();
                }
        );

        A.addActionListener(a -> {
            new Table09(username);
            dispose();
        });

        B.addActionListener(
                a->
                {
                    new Table010(username);
                    dispose();
                }
        );
        C.addActionListener(
                a->
                {
                    new Table011(username);
                    dispose();
                }
        );

        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Choose Division");
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
        new Div7("");
    }
}