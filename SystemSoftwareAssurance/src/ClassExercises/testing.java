
public class testing {
	
	public static void main(String[] args) {
		
		int[] a = new int[10];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		
		for(int i : a) {
			System.out.print(i + "\t");
			
		}
		System.out.println();
		clear(a);
		for(int i: a) {
			System.out.print(i + "\t");
		}
		
	}
	public static void clear(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

}
