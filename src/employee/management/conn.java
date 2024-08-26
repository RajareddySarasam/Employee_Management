package employee.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    // Creating connection between MySQL and Our Java Package
    Connection connection;
    Statement statement;

    public conn(){
        try{
            // Connecting to our Database in MySQL .

            //This line loads the MySQL JDBC driver into memory
            Class.forName("com.mysql.cj.jdbc.Driver");

            // This line establishes a connection to the MySQL database using the DriverManager.getConnection() method.
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","123456789");

            // It returns a Statement object that can be used to send SQL commands to the database.
            statement=connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }


}
