import java.util.*;

public class Vaccination {

	public static void main(String[] args) {
		String name;                 //name of children
		int age, totalAge = 0;		
		boolean vaccinated;
		int numVaccinated = 0; 
		int numChildren;
		double averageAge;
		double percentageVaccinated;

		Scanner sc = new Scanner(System.in);
		
		//Asks for input for number of children
		System.out.print("Number of children: ");
		numChildren = sc.nextInt();

		//Prints the number of children
		System.out.println("Number of children is " + numChildren);

		for (int i = 0; i < numChildren; i++) {
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.printf("Name is \"%s\"\n", name);
			
			System.out.print("Age: ");
			age = sc.nextInt();
			System.out.printf("Age is %d\n", age);
			totalAge += age;

			System.out.print("Vaccinated for chickenpox? ");
			vaccinated = sc.nextBoolean();
			if (vaccinated) {
				System.out.println("Vaccinated for chickenpox");
				numVaccinated += 1;
			} else {
				System.out.println("Not vaccinated for chickenpox");
			}
		}
		
		averageAge = ((double)(totalAge) / (double)(numChildren));
		System.out.printf("Average age is %.2f\n", averageAge);

		percentageVaccinated = ((double)(numVaccinated) /
								(double)(numChildren) *
								100.0);
		System.out.printf("Percentage of children vaccinated is %.2f%%\n",
						  percentageVaccinated);
	}
}



