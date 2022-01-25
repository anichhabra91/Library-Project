package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;

public class AddLibrarian extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf3,tf4,tf5,tf6;
    JPasswordField tf2;
    Font f1,f2;

    AddLibrarian(){
        super("Add Librarian");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Admin Librarian");
        l2=new JLabel("Name");
        l3=new JLabel("Password");
        l4=new JLabel("EMail");   
        l5=new JLabel("Contact");
        l6=new JLabel("Adress");
        l7=new JLabel("City");

        tf1= new JTextField();
        tf2= new JPasswordField();
        tf3= new JTextField();
        tf4= new JTextField();
        tf5= new JTextField();
        tf6= new JTextField();

        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);

        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);

        bt1=new JButton("Add Librarian");
        bt2=new JButton("Cancel");

        bt1.setFont(f2);
        bt2.setFont(f2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        p1=new JPanel();

        p1.setLayout(new GridLayout(1,1,0,0));

        p1.add(l1);
        p1.setBackground(Color.cyan);

        p2=new JPanel();

        p2.setLayout(new GridLayout(7,2,10,10));     //10 is gap between two fields

        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l7);
        p2.add(tf6);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

        



    
    }
    public void actionPerformed (ActionEvent e){

        String name=tf1.getText();
        String password=String.valueOf(tf2.getPassword());
        String email=tf3.getText();
        String contact=tf4.getText();
        String address=tf5.getText();
        String city=tf6.getText();

        if(e.getSource()==bt1)
        {   
            try{

                ConnectionClass obj=new ConnectionClass();
                String q="INSERT INTO librarians(name,password,EMAIL,CONTACT,ADDRESS,CITY) VALUES ('" +name+ "','" + password + "','"+email+"','"+contact+"','"+address+"','"+city+"')";

                int aa=obj.stm.executeUpdate(q);

                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Succesful");
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not Succesful");
                    this.setVisible(true);
                }
            }


            catch(Exception ee)
            {
                ee.printStackTrace();
            }

        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }

    }

    public static void main (String[] args){
        new AddLibrarian().setVisible(true);

    }
}
