package employee.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    Choice choiceEmpid;
    JTable table;
    JButton search,update,print,back;

    View_Employee(){
        // We need Create First dropdown for choosing the EmpID

        // First printing the header & Choosing BackGround Color
        getContentPane().setBackground(new Color(255,131,122));
        JLabel head=new JLabel("Search by Employee ID");
        head.setBounds(20,20,150,20);
        add(head);

        // Adding the Empty dropdown
        choiceEmpid=new Choice();
        choiceEmpid.setBounds(180,20,150,20);
        add(choiceEmpid);
        // Adding Values for DropDown By Querying all the Employee ID's
        try {
            conn connection=new conn();
            ResultSet resultSet=connection.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEmpid.add(resultSet.getString("empID"));
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }

        // Displaying Table with a Scrollable Feature
        table=new JTable();
        try{
            conn c= new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception E){
            E.printStackTrace();
        }
        // To Scroll
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        // Now We are Adding 'Search','Update','Print','back' Buttons
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);



        // Window Settings
        setSize(900,700);
        setLayout(null);
        setLocation(300,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String query="select * from employee where empID ='"+choiceEmpid.getSelectedItem()+"'";
            try{
                conn c= new conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }else if (e.getSource() == print) {
            try {
                table.print(); // it will Help in Downloading the Table in Pdf Format
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            new Update_Employee(choiceEmpid.getSelectedItem());

        } else {
            setVisible(false);
            new Main_class();// Going Back
        }
    }
    public static void main(String[] args) {
        new View_Employee();
    }

    }



