package Library;

import java.awt.event.*;
//import java.util.concurrent.Flow.Publisher;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f1,f2;
    JTextField tf1,tf2;

    ReturnBook()
    {
        super("Return Book");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Return Books");
        l2=new JLabel("Book No");
        l3=new JLabel("StudentId");

        tf1= new JTextField();
        tf2= new JTextField();

        bt1=new JButton("Return Book");
        bt2=new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);

        tf1.setFont(f2);
        tf2.setFont(f2);

        bt1.setFont(f2);
        bt2.setFont(f2);

        p1=new JPanel();

        p1.setLayout(new GridLayout(1,1,10,10));

        p1.add(l1);
        p1.setBackground(Color.cyan);

        p2=new JPanel();

        p2.setLayout(new GridLayout(3,2,10,10));     //10 is gap between two fields

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

        String bookno=tf1.getText();
        int stuid=Integer.parseInt(tf2.getText());

        if(e.getSource()==bt1)
        {
            try{
                ConnectionClass obj=new ConnectionClass();
                String q="delete from issuebook where book_no='"+bookno+"' and studentid='"+stuid+"'";
                int res=obj.stm.executeUpdate(q);
                if(res==0)
                {
                    JOptionPane.showMessageDialog(null,"Error");
                    this.setVisible(false);
                }
                else{
                    String q3="update books set issuebook= issuebook-1 where bookno='"+bookno+"'";
                    String q4="update books set quantity= quantity+1 where bookno='"+bookno+"'";

                
                int aaa=obj.stm.executeUpdate(q3);
                int aaaa=obj.stm.executeUpdate(q4); 
                
                if(aaa==1)
                    {
                        if(aaaa==1)
                        {
                            JOptionPane.showMessageDialog(null,"Succesfully Returned");
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

            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
    {
        JOptionPane.showMessageDialog(null, "Sure?1");
        this.setVisible(false);
    }
}

public static void main(String[] args)
    {
        new ReturnBook().setVisible(true);
    }

}
