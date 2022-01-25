package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import javax.swing.event.MouseInputAdapter;

//import org.w3c.dom.events.MouseEvent;

import java.sql.*;

public class IssueBook extends JFrame implements ActionListener {

    JLabel l1,l3,l4,l5,l6,l7,l8;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf2,tf3,tf4,tf5,tf6;
    Font f1,f2;
    Choice ch;

    IssueBook()
    {
        super("Issue Book");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Issue Books");
        //l2=new JLabel("Book ID");
        l3=new JLabel("Book No");
        l4=new JLabel("Book Name");
        l5=new JLabel("Student ID");   
        l6=new JLabel("Student Name");
        l7=new JLabel("Student Contact");
        l8=new JLabel("Book Quantity");

        //tf1= new JTextField();
        tf2= new JTextField();
        tf3= new JTextField();
        tf4= new JTextField();
        tf5= new JTextField();
        tf6= new JTextField();

        bt1=new JButton("Issue Book");
        bt2=new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f2);
        //l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);

        //tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);
        tf6.setEditable(false);
        tf6.setForeground(Color.red);
        tf2.setEditable(false);
        tf2.setForeground(Color.red);
        

        bt1.setFont(f2);
        bt2.setFont(f2);

        ch=new Choice();

        try{
            ConnectionClass obj=new ConnectionClass();
            String q="Select bookno from books";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch.add(rest.getString("bookno"));
            }
        }

        catch(Exception ee)
        {
            ee.printStackTrace();
        }

        ch.setFont(f2); 
        
        p1=new JPanel();

        p1.setLayout(new GridLayout(1,1,0,0));

        p1.add(l1);
        p1.setBackground(Color.cyan);

        p2=new JPanel();

        p2.setLayout(new GridLayout(7,2,10,10));     //10 is gap between two fields

        //p2.add(l2);
        p2.add(l3);
        p2.add(ch);
        //p2.add(l3);
        //p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

        ch.addMouseListener(new MouseAdapter() {
           
           //public void mouseClicked (MouseEvent arg0)
           {
               try{
                   ConnectionClass obj2=new ConnectionClass();
                   String bookno=ch.getSelectedItem();
                   String q1="Select * from books where bookno='"+bookno+"'";
                   ResultSet rest1=obj2.stm.executeQuery(q1);
                   while(rest1.next())
                   {
                       //tf1.setText(rest1.getString("bookno"));
                       tf2.setText(rest1.getString("bookname"));
                       tf6.setText(rest1.getString("quantity"));
                   }

               }

               catch(Exception exx)
            {
                exx.printStackTrace();
            }


           } 
        });

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int qnt=0;
            String bookno=ch.getSelectedItem();
           // String bookno=tf1.getText();
            String bookname=tf2.getText();
            int stuid=Integer.parseInt(tf3.getText());
            String stuname=tf4.getText();
            String stucont=tf5.getText();
            String date=new java.util.Date().toString();
            try{
                ConnectionClass obj3=new ConnectionClass();
                String q2="Select quantity from books where bookno='"+bookno+"'";
                ResultSet rest3=obj3.stm.executeQuery(q2);

                while(rest3.next())
                {
                    qnt=Integer.parseInt(rest3.getString("quantity"));
            }
            if(qnt<=0)
            {
                JOptionPane.showMessageDialog(null,"No Books Available");
                this.setVisible(false);
            }

            else{
                String q7="insert into issuebook(book_no,bookname,studentid,studentname,studentcontact,date) values ('" +bookno+ "','" + bookname + "','"+stuid+"','"+stuname+"','"+stucont+"','"+date+"')";
                String q3="update books set issuebook= issuebook+1 where bookno='"+bookno+"'";
                String q4="update books set quantity= quantity-1 where bookno='"+bookno+"'";

                int aa=obj3.stm.executeUpdate(q7);
                int aaa=obj3.stm.executeUpdate(q3);
                int aaaa=obj3.stm.executeUpdate(q4); 
                
                if(aa==1)
                {
                    if(aaa==1)
                    {
                        if(aaaa==1)
                        {
                            JOptionPane.showMessageDialog(null,"Succesfully Issued");
                            this.setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Incorrect Data");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Data");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Data");
                }


                

            }

            
        }
        catch(Exception ee)
            {
                ee.printStackTrace();
            }
    }
    if(e.getSource()==bt2)
    {
        JOptionPane.showMessageDialog(null, "Sure?!");
        this.setVisible(false);
    }
    


    }
    
    public static void main(String[] args)
    {
        new IssueBook().setVisible(true);
    }
}
