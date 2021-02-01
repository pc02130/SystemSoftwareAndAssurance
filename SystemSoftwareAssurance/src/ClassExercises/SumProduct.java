package ClassExercises;
import java.util.Scanner;

public class SumProduct {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		long a = sc.nextInt();
		System.out.println("Enter second number: ");
		long b = sc.nextInt();
		
		System.out.printf("Sum: %d, Product: %d", (a+b), (a*b));
		
	}
}
