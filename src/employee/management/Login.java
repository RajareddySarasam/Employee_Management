package employee.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Now Using the ActionListener Interface
public class Login extends  JFrame implements ActionListener{

    // Declaring Global variables to store the username and Password which can further used in Cheecking in Database
    JTextField tusername;
    JPasswordField tpassword;

    // Creating the 'Login' & 'Back' Buttons.
    JButton login,back;

    Login(){

        // Taking input from User

        // JLabel is to print the Text on the window we created
        // 1. Username
        JLabel username=new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        // Field for Entering the username
        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);


        // 2.Password
        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        // Field for Entering the Password
        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        // Login Button
        login =new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Back Button
        back =new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        // Login page settings

        setSize(600,300); // dimensions of the login page
        setLocation(450,200); // location of the window
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try{
                // extracting only text from userinput
                String username=tusername.getText();
                String password=tpassword.getText();

                conn connection =new conn();
                String query = "select * from login where username='"+username+"' and password ='"+password+"' ";
                ResultSet resultSet=connection.statement.executeQuery(query);

                // so,the Result of the query is Stored in the Result set variable.
                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == back) {
            System.exit(10);
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}


