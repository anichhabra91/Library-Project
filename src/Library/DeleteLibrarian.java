package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
//import java.sql.*;


public class DeleteLibrarian extends JFrame implements ActionListener{

    String x[]={"name","password","EMAIL","CONTACT","ADDRESS","CITY"};
        JButton bt;
        String y[][]=new String[20][6];
        int i=0;int j=0;
        JTable t;
        Font f1,f2;
        JTextField tf1;
        JPanel p1;
        JLabel l1;

    DeleteLibrarian()
    {
        super("Delete Librarian");
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
           t.setFont(f1);


        }

        catch(Exception ee)
        {
            ee.printStackTrace();
        }

        l1= new JLabel("Delete Librarian");
        tf1=new JTextField();
        bt=new JButton("Delete");
        bt.addActionListener(this);
        l1.setFont(f1);
        tf1.setFont(f1);
        bt.setFont(f1);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt);

        setLayout(new BorderLayout(10,10));

        JScrollPane jp=new JScrollPane(t);
        add(jp,"Center");
        add(p1,"South");


    }

    public void actionPerformed (ActionEvent e){

        if(e.getSource()==bt){
            String name=tf1.getText();
            try{
                ConnectionClass obj= new ConnectionClass();
                String q="Delete from librarians where name='"+name+"'";
                int res=obj.stm.executeUpdate(q);
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null,"Your data has been deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }

                else{
                    JOptionPane.showMessageDialog(null,"Your data has not been deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
            }
            catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
    }

        
    
    
    public static void main (String[] args)
    {
        new DeleteLibrarian().setVisible(true);

    }
}
