package com.netcracker.libra.util.security;

import java.util.Random;

public class ConfirmationCodeGenerator {
	
	private final static String alps = "ABCDEFHIJKLMNOPQRSTUVWXYZ1234567890";
	

	public static String generateCode() {
		
		Random rdm = new Random();
		StringBuilder code = new StringBuilder();
		int rNo;
		
		for (int i=0; i < 6; i++) {
			rNo = rdm.nextInt(alps.length());
				code.append(alps.charAt(rNo));
			}
		System.out.println("Code is " + code);
		return code.toString();
	}
}
