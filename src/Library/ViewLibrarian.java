package Library;


//import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;

//import Library.ConnectionClass;

public class ViewLibrarian extends JFrame {
 
    String x[]={"name","password","EMAIL","CONTACT","ADDRESS","CITY"};
    JButton bt;
    String y[][]=new String[20][6];
    int i=0;int j=0;
    JTable t;
    Font f1,f2;

    ViewLibrarian(){
        super("View Librarian");
        setLocation(1,1);
        setSize(1000,400);

        f1=new Font("Arial",Font.BOLD,25);
        
        try{
            ConnectionClass obj= new ConnectionClass();
            String q="Select * from librarians";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("password");
                y[i][j++]=rest.getString("EMAIL");
                y[i][j++]=rest.getString("CONTACT");
                y[i][j++]=rest.getString("ADDRESS");
                y[i][j++]=rest.getString("CITY");

                i++;
                j=0;
            }
           t=new JTable(y,x);
           t.setFont(f2);


        }

        catch(Exception ee)
        {
            ee.printStackTrace();
        }


        JScrollPane jp=new JScrollPane(t);
        add(jp);


    }

    public static void main (String[] args)
    {
        new ViewLibrarian().setVisible(true);

    }
}