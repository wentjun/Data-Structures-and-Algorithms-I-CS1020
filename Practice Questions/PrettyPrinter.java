import java.util.*;

public class PrettyPrinter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a line below:");
		String line = sc.nextLine();
		String newLine;
		//replaces all spaces with a blank space " ".
		//" \s" matches a space/tab/new line," +" represents one or more of those
		newLine = line.replaceAll("\\s+", " ");
		//removes blank spaces at beginning and end of string
		newLine = newLine.trim();

		System.out.println("Pretty-printed line:");
		System.out.println("|" + newLine + "|");
	}
}
