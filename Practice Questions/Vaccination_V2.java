import java.util.*;

public class Vaccination_V2 {

	public static void main(String[] args) {
		String name;                 //name of children
		int age, totalAge = 0;		
		boolean vaccinated;
		int numVaccinated = 0; 
		int numChildren = 0;
		double averageAge;
		double percentageVaccinated;

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		while (sc.hasNextLine()) {
		
			name = sc.nextLine();
			System.out.printf("Name is \"%s\"\n", name);
			numChildren += 1;

			System.out.print("Age: ");
			age = sc.nextInt();
			System.out.printf("Age is %d\n", age);
			totalAge += age;

			System.out.print("Vaccinated for chickenpox? ");
			vaccinated = sc.nextBoolean();
			sc.nextLine();
			if (vaccinated) {
				System.out.println("Vaccinated for chickenpox");
				numVaccinated += 1;
			} else {
				System.out.println("Not vaccinated for chickenpox");
			}
			System.out.print("Name: ");
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



