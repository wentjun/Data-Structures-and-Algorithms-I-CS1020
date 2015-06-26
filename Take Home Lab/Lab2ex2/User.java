// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex2
// Name: CHAN WEN TJUN 
// Matric. No.: A0121262X
// Lab group: 7
// This program stores the username, the array containing the users the user is following,
// the array containing the users following the user, number of followers, number of 
// people the user is following. The methods allow us to access the username, follow or 
// unfollow a particular user, and check if a pair of users are following each other.


public class User {
    
    private String userName;  // Username of user
    private User[] following;   // Array of users the user is following
    private int numberFollowing; // Number of users the user is following
    private User[] followers;  // Array of users are following the user
    private int numberFollowers; // Number of users following the user
    
    //constructor
    public User(String Name) {
        userName = Name;
        following = new User[100];
        followers = new User[100];
        numberFollowing = 0;
        numberFollowers = 0;
    }
    
    // gets username of User
    public String getName() {
        return this.userName;
    }
    
    //set this user follows a given user. 
    public void setFollow(User user) {
        if (!this.isFollowing(user)) {
            this.following[numberFollowing] = user;
            user.followers[user.numberFollowers] = this;
            this.numberFollowing++;
            user.numberFollowers++;
        } else {
        }
    }
    
    //set this user unfollows a given user.
    public void setUnfollow(User user) {
        
        if (this.isFollowing(user)) {
            // index of given user in User's following array
			int indexOfGivenUser = indexOf(this.following, user);           
			// removing given user from this User's following array
			for (int i = indexOfGivenUser; i < this.following.length - 1; i++) { 
				this.following[i] = this.following[i + 1];
            }
            
			this.numberFollowing--;
            
			// index of User in given user's followers array
			int indexOfUser = indexOf(user.followers, this);

            // removing User from the given user's followers array
			for (int i = indexOfUser; i < user.followers.length - 1; i++) { 
				user.followers[i] = user.followers[i + 1];
            }
            user.numberFollowers--;   
        } else {
        } 
    }
    
    // Pre-condition: both input need to be unique users
    // Post-condiiton: returns a boolean value which determines if 
	// 				   the inputed users follow each other
    // Descrition: checks if user1 and user2 are mutual followers
    public static boolean isMutual(User user1, User user2) {
        return user1.isFollowing(user2) && user2.isFollowing(user1);
    }
    
    
    // Pre-condition: input must be a valid user
    // Post-condition: returns a boolean value which determines if 
	//				   the given user follows the inputed user 
    // Description: checks if this user is following the given user 
    private boolean isFollowing(User user) {
        boolean isFollowing = false;
        int limit = this.numberFollowing;
        
        for (int i = 0; i < limit; i++) {
            if (isEqualUserName(this.following[i], user)) {
                isFollowing = true;
            } else {
            }
        }
        
        return isFollowing;
    }
    
    // Pre-condition: input must be valid user objects
    // Post-condition: returns a boolean value determining if 
	//				   the 2 input users are equivalent
    // Description: checks if the pair of users are the same by checking the 
	// 				equality of the usernames
    private static boolean isEqualUserName(User user1, User user2) {
        String userName1 = user1.userName;
        String userName2 = user2.userName;
        return userName1.equals(userName2);
    }
    
    // Pre-condition: first input should be an array of User objects which 
	//				  contains the second input (a valid user object)
    // Post-condition: returns the integer number which is the index of the 
	//				   user object specified in the given array
    // Description: Gives the index of the input user in the given array of users
    private static int indexOf(User[] array, User user) {
        boolean itemFound = false;
        int index = 0;
        
        while (!itemFound) {
            if (isEqualUserName(array[index], user)) {
				itemFound = true;
            } else {
                index++;
            }
        }
        return index;
    }
    
}
