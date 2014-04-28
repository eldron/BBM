package model;
import java.util.HashMap;
import java.sql.*;

import server.ServerMain;

// manage BBM users, provide user information for other classes
public class UserManager {
	private static UserManager userManager = null;// singleton
	private int maxUserID;
	private int maxRequestID;
	
	private UserManager(){
		allUsers = new HashMap<Integer, User>();
		allRequests = new HashMap<Integer, Request>();
		maxUserID = -1;
		maxRequestID = -1;
	}
	
	public static UserManager getUserManager(){
		if(userManager == null){
			userManager = new UserManager();
			userManager.allUsers = new HashMap<Integer, User>();
			userManager.allRequests = new HashMap<Integer, Request>();
			
			try {
				ResultSet rs = ServerMain.getStatement().executeQuery("SELECT * FROM USERS;");
				while(rs.next()){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int score = rs.getInt("score");
					String friends = rs.getString("friends");
					String raisedrequests = rs.getString("raisedrequests");
					String handledrequests = rs.getString("handledrequests");
					User user = new User(id, name, score, friends, raisedrequests, handledrequests);
					userManager.allUsers.put(id, user);
					if(id > userManager.maxUserID){
						userManager.maxUserID = id;
					}
				}
				
				rs = ServerMain.getStatement().executeQuery("SELECT * FROM REQUESTS;");
				while(rs.next()){
					int id = rs.getInt("id");
					String content = rs.getString("content");
					String time = rs.getString("time");
					String location = rs.getString("location");
					int owner = rs.getInt("owner");
					String handlers = rs.getString("handlers");
					int handled = rs.getInt("handled");
					Request request = new Request(id, content, time, location, owner, handlers, handled);
					userManager.allRequests.put(id, request);
					if(id > userManager.maxRequestID){
						userManager.maxRequestID = id;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userManager;
	}
	
	private HashMap<Integer, User> allUsers;// store all users, key is user's ID
	private HashMap<Integer, Request> allRequests;// store all requests, key is request's ID
	
	// register a user, needs database access
	// new User instance, add it into allUsers hashmap, insert into table USERS
	// returns registered user ID if successful, returns -1 if not
	public synchronized int register(String name){
		maxUserID++;
		User user = new User(maxUserID, name, 0, "", "", "");
		allUsers.put(maxUserID, user);
		
		String sql = "INSERT INTO USERS (ID, NAME, SCORE, FRIENDS, RAISEDREQUESTS, HANDLEDREQUESTS) " +
					"VALUES(" + user.getID() + ", " +
					user.getName() + ", " +
					user.getScore() + ", " + 
					user.getFriendsString() + ", " +
					user.getRaisedRequestsString() + ", " +
					user.getHandledRequestsString() + ");";
		try {
			ServerMain.getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return user.getID();
	}
	
	public User getUserByID(int id){
		return allUsers.get(id);
	}
	
	public Request getRequestByID(int id){
		return allRequests.get(id);
	}
}
