package bankmanagement;
 import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalenceReq extends JFrame implements ActionListener {
	
	JButton back;
	String pinnumber;
	
	BalenceReq(String pinchange){
		this.pinnumber= pinchange;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATMone.jpg"));
		Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2); 
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(390,585,120,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
             ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
             while(rs.next()) {
            	 if(rs.getString("type").equals("Deposite"))
            	 {
            	 balance += Integer.parseInt(rs.getString("amount"));
             }else {
            	 balance -= Integer.parseInt(rs.getString("amount"));
             }
		}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current Account balance is Rs. " + balance);
		text.setForeground(Color.red);
		text.setBounds(280,450, 400, 30);
		image.add(text);
		
		setSize(900, 900);
		setLocation (300,0);
		setUndecorated(true);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new BalenceReq("");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		 new Transcations(pinnumber).setVisible(true);
	}

}
