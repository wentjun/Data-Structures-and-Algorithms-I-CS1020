// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex2
// Name: CHAN WEN TJUN 
// Matric. No.: A0121262
// Lab group: 7
// This program will read in lines of commands related to the social network system
// and carry the commands out. The commands are: registering users, following users,
// and returning the number of pairs of mutual followers in the social network system.

import java.util.*;

public class SocialNetwork {
	private User[] listOfUsers;
	private int numberOfUsers;

	//constructor
	public SocialNetwork() {
		listOfUsers = new User[100];
		numberOfUsers = 0;
	}

	//return the number of pairs of mutual follow friends
	public int findMutualFollow() {
		int numOfMutualFollow = 0;

		for (int i = 0; i < numberOfUsers - 1; i++) {
			for (int j = i + 1; j < numberOfUsers; j++) {
				if (User.isMutual(listOfUsers[i], listOfUsers[j])) {
					numOfMutualFollow++;
				} else {
				}
			}
		}
		return numOfMutualFollow;
	}

	//register a new user with a given name
	public void registerUser(String name) {
		User user = new User(name);
		listOfUsers[numberOfUsers] = user;
		numberOfUsers++;
	}

	//set user A follows user B
	public void setFollow(User A, User B) {
		A.setFollow(B);
	}

	//set user A unfollows user B
	public void setUnfollow(User A, User B) {
		A.setUnfollow(B);
	}

	// returns the User given the name
	public User findUser(String username1) {
		User user2 = null;

		for (int i = 0; i < this.numberOfUsers; i++) {
			user2 = this.listOfUsers[i];
			String username2 = user2.getName();
			if (username1.equals(username2)) {
				break;
			} else {
			}
		}
		return user2; 
	}

	private static String[] parseString (String str) {
		int length = str.length() - 1; 
		String[] parse = new String[length];
		parse = str.substring(1).split(" ");
		return parse;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SocialNetwork socialNetwork = new SocialNetwork();
		String actionInput, users, userA, userB;

		while (sc.hasNext()) {
			actionInput = sc.next();	

			if (actionInput.equals("R")) {		
				users = sc.nextLine();
				String[] userList = parseString(users);
				for (String user: userList) {
					socialNetwork.registerUser(user);
				}

			} else if (actionInput.equals("F")) {
				userA = sc.next();
				userB = sc.next();

				if (!userA.equals(userB)) {
					User A = socialNetwork.findUser(userA);
					User B = socialNetwork.findUser(userB);
					socialNetwork.setFollow(A, B);
				} else {
				}

			} else if (actionInput.equals("U")) {
				userA = sc.next();
				userB = sc.next();
				User A = socialNetwork.findUser(userA);
				User B = socialNetwork.findUser(userB);
				socialNetwork.setUnfollow(A, B);

			} else {
				System.out.println("Number of pairs of mutual followers: " 
						+ socialNetwork.findMutualFollow());
			}
		}
	}
}
