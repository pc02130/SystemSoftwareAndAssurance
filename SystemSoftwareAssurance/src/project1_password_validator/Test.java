package project1_password_validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		test();


	}
	public static void test() throws IOException {
		File f = new File("SystemSoftwareAssurance\\src\\project1_password_validator\\uncommon_passwords.txt");
		Scanner sc = new Scanner(f);
		String[] passwords = new String[3000];
		int i = 0;
		while (sc.hasNext()) {
			passwords[i] = sc.nextLine();
			i++;
		}
		PasswordCheck pc = new PasswordCheck();
		int count = 0;
		for (int j = 0; j < passwords.length; j++) {
			String res = pc.run(passwords[j], passwords[j]);
			
			if (!res.equals("Password Confirmed.")) {
				count++;
				System.out.println(passwords[j] + res + "\n");
			}
		}
		System.out.println(count);
		
	}
	private static void gen_passwords_to_new_file() {
		String[] pass = get_passwords();
		File f = new File("SystemSoftwareAssurance\\src\\project1_password_validator\\new_passwords");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			for(int i = 0; i < pass.length; i++) {
			pass[i] = generate_string() + pass[i] + generate_string();
			System.out.println(pass[i]);
			fw.write(pass[i]+"\n");
			} 
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	private static String[] get_passwords() {
		String[] uncommon_passwords = new String[3000];
		
		File file = new File("SystemSoftwareAssurance\\src\\project1_password_validator\\uncommon_passwords.txt");
		
		int i = 0;
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				String data = input.nextLine();
				System.out.println(data);
				uncommon_passwords[i] = data;
				i++;
			}
			input.close();
		} catch (IOException e) {
			e.getMessage();
		}
		return uncommon_passwords;
		
	}

	public static String generate_string() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    
	    int targetStringLength =  (int) (Math.random() * 10);
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}

}
