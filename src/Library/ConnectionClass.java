package Library;

import java.sql.*;

public class ConnectionClass {
    Connection con;
    Statement stm;

    ConnectionClass(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","abhic1904","19119ani");
            stm=con.createStatement();
            if(con.isClosed())
            {
                System.out.println("Connection Not Found");
            }
            else{
                System.out.println("Connected");
            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConnectionClass();
    }

}
