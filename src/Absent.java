import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class absentstudent extends JFrame
{
    absentstudent(Object[] objects)
    {

        Font titleFont = new Font("Futura", Font.BOLD, 40);
        Font tableFont = new Font("Calibri", Font.PLAIN, 18);
        Font buttonFont = new Font("Calibri", Font.BOLD, 20);

        JLabel title = new JLabel("Absent Students", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(new Color(16, 9, 9));
        title.setOpaque(true);
        title.setBackground(new Color(255, 250, 104));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"Name","Roll No","class"};
        DefaultTableModel absenttable = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(absenttable);
        table.setFont(tableFont);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(255, 157, 84));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setGridColor(new Color(224, 224, 224));

        JScrollPane scrollPane = new JScrollPane(table);
        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JTextField t3 = new JTextField(10);


//        JButton b1 = new JButton("search");
//        b1.setFont(buttonFont);
//        b1.setBackground(new Color(0, 153, 76));
//        b1.setForeground(Color.WHITE);


//        JComboBox<String> time = new JComboBox<>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
//        JComboBox<String> time2 = new JComboBox<>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
//        JComboBox<String> time3 = new JComboBox<>(new String[]{"am","pm"});



        JButton backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 51, 51));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.add(title, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(224, 224, 224));
        bottomPanel.add(backButton);

//        JPanel filterPanel = new JPanel();
//        filterPanel.setBackground(new Color(224, 224, 224));
//        filterPanel.add(new JLabel("Enter Absent Students Roll no"));
//        filterPanel.add(t1);
//        filterPanel.add(new JLabel("Subject Name"));
//        filterPanel.add(t2);
//        filterPanel.add(new JLabel("Date"));
//        filterPanel.add(t3);
//        filterPanel.add(new JLabel("Timming:"));
//        filterPanel.add(time);
//        filterPanel.add(new JLabel(" To "));
//        filterPanel.add(time2);
//        filterPanel.add(time3);

//        filterPanel.add(b1);
        absenttable.addRow(objects);

        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));
//        centerPanel.add(filterPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        Container c = getContentPane();
        c.setLayout(new BorderLayout(20, 20));
        c.add(topPanel, BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(bottomPanel, BorderLayout.SOUTH);


        setVisible(true);
        setSize(2000,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Students Information");
    }


}
class Absent
{
    public static void main(String[] args) {
        absentstudent a = new absentstudent(new Object[]{});

    }
}
