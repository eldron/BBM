package model;

// manage BBM users, provide user information for other classes
public class UserManager {
	private User [] allUsers;// store all registered users, use user's id as index
	
	// returns true if a user name is already registered, needs database access
	public synchronized boolean isRegistered(String name){
		return false;
	}
	
	// register a user, needs database access
	public synchronized void register(String name){
		
	}
}
