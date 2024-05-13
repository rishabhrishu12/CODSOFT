import javax.swing.*;
import java.awt.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateStud extends JFrame implements ActionListener {
    // Declare and initialize text fields and labels and buttons
    private JButton submit, cancel;
    private JTextField tfAddress, tfPhone, tfEmail, tfCourse, tfBranch;
    private JLabel labelRollNo;
    private Choice cRoll;

    UpdateStud() {

        // Create an ImageIcon object with the image located at "Image/Logo.jpg"
        ImageIcon image = new ImageIcon("Image/Logo.jpg");

        // Set the icon image of the JFrame
        setIconImage(image.getImage());

        // Set the size and location of the frame
        setSize(800, 600);
        setLocation(280, 40);

        // Set the layout of the frame to null
        setLayout(null);

        // Add a heading label
        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(265, 15, 450, 40);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel heading2 = new JLabel("Search by Roll No. ");
        heading2.setBounds(50, 75, 180, 20);
        heading2.setFont(new Font("Courier", Font.BOLD, 15));
        add(heading2);

        cRoll = new Choice();
        cRoll.setBounds(250, 75, 200, 20);
        add(cRoll);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                cRoll.add(rs.getString("roll"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add a name label and text field
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60, 120, 100, 30);
        lblName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblName);

        JLabel name = new JLabel();
        name.setBounds(200, 120, 150, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(name);

        // Add a roll number label and label to display the roll number
        JLabel lblRoll = new JLabel("Roll No.: ");
        lblRoll.setBounds(420, 120, 150, 30);
        lblRoll.setFont(new Font("serif", Font.BOLD, 20));
        add(lblRoll);

        labelRollNo = new JLabel();
        labelRollNo.setBounds(570, 120, 150, 30);
        labelRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelRollNo);

        // Add a father's name label and text field
        JLabel lblFName = new JLabel("Father's Name: ");
        lblFName.setBounds(60, 170, 150, 30);
        lblFName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblFName);

        JLabel FName = new JLabel();
        FName.setBounds(200, 170, 150, 30);
        FName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(FName);

        // Add D.O.B label and calender chooser
        JLabel lblDOB = new JLabel("D.O.B: ");
        lblDOB.setBounds(420, 170, 150, 30);
        lblDOB.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDOB);

        // JLabel dob = new JLabel();
        // dob.setBounds(200, 170, 150, 30);
        // add(dob);

        // Add a Address label and text field
        JLabel lblAddress = new JLabel("Address: ");
        lblAddress.setBounds(60, 220, 150, 30);
        lblAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 220, 520, 30);
        tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfAddress);

        // Add a phone label and text field
        JLabel lblPhone = new JLabel("Phone No.: ");
        lblPhone.setBounds(60, 270, 150, 30);
        lblPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 270, 150, 30);
        tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfPhone);

        // Add a email label and text field
        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(420, 270, 150, 30);
        lblEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(570, 270, 150, 30);
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfEmail);

        // Add class 10% label and text field
        JLabel lbl10 = new JLabel("Class X (%): ");
        lbl10.setBounds(60, 320, 150, 30);
        lbl10.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl10);

        JLabel x = new JLabel();
        x.setBounds(200, 320, 150, 30);
        x.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(x);

        // Add class 12% label and text field
        JLabel lbl12 = new JLabel("Class XII (%): ");
        lbl12.setBounds(420, 320, 150, 30);
        lbl12.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl12);

        JLabel xii = new JLabel();
        xii.setBounds(570, 320, 150, 30);
        xii.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(xii);

        // Add course label and dropDown
        JLabel lblCourse = new JLabel("Faculty: ");
        lblCourse.setBounds(60, 370, 150, 30);
        lblCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblCourse);

        tfCourse = new JTextField();
        tfCourse.setBounds(200, 370, 150, 30);
        tfCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfCourse);

        // Add course label and dropDown
        JLabel lblBranch = new JLabel("Branch: ");
        lblBranch.setBounds(420, 370, 150, 30);
        lblBranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblBranch);

        tfBranch = new JTextField();
        tfBranch.setBounds(570, 370, 150, 30);
        tfBranch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfBranch);

        try {
            // Connect to the database
            Conn c = new Conn();

            // Define the SQL query to retrieve the student data based on the selected roll
            // number
            String query = "select * from student where roll = '" + cRoll.getSelectedItem() + "'";

            // Execute the SQL query and retrieve the result set
            ResultSet rs = c.s.executeQuery(query);

            // Iterate through the result set and populate the form fields with the student
            // data
            while (rs.next()) {
                name.setText(rs.getString("name"));
                labelRollNo.setText(rs.getString("roll"));
                FName.setText(rs.getString("fname"));
                // dob.setText(rs.getString("name"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                x.setText(rs.getString("class_X"));
                xii.setText(rs.getString("class_XII"));
                tfCourse.setText(rs.getString("course"));
                tfBranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add an item listener to the cRoll combo box to update the form fields when
        // the selected roll number changes
        cRoll.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                try {
                    // Connect to the database
                    Conn c = new Conn();

                    // Define the SQL query to retrieve the student data based on the selected roll
                    // number
                    String query = "select * from student where roll = '" + cRoll.getSelectedItem() + "'";

                    // Execute the SQL query and retrieve the result set
                    ResultSet rs = c.s.executeQuery(query);

                    // Iterate through the result set and populate the form fields with the student
                    // data
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                        labelRollNo.setText(rs.getString("roll"));
                        FName.setText(rs.getString("fname"));
                        // dob.setText(rs.getString("name"));
                        tfAddress.setText(rs.getString("address"));
                        tfPhone.setText(rs.getString("phone"));
                        tfEmail.setText(rs.getString("email"));
                        x.setText(rs.getString("class_X"));
                        xii.setText(rs.getString("class_XII"));
                        tfCourse.setText(rs.getString("course"));
                        tfBranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 470, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(430, 470, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Set the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the action event
        if (e.getSource() == submit) {
            // Get the text from the text fields
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String course = tfCourse.getText();
            String branch = tfBranch.getText();

            try {
                // Create a SQL query to insert the student details into the database
                String query = "update student set address='" + address + "', phone='" + phone + "', email='" + email
                        + "', course='" + course + "', branch='" + branch + "' where roll = '" + cRoll.getSelectedItem()
                        + "'";

                // Execute the SQL query
                Conn c = new Conn();
                c.s.executeUpdate(query);

                // Display a success message
                JOptionPane.showMessageDialog(null, "Student's Detail Updated Successfully");
                setVisible(false);

            } catch (Exception ae) {
                // Display an error message if there is an exception
                ae.printStackTrace();
            }

        }
        // Hide the frame when the cancel button is clicked
        setVisible(false);
    }

    // Main method to create an instance of the AddStud class
    public static void main(String[] args) {
        new UpdateStud();
    }
}