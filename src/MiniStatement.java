import java.awt.Window.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Window.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.JFrame;
public class MiniStatement extends JFrame implements ActionListener {

    JTable t1;
    JButton b1;
    String x[] = {"Customer Name","Date","Deposit","Withdraw","Balance"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    
    MiniStatement(){
        super("Mini Statement");
        setSize(1200,650);
        setLocation(200,200);
     		 String pinn = JOptionPane.showInputDialog("Enter PIN");

        
        try{
            Connect c1  = new Connect();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pinn + "'");
          //  String s1 = "select * from bank";
          //  ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("customer_name");
                y[i][j++]=rs.getString("date");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}