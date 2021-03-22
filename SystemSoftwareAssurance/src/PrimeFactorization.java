import java.util.ArrayList;

public class PrimeFactorization {
	
/* 
	Takes an integer as command line argument and prints the prime 
	factorization for the given integer
*/
	public static void main(String[] args) {
		if (args.length > 0) {		
			try {
				int x = Integer.parseInt(args[0]);
				ArrayList<Integer> facts = factorization(x);
				System.out.print(x + "=");
				for(int i = 0; i < facts.size(); i++) {
					if (i + 1 == facts.size()) {
						System.out.print(facts.get(i));
					}
					else {
						System.out.print(facts.get(i) + "*");
					}
				}
			}
			catch(Exception e) {
				System.out.println("Input " + args[0] + " is not a valid decimal integer");
				System.exit(0);
			}
		}
		else {
			System.out.println("Enter an integer.");
			System.exit(0);
		}	
	}
	public static ArrayList<Integer> factorization(int num) {
		ArrayList<Integer> facts = new ArrayList<Integer>();
		for(int i = 2; i <= num; i++) {
			while (num % i == 0) {
				facts.add(i);
				num /= i; 
			}
		}
		return facts;
	}

}
