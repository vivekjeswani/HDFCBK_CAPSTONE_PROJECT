package com.hdfc.capstone.client.vo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

public class EmployeeVO {
	
	private int employeeId;
	private String employeeName;
	private String dateOfBirth;
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
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
		this.dateOfBirth = dateOfBirth;
	}

	public EmployeeVO(int employeeId, String employeeName, String dateOfBirth) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public EmployeeVO() {
		super();
	}

	private static final String ALGORITHM = "AES";
    private static final String KEY = "09876543210987654321098765432109";

	public static String decrypt(String encryptedData) throws Exception {
	    Cipher cipher = Cipher.getInstance(ALGORITHM);
	    SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
	    cipher.init(Cipher.DECRYPT_MODE, key);
	    byte[] decrypted = cipher.doFinal(Base64Utils.decodeFromString(encryptedData));
	    return new String(decrypted);
	}
}