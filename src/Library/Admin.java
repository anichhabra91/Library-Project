package Library;


import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;

public class Admin extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f1,f2;
    JTextField tf1;
    JPasswordField tf2;
    
    
    Admin()
    {
        super("Admin Login Page");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);


        l1=new JLabel("Admin Login");
        l2=new JLabel("Name");
        l3=new JLabel("Password");

        bt1= new JButton("Login");
        bt2= new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        tf1= new JTextField();
        tf2= new JPasswordField();

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        bt1.setFont(f2);
        bt2.setFont(f2);
        tf1.setFont(f2);
        tf2.setFont(f2);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBackground(Color.CYAN);

        p1= new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.cyan);
        
        p2= new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");


    }

    public void actionPerformed (ActionEvent e){

        String name=tf1.getText();
        String pass=String.valueOf(tf2.getPassword());

        if(e.getSource()==bt1){
            
            try{
                ConnectionClass obj= new ConnectionClass();
                String s=("SELECT * FROM Admin WHERE USERNAME='" + name + "' AND PASSWORD='" + pass + "'"); 

                ResultSet rest=obj.stm.executeQuery(s);

                if(rest.next())
                {
                    new AdminSection().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your Name and Password dont match");
                    this.setVisible(false);
                    this.setVisible(true);

                }
            }

            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }

        if(e.getSource()==bt2){
            new Librarian().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Admin().setVisible(true);
    }
}

