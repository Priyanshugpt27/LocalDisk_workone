package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdrawl,back;
	String pinnumber;
   
	withdrawl(String pinnumber){
		 this.pinnumber = pinnumber;
		 
		setLayout(null);

	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATMone.jpg"));
	Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
	ImageIcon i3 =new ImageIcon(i2); 
	JLabel image = new JLabel(i3);
	image.setBounds(0,0,900,900);
	add(image);
	
	JLabel text = new JLabel("Enter the amount you want to withdrawl");
	text.setForeground(Color.red);
	text.setFont(new Font("System",Font.BOLD,15));
	text.setBounds(270, 435, 700, 15);
	image.add(text);
	
	amount = new JTextField();
	amount.setFont(new Font("Raleway", Font.BOLD,22));
	amount.setBounds(270,450,245,30);
	image.add(amount);
	
	withdrawl  = new JButton("Withdraw");
	withdrawl.setBounds(400,550,120,30);
	withdrawl.addActionListener(this);
	image.add(withdrawl);
	
	back  = new JButton("Back");
	back.setBounds(400,585,120,30);
	back.addActionListener(this);
	image.add(back);
	
	
	setSize(900, 900);
	setLocation (300,0);
	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdrawl) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposite");
			} else  {
				try {
				
				Conn conn = new Conn();
				String query = "insert into bank values('"+pinnumber+"', '"+date+"','withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +number+" Withdrawl Successfully");
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
				}catch (Exception e) {
					System.out.println(e);
				}
			   
			}
		}else if(ae.getSource() == back ) {
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new withdrawl("");
		
	}
	
}	