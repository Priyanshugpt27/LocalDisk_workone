package bankmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SingupTwo extends JFrame implements ActionListener {

	
	JTextField Aadhar,pan;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion,category,income,education,occupation;
    String formno;
	
	SingupTwo(String formno) {
		this.formno= formno;
		setLayout(null);

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
	
		JLabel additionalDetalis = new JLabel("Page 2 Additional Detalis");
		additionalDetalis.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetalis.setBounds(290, 80, 400, 30);
		add(additionalDetalis);

		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valReligion[]= {"Hindu","Muslim","Sikh","Christias","other"};
		this.religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		String valcategory[]= {"Gerenal","OBC","SC","ST","Other"};
	    category = new JComboBox(valcategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.white);
		add(category);

		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		String incomecategory[]= {"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
		income = new JComboBox(incomecategory);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.white);
		add(income);
		
		
		JLabel gender = new JLabel("Educational:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		String educationvalues[]= {"Non-Graduation","Graduation","Post-Gradution","Doctor","Other"};
		education = new JComboBox(educationvalues);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.white);
		add(education);
	
	
		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		String occupationvalues[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
		occupation = new JComboBox(occupationvalues);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.white);
		add(occupation);
	
		
		JLabel address = new JLabel("PAN Number:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);

		JLabel city = new JLabel("Aadhar Number:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		Aadhar = new JTextField();
		Aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		Aadhar.setBounds(300, 490, 400, 30);
		add(Aadhar);

		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		ButtonGroup mariralgroup = new ButtonGroup();
		mariralgroup.add(syes);
		mariralgroup.add(sno);
		
		JLabel pincode = new JLabel("Exisiting Account:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		ButtonGroup emariralgroup = new ButtonGroup();
		emariralgroup.add(eyes);
		emariralgroup.add(eno);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);

	}

	   public void actionPerformed(ActionEvent ae) {
         String sreligion = (String)religion.getSelectedItem();   
         String scategory = (String)category.getSelectedItem();   
         String sincome = (String)income.getSelectedItem();
         String seducation = (String)education.getSelectedItem();
         String soccupation = (String)occupation.getSelectedItem();
         String seniorcitizen = null;
         if(syes.isSelected()) {
        	 seniorcitizen = "Yes";
         }else if(sno.isSelected()) {
        	 seniorcitizen = "No";
	     }
	
	     String exisitingaccount = null;
	     if(eyes.isSelected()) {
	    	 exisitingaccount = "Yes";
	     }else if(eno.isSelected()) {
	    	 exisitingaccount = "No";
	     }
	     String span = pan.getText();
	     String saadhar = Aadhar.getText();
	     
	     try {
	    	 	 Conn c = new Conn();
	    		 String query3 = "insert into signuptwo values('"+ formno+"','"+ sreligion+"' ,'"+ scategory+"','"+ sincome+"','"+ seducation+"','"+soccupation+"','"+ span+"','"+ saadhar+"','"+ seniorcitizen+"','"+ exisitingaccount+"')";
	             c.s.executeUpdate(query3);
	       
	       //Signup Object
	             setVisible (false);
	             new SingupThree(formno).setVisible(true);
	    	 
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }
}     
	
	
	public static void main(String[] args) {
		new SingupTwo("");
	}

}
