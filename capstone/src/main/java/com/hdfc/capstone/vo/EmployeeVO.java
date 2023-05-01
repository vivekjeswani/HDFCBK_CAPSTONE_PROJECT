package com.hdfc.capstone.vo;
import java.sql.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.time.LocalDate;
import com.hdfc.capstone.utils.EncryptionUtil;

public class EmployeeVO {
	
	private String employeeId;
	private String employeeName;
	private String dateOfBirth;
	


	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
//		this.dateOfBirth = EncryptionUtil.encrypt(dateOfBirth.toString());
		this.dateOfBirth=dateOfBirth;
	}
	
	public EmployeeVO getEmployeeById(long employeeId) {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		long id=employeeId;
        String name;
       
       EmployeeVO obj= new EmployeeVO();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?user=root&password=Jinglebell@14");
			pst = con.prepareStatement("select * from employee where employee_id=?;");
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				name = rs.getString("employee_name");
				
				
				obj.setEmployeeId(String.valueOf(employeeId));
				obj.setEmployeeName(name);
				obj.setDateOfBirth(encrypt(employeeId));

				
			}
			
		} 
		
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		return obj;
	}
	
	
	
	public String encrypt(long id){

	        
	        String url = "jdbc:mysql://localhost:3306/employee_db";
	        String user = "root";
	        String password = "Jinglebell@14";

	        
	        try {
	            // Define encryption key and initialization vector
	            byte[] keyBytes = "mysecretpassword".getBytes();
	            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
	            byte[] ivBytes = "1234567890123456".getBytes();
	            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
	            
	            // Initialize AES cipher in CBC mode with PKCS5 padding
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
	            
	            // Retrieve the date value from the database
	            Connection conn = DriverManager.getConnection(url, user, password);
	            PreparedStatement stmt = conn.prepareStatement("SELECT date_of_birth FROM employee where employee_id =?;");
	             stmt .setLong(1, id);
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                // Get the date value as a string in the format of "dd-MM-yyyy"
	                String dateString = rs.getString("date_of_birth");
	                
	                // Convert the date string to bytes and encrypt using AES
	                byte[] dateBytes = dateString.getBytes();
	                byte[] encryptedBytes = cipher.doFinal(dateBytes);
	                
	                // Display the encrypted date value
	                System.out.println("Encrypted date value: " + new String(encryptedBytes));
	                return new String(encryptedBytes);

	            }


	            
	            conn.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "str";
	       
	    }
	

}