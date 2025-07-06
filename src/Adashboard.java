import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

class Adashboard extends JFrame
{
    Adashboard()
    {
        Font titleFont = new Font("Futura", Font.BOLD, 40);
        Font tableFont = new Font("Calibri", Font.PLAIN, 18);
        Font buttonFont = new Font("Calibri", Font.BOLD, 20);


        JLabel title = new JLabel("Admin Dashboard", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(new Color(35, 41, 96));
        title.setOpaque(true);
        title.setBackground(new Color(183, 223, 250));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"Username", "Phoneno", "Email", "Gender"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(tableFont);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(115, 191, 246));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setGridColor(new Color(224, 224, 224));

        JScrollPane scrollPane = new JScrollPane(table);

        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);



        JButton b2 = new JButton("Back");
        b2.setFont(buttonFont);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(35, 41, 96));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        b2.addActionListener(e -> {
            new Alogin();
            dispose();
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(115, 191, 246));
        topPanel.add(title, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(224, 224, 224));
        bottomPanel.add(b2);

        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        Container c = getContentPane();
        c.setLayout(new BorderLayout(20, 20));
        c.add(topPanel, BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(bottomPanel, BorderLayout.SOUTH);

        String url = "jdbc:mysql://localhost:3306/attendence";
        try (Connection con = DriverManager.getConnection(url, "root", "Sid@53da$e")) {
            String sql = "select * from teacher ";
            try (PreparedStatement pst = con.prepareStatement(sql)) {


                ResultSet rs = pst.executeQuery();
                while (rs.next())
                {
                    String s1 = rs.getString("username");
                    String s2 = rs.getString("phoneno");
                    String s3 = rs.getString("emailid");
                    String s4 = rs.getString("Gender");


                    tableModel.addRow(new Object[]{s1,s2,s3,s4});
                }


            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        setTitle("Admin Dashboard");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Adashboard();
    }
}
