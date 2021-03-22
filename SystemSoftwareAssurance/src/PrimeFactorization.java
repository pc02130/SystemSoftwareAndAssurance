import java.util.ArrayList;

public class PrimeFactorization {
	
	
	public static void main(String[] args) {
		
		if (args.length > 0) {		
			try {
				int x = Integer.parseInt(args[0]);
				ArrayList<Integer> facts = factorization(x);
				if (product(facts) != x) {
					System.out.println("Something went wrong.");
					System.exit(0);
				}
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
			}
		}
		else {
			System.out.println("Enter an integer.");
			System.exit(0);
		}
		
	}
	public static boolean isPrime(int num) {
		if (num > 2 && num % 2 == 0) {
			return false;
		}
		for (int i = 3; i < Math.ceil(num/2); i+=2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	public static int product(ArrayList<Integer> facts) {
		int prod = 1;
		for(int i : facts) {
			prod *= i;
			
		}
		return prod;
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
