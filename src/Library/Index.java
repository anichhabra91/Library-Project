package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Index extends JFrame implements ActionListener {

    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    Font f1,f2;
    

    Index(){
        super("Login Page");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Admin Login");
        l2=new JLabel("Librarian Login");
        l3=new JLabel("Library Management System");

        bt1= new JButton("Login");
        bt2= new JButton("Login");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f1);
        bt1.setFont(f2);
        bt2.setFont(f2);

        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setBackground(Color.CYAN);

        p1= new JPanel();
        p1.setLayout(new GridLayout(2,2,10,10));
        p1.add(l1);
        p1.add(l2);
        p1.add(bt1);
        p1.add(bt2);

        p2= new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));

        p2.add(l3);

        setLayout(new BorderLayout(10,10));
        add(p2,"North");
        add(p1,"Center");
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource()==bt1){
            new Admin().setVisible(true);
            this.setVisible(false);
        }

        if(e.getSource()==bt2){
            new Librarian().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Index().setVisible(true);
    }

}
