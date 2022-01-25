package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;

public class LibrarianSection extends JFrame implements ActionListener{

    JButton bt1;
    JPanel p1,p2;
    Font f1,f2;

    LibrarianSection(){

        super("LibrarianPage");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        JMenuBar m1=new JMenuBar();
        JMenu menu1= new JMenu("Add Info");
        JMenuItem item1= new JMenuItem("Add Book");
        

        JMenu menu2= new JMenu("View Info");
        JMenuItem item2= new JMenuItem("View Book");
        JMenuItem item6= new JMenuItem("View Issue Book");

        JMenu menu3= new JMenu("Issue Info");
        JMenuItem item3= new JMenuItem("Issue Book");

        JMenu menu4= new JMenu("Return ");
        JMenuItem item4= new JMenuItem("Return Book");

        JMenu menu5= new JMenu("Exit ");
        JMenuItem item5= new JMenuItem("Logout");

        menu1.add(item1);
        menu2.add(item2);
        menu2.add(item6);
        menu3.add(item3);
        menu4.add(item4);
        menu5.add(item5);

        m1.add(menu1);
        m1.add(menu2);
        m1.add(menu3);
        m1.add(menu4);
        m1.add(menu5);

        menu1.setFont(f1);
        menu2.setFont(f1);
        menu3.setFont(f1);
        menu4.setFont(f1);
        menu5.setFont(f1);

        item1.setFont(f2);
        item2.setFont(f2);
        item3.setFont(f2);
        item4.setFont(f2);
        item5.setFont(f2);
        item6.setFont(f2);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);

        setJMenuBar(m1);
        //add(l1);
    }

    public void actionPerformed (ActionEvent e){

        String cmnd=e.getActionCommand();

        if(cmnd.equals("Add Book"))
        {
            new AddBook().setVisible(true);

        }

        else if(cmnd.equals("View Book"))
        {
            new ViewBook().setVisible(true);

        }

        else if(cmnd.equals("View Issue Book"))
        {
            new IssueBook().setVisible(true);

        }
        else if(cmnd.equals("Issue Book"))
        {
            new IssueBook().setVisible(true);

        }
        else if(cmnd.equals("Return Book"))
        {
            new ReturnBook().setVisible(true);

        }
        
        else if(cmnd.equals("Logout"))
        {
            System.exit(0);

        }
    }

    public static void main (String[] args) {
        
        new LibrarianSection().setVisible(true);



    }

    
}
