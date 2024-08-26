package employee.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener{

    JTextField tname, tfname, taddress,tphone, taadhar, temail, tsalary,tdesignation;
    JDateChooser tdob;
    JComboBox Boxeducation;

    Random ran = new Random();
    int number = ran.nextInt(999999);
    JLabel tempid;

    JButton add,back;

    AddEmployee(){

        // Name Input of Employee
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(Color.WHITE);
        add(tname);

        // father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        // Used a jar file of Calendar
        // DOB

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(Color.WHITE);
        add(tdob);

        // Salary of Employee
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        // phone Number

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(Color.WHITE);
        add(temail);

        // Education -> using ComboBox to select an item from given Array
        JLabel education = new JLabel("Higest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(education);

        String items[] = {"BTech","BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(Color.WHITE);
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        // Aadhar Number
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(aadhar);

        taadhar= new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(Color.WHITE);
        add(taadhar);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        // Randomly Assigned Employee Id
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Adding Two Buttons -> Add and Back
        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        // Background Color Setting of Window
        getContentPane().setBackground(new Color(163,200,180));
        // Heading of the Window
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        // Window Settings
        setSize(900,700);
        setLayout(null);
        setLocation(200,30);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent a){
        if (a.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            // Extracting Date
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            // Using getSelectedItem() and Casting it into 'String'
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();
            try{
                // Insert the Details into Employee table
                conn conn = new conn();
                String query="insert into employee values('"+name+"', '"+fname+"', '"+dob+"'," +
                        " '"+salary+"','"+address+"'," + " '"+phone+"', '"+email+"', '"+education+"'," +
                        " '"+designation+"','"+aadhar+"', '"+empID+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main_class();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        else {
            setVisible(false);
            new Main_class();
        }

    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}
