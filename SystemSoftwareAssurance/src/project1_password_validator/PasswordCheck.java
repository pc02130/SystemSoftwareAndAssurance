package project1_password_validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordCheck {
	
	public String run(String password, String reentry) {	
		
			if (password.length() == 0 || reentry.length() == 0) {
				return "Please enter a password in the text fields";
			}StringBuilder str = new StringBuilder();
			if (!verify_length(password)) 
				str.append("*Password needs to be between 8-30 characters.\n");
			if (!check_case(password))  
				str.append("*\tPassword needs at least one Uppercase and one Lowercase character.\n");
			if (!number_check(password)) 
				str.append("*\tPassword needs at least one numerical value.\n");
			if (!verify_special(password)) 
				str.append("*\tPassword needs a special characer ('!', '#', '$', '%', '&', '(', ')',"
									+ " '[', ']', '{', '}', '+', '-','=', '~','_', '@')\n");
			if (!compare_to_list(password) && str.length() == 0) {
				if (reentry.equals(password)) {
					str.append("Password Confirmed.");
				}
				else {
					return "Passwords do not match.";
				}
			}
			return str.toString();
		}
	
	
	private static boolean verify_length(String password) {
		return (8 <= password.length() && password.length() <= 30);
	}

	private static boolean check_case(String password) {
		boolean upper = false;
		boolean lower = false;
		for (int i = 0; i < password.length(); i++) {
			int ch = password.charAt(i);
			if (upper && lower) break;
			
			else if (ch >= 'A' && ch <= 'Z') {
				upper = true;
				continue;
			}
			else if (ch >= 'a' && ch <= 'z') {
				lower = true;
				continue;
			}
		}
		return upper && lower;
	}
	private static boolean number_check(String password) {
		boolean num = false;
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				num = true;
				break;
			}
			
		}
		
		return num;
	}
	
	private static boolean verify_special(String password) {
		boolean special = false;
		char[] special_values = {'!', '#', '$', '%', '&', '(', ')', '[', ']', '{', '}', '+', '-','=', '~','_', '@'};
		for (int i = 0; i < special_values.length; i++) {
			if (password.indexOf(special_values[i]) >= 0){
				special = true;
				break;
			}
		}
		
		return special;
	}
		
	private static String[] get_passwords() {
		String[] uncommon_passwords = new String[3000];
		
		// Might need to change file location if not working
		File file = new File("SystemSoftwareAssurance\\src\\project1_password_validator\\uncommon_passwords.txt");
		int i = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				String data = input.nextLine();
				uncommon_passwords[i] = data;
				i++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return uncommon_passwords;
		
	}
	
	private static boolean compare_to_list(String password) {
		boolean contains = false;
		String[] uncommon_passwords = get_passwords();
		for (String s : uncommon_passwords) {
			if (password.contains(s)) {
				contains = true;
//				System.out.printf("Invalid, '%s' contains common password '%s'", password, s);
				break;
			}
		}
		return contains;
	}
}
	
	


