package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pinchange extends JFrame implements ActionListener {

	JPasswordField pin, rpin;
	JButton change, back;
	String pinnumber;

	Pinchange(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ATMone.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(300, 425, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.red);
		image.add(text);

		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(280, 450, 700, 35);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setForeground(Color.white);
		image.add(pintext);

		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 15));
		pin.setBounds(360, 455, 150, 20);
		image.add(pin);

		JLabel repintext = new JLabel("Re- Enter New PIN:");
		repintext.setBounds(280, 480, 700, 25);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setForeground(Color.white);
		image.add(repintext);

		rpin = new JPasswordField();
		rpin.setFont(new Font("Raleway", Font.BOLD, 15));
		rpin.setBounds(425, 480, 100, 20);
		image.add(rpin);

		change = new JButton("CHANGE");
		change.setBounds(400, 550, 120, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(400, 585, 120, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {

			try {
				String npin = pin.getText();
				String repin = rpin.getText();

				if (!npin.equals(repin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				if (repin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
					return;
				}
				Conn conn = new Conn();
				String query1 = "update bank set pin = '" + repin + "' where pin = '" + pinnumber + "'";
				String query2 = "update login set pin = '" + repin + "' where pin = '" + pinnumber + "'";
				String query3 = "update signupthree set pin = '" + repin + "' where pin = '" + pinnumber + "'";

				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);

				JOptionPane.showMessageDialog(null, " PIN changed successfully");

				setVisible(false);
				new Transcations(repin).setVisible(true);

			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Pinchange("").setVisible(true);
	}
}
