package Library;

import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class ViewBook extends JFrame {
 
    String x[]={"bookno","bookname","author","publisher","quantity","issuebook","date"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0;int j=0;
    JTable t;
    Font f1,f2;

    ViewBook(){
        super("View Book");
        setLocation(1,1);
        setSize(1000,400);

        f1=new Font("Arial",Font.BOLD,25);
        
        try{
            ConnectionClass obj= new ConnectionClass();
            String q="Select * from books";
            ResultSet rest =obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("bookno");
                y[i][j++]=rest.getString("bookname");
                y[i][j++]=rest.getString("author");
                y[i][j++]=rest.getString("publisher");
                y[i][j++]=rest.getString("quantity");
                y[i][j++]=rest.getString("issuebook");
                y[i][j++]=rest.getString("date");

                i++;
                j=0;
            }
           t=new JTable(y,x);
           t.setFont(f1);


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
        new ViewBook().setVisible(true);

    }
    
}
