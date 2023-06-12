package bankmanagement;
  
   import java.sql.*;
  
public class Conn {

	
     Connection c;	
     Statement s;
     public Conn() {
    	 try {
    		 
    		 c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","manager");
    		 s=c.createStatement();
    		 
    	 }catch(Exception e) {
    		 System.out.println(e);
    	 }
     }
}
