import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.sql.*;
import java.util.ArrayList;

class AbsentStudentReport extends JFrame {
    AbsentStudentReport(String subject, String date, String time, String username1, Object[][] absentStudents, String username) {
        setTitle("Daily Attendance Report");
        setSize(800, 600);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 250));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Font titleFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 18);

        JLabel title = new JLabel("Daily Attendance Report", JLabel.CENTER);
        title.setFont(titleFont);
        title.setBounds(200, 20, 400, 30);
        add(title);

        JLabel subjectLabel = new JLabel("Subject: " + subject);
        JLabel dateLabel = new JLabel("Date: " + date);
        JLabel timeLabel = new JLabel("Time: " + time);
        JLabel teacherLabel = new JLabel("Subject Teacher: " + username1);

        subjectLabel.setBounds(50, 70, 300, 30);
        dateLabel.setBounds(50, 110, 300, 30);
        timeLabel.setBounds(50, 150, 300, 30);
        teacherLabel.setBounds(50, 190, 300, 30);

        subjectLabel.setFont(labelFont);
        dateLabel.setFont(labelFont);
        timeLabel.setFont(labelFont);
        teacherLabel.setFont(labelFont);

        add(subjectLabel);
        add(dateLabel);
        add(timeLabel);
        add(teacherLabel);

        JButton copyButton = new JButton("Copy");
        copyButton.setBounds(600, 70, 100, 30);
        add(copyButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(600, 110, 100, 30);
        add(backButton);

        String[] columnNames = {"Roll No", "Name"};
        DefaultTableModel model = new DefaultTableModel(absentStudents, columnNames);
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(25);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 240, 700, 300);
        add(scrollPane);

        copyButton.addActionListener(e -> {
            StringBuilder data = new StringBuilder();
            data.append("Subject: ").append(subject).append("\n")
                    .append("Date: ").append(date).append("\n")
                    .append("Time: ").append(time).append("\n")
                    .append("Subject Teacher: ").append(username1).append("\n\n")
                    .append("Absent Students:\n");
            for (Object[] row : absentStudents) {
                if (row[0] != null && row[1] != null) {
                    data.append("Roll No: ").append(row[0])
                            .append(" - Name: ").append(row[1]).append("\n");
                }
            }
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(data.toString()), null);
            JOptionPane.showMessageDialog(this, "Copied to clipboard!");
        });

        backButton.addActionListener(
                a->{
//                    new Table3(username);
                    dispose();
                }
        );


        setVisible(true);
    }
}


class Table1 extends JFrame {
    Table1(String username1, String username) {
        setTitle("Attendance Sheet");
        setSize(1200, 700);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 250, 240));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font titleFont = new Font("Arial", Font.BOLD, 24);

        JLabel title = new JLabel("Attendance Sheet FE Div A", JLabel.CENTER);
        title.setFont(titleFont);
        title.setBounds(450, 20, 350, 30);
        add(title);

        JLabel rollLabel = new JLabel("Absent Roll Nos:");
        JLabel subjectLabel = new JLabel("Subject:");
        JLabel dateLabel = new JLabel("Date:");
        JLabel timeLabel = new JLabel("Time:");

        JTextField rollInput = new JTextField();
        JTextField subjectInput = new JTextField();
        JTextField dateInput = new JTextField();

        String[] hours = new String[12];
        String[] minutes = new String[60];
        for (int i = 0; i < 12; i++) hours[i] = String.format("%02d", i + 1);
        for (int i = 0; i < 60; i++) minutes[i] = String.format("%02d", i);

        JComboBox<String> startHour = new JComboBox<>(hours);
        JComboBox<String> startMin = new JComboBox<>(minutes);
        JComboBox<String> startAmPm = new JComboBox<>(new String[]{"AM", "PM"});

        JComboBox<String> endHour = new JComboBox<>(hours);
        JComboBox<String> endMin = new JComboBox<>(minutes);
        JComboBox<String> endAmPm = new JComboBox<>(new String[]{"AM", "PM"});

        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");



        rollLabel.setBounds(50, 80, 120, 30);
        rollInput.setBounds(180, 80, 200, 30);
        subjectLabel.setBounds(400, 80, 80, 30);
        subjectInput.setBounds(480, 80, 150, 30);
        dateLabel.setBounds(650, 80, 50, 30);
        dateInput.setBounds(700,80, 100, 30);


        timeLabel.setBounds(50, 130, 50, 30);
        startHour.setBounds(110, 130, 60, 30);
        startMin.setBounds(180, 130, 60, 30);
        startAmPm.setBounds(250,130, 70, 30);
        endHour.setBounds(340,130, 60, 30);
        endMin.setBounds(410, 130, 60, 30);
        endAmPm.setBounds(480, 130, 70, 30);
        searchButton.setBounds(580, 130, 100, 30);
        backButton.setBounds(700, 130, 100, 30);


        add(rollLabel);
        add(rollInput);
        add(subjectLabel);
        add(subjectInput);
        add(dateLabel);
        add(dateInput);
        add(timeLabel);
        add(startHour);
        add(startMin);
        add(startAmPm);
        add(endHour);
        add(endMin);
        add(endAmPm);
        add(searchButton);
        add(backButton);

        String[] cols = {"Roll No", "Name"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        table.setRowHeight(25);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(center);
        table.getColumnModel().getColumn(1).setCellRenderer(center);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 180, 1100, 400);
        add(scrollPane);

        searchButton.addActionListener(e -> {
            model.setRowCount(0);
            String absentRolls = rollInput.getText();
            String subject = subjectInput.getText();
            String date = dateInput.getText();
            String time = startHour.getSelectedItem() + ":" + startMin.getSelectedItem() + " " + startAmPm.getSelectedItem()
                    + " to " + endHour.getSelectedItem() + ":" + endMin.getSelectedItem() + " " + endAmPm.getSelectedItem();

            String[] rollNumbers = absentRolls.split("[, ]+");
            ArrayList<Object[]> absentList = new ArrayList<>();

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence", "root", "Omk@r9090")) {
                String sql = "SELECT roll, name FROM fea WHERE roll = ?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    for (String roll : rollNumbers) {
                        if (!roll.trim().isEmpty()) {
                            pst.setString(1, roll.trim());
                            ResultSet rs = pst.executeQuery();
                            while (rs.next()) {
                                Object[] row = {rs.getString("roll"), rs.getString("name")};
                                absentList.add(row);
                                model.addRow(row);
                            }
                        }
                    }
                    Object[][] absentStudents = absentList.toArray(new Object[0][0]);
                    new AbsentStudentReport(subject, date, time, username1, absentStudents,username);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        backButton.addActionListener(a -> new Div(username));

        setVisible(true);
    }
}


public class Attendance {
    public static void main(String[] args) {
        String username1 = JOptionPane.showInputDialog("Enter your name:");
        new Table1(username1,"");
    }
}