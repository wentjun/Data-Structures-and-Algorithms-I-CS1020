
import java.util.*;

public class SumIntegers {

	public static void main(String[] args) {
		int n; //upper limit, a positive integer
		int count = 1, ans = 0; //initialisation

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter n: ");
		n = sc.nextInt();

		while (count <= n) {
			ans += count;
			count++;
		}

		System.out.println("Sum = " + ans);				
	}
}
