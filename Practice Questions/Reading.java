import java.util.*;

public class Reading {

	// method operation: add, multiply or subtract
	public static int operate (String op, int operand1, int operand2) {
		if (op.equals("ADD")) {
			return operand1 + operand2;
		} else if (op.equals("MUL")) {
			return operand1 * operand2;
		} else if (op.equals("SUB")) {
			return operand1 - operand2;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int operand1, operand2;

		Scanner sc = new Scanner(System.in);
		//first input
		String input = sc.next();

		if (input.equals("LIMIT")) {
			int numberOps;

			numberOps = sc.nextInt();

			if (numberOps == 0) {
				;	
			} else {
				for (int i = 0; i < numberOps; i++) {
					String op = sc.next();
					operand1 = sc.nextInt();
					operand2 = sc.nextInt();

					System.out.println(operate(op, operand1, operand2));
				}
			}
		} else if (input.equals("SENTINEL")) {
			
			while (true) {
				String op = sc.next();
				if (op.equals("-1")) {
					break;
				} else {
				operand1 = sc.nextInt();
				operand2 = sc.nextInt();

				System.out.println(operate(op, operand1, operand2));
				}
			}
		} else if (input.equals("EOF")) {
			while (sc.hasNext()) {
				String op = sc.next();
				operand1 = sc.nextInt();
				operand2 = sc.nextInt();

				System.out.println(operate(op, operand1, operand2));
			}
		}
	}
}
