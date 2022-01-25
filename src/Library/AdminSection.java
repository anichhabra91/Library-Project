package Library;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import java.sql.*;


public class AdminSection extends JFrame implements ActionListener{
    
    //JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f1,f2;


    AdminSection(){

        super("Admin Page");
        setLocation(500,350);
        setSize(600,400);

        f1=new Font("Arial",Font.BOLD,25);
        f2=new Font("Arial",Font.BOLD,20);

        JMenuBar m1=new JMenuBar();
        JMenu menu1= new JMenu("Add Info");
        JMenuItem item1= new JMenuItem("Add Librarian");

        JMenu menu2= new JMenu("View Info");
        JMenuItem item2= new JMenuItem("View Librarian");

        JMenu menu3= new JMenu("Delete Info");
        JMenuItem item3= new JMenuItem("Delete Librarian");

        JMenu menu4= new JMenu("Exit ");
        JMenuItem item4= new JMenuItem("Logout");

        menu1.add(item1);
        menu2.add(item2);
        menu3.add(item3);
        menu4.add(item4);

        m1.add(menu1);
        m1.add(menu2);
        m1.add(menu3);
        m1.add(menu4);

        menu1.setFont(f1);
        menu2.setFont(f1);
        menu3.setFont(f1);
        menu4.setFont(f1);

        item1.setFont(f2);
        item2.setFont(f2);
        item3.setFont(f2);
        item4.setFont(f2);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);

        setJMenuBar(m1);
        //add(l1);
    }

        public void actionPerformed (ActionEvent e){

            String cmnd=e.getActionCommand();

            if(cmnd.equals("Add Librarian"))
            {
                new AddLibrarian().setVisible(true);

            }

            else if(cmnd.equals("View Librarian"))
            {
                new ViewLibrarian().setVisible(true);

            }

            else if(cmnd.equals("Delete Librarian"))
            {
                new DeleteLibrarian().setVisible(true);

            }

            else if(cmnd.equals("Logout"))
            {
                System.exit(0);

            }
        





    }

    public static void main (String[] args) {
        
        new AdminSection().setVisible(true);



    }
}
