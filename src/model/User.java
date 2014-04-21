package model;

public class User {
	private String id;
	private String ip;
	private boolean loggedin;
	private User [] friends;
	private int score;
	private Request [] raisedRequests;
	private Request [] handledRequests;
	
	public User(){
		
	}
	public void setID(String value){
		id = value;
	}
	
	public String getID(){
		return id;
	}
	
	public void setIP(String value){
		ip = value;
	}
	
	public String getIP(){
		return ip;
	}
	
	public void setLoggedin(boolean value){
		loggedin = value;
	}
	
	public boolean getLoggedin(){
		return loggedin;
	}
	
	public void setFriends(User [] value){
		friends = value;
	}
	
	public User [] getFriends(){
		return friends;
	}
	
	public void setScore(int value){
		score = value;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setRaisedRequests(Request [] value){
		raisedRequests = value;
	}
	
	public Request [] getRaisedRequests(){
		return this.raisedRequests;
	}
	
	public void setHandledRequests(Request [] value){
		this.handledRequests = value;
	}
	
	public Request [] getHandledRequests(){
		return this.handledRequests;
	}
}
