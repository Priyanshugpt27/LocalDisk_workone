package bankmanagement;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

	JButton a1,a2,a3,a4,a5,a6, exit;
	String pinnumber;

	Fastcash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATMone.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("SELECT WITHDRAL AMOUNT");
		text.setBounds(275,425, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.white);
		image.add(text);

		a1 = new JButton("Rs 100");
		a1.setBounds(270,500,120,30);
		a1.addActionListener(this);
		image.add(a1);

		a2 = new JButton("Rs 500");
		a2.setBounds(270,535,120,30);
		a2.addActionListener(this);
		image.add(a2);

		a3 = new JButton("Rs 1000");
		a3.setBounds(270, 570, 120, 30);
		a3.addActionListener(this);
		image.add(a3);

		a4 = new JButton("Rs 2000");
		a4.setBounds(400,500,120,30);
		a4.addActionListener(this);
		image.add(a4);

		a5 = new JButton("Rs 5000");
		a5.setBounds(400, 535, 120, 30);
		a5.addActionListener(this);
		image.add(a5);

		a6= new JButton("Rs 10000");
		a6.setBounds(400, 570, 120, 30);
		a6.addActionListener(this);
		image.add(a6);

		exit = new JButton("Back");
		exit.setBounds(400, 605, 120, 30);
		exit.addActionListener(this);
		image.add(exit);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton) ae.getSource()).getText().substring(3); //
			Conn c = new Conn();
			try {
                 ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()) {
                	 if(rs.getString("type").equals("Deposit"))
                	 {
                	 balance += Integer.parseInt(rs.getString("amount"));
                 }else {
                	 balance -= Integer.parseInt(rs.getString("amount"));
                 }
			}
                 if(ae.getSource() != exit && balance <Integer.parseInt(amount))
                 {
                	 JOptionPane.showMessageDialog(null, "Insufficient Balance");
                	 return;
                 }
                 Date date = new Date();
                 String query = "insert into bank values('"+pinnumber+"','"+date+"', 'withdrawl' ,'"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs" + amount+ " Debital Succefull");
                 
                 setVisible(false);
                 new Transcations(pinnumber).setVisible(true);
                 
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public static void main(String[] args) {
		new Fastcash("");
	}

}	