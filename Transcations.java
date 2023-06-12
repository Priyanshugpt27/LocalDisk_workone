package bankmanagement;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transcations extends JFrame implements ActionListener {

	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
	String pinnumber;
	Transcations( String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATMone.jpg"));
		Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transcations" );
		text.setBounds(275,425, 700, 35);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.red);
		image.add(text);
		
		deposit= new JButton("Deposit");
		deposit.setBounds(270,500,120,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl= new JButton("Cash Withdraw");
		withdrawl.setBounds(270,535,120,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash= new JButton("Fast Cash");
		fastcash.setBounds(270,570,120,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement= new JButton("Mini Statement");
		ministatement.setBounds(400,500,120,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange= new JButton("Pin Change");
		pinchange.setBounds(400,535,120,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance= new JButton("Balance Requiry");
		balance.setBounds(400,570,120,30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit= new JButton("Exit");
		exit.setBounds(400,605,120,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	     if(ae.getSource()==exit) {
	    	 System.exit(0);
	     }else if(ae.getSource() == deposit) {
	    	 setVisible(false);
	    	 new Doposit(pinnumber).setVisible(true);
	     }else if(ae.getSource()== withdrawl) {
	    	 setVisible(false);
	    	 new withdrawl(pinnumber).setVisible(true);
	     }else if(ae.getSource()== fastcash) {
	    	 setVisible(false);
	    	 new Fastcash(pinnumber).setVisible(true);
	     }else if(ae.getSource() ==pinchange) {
	    	 setVisible(false);
	    	 new Pinchange(pinnumber).setVisible(true);
	     }else if (ae.getSource() == balance) {
	    	 setVisible(false);
	    	 new BalenceReq(pinnumber).setVisible(true);
	     }else if (ae.getSource() == ministatement) {
	    	 new Ministatement(pinnumber).setVisible(true);
	     }
	}
	
	
	
	public static void main(String[] args) {
          new Transcations("");
	}

}
