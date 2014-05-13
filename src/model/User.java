package model;

import java.util.ArrayList;

import net.DataSender;

public class User {
	private int id;// unique for every user, start from 0
	private String name;// user name, also unique for every user
	private String pswd;// user's password
	private boolean loggedin;
	private ArrayList<Integer> friends;
	private int score;
	private ArrayList<Integer> raisedRequests;
	private ArrayList<Integer> handledRequests;
	private DataSender sender;
	
	public DataSender getDataSender(){
		return sender;
	}
	
	public void setDataSender(DataSender value){
		sender = value;
	}
	
	public User(){
		
	}
	
	public User(int id, String name, String pswd, int score, String f, String raisedrequests, String handledrequests){
		this.id = id;
		this.name = name;
		this.pswd = pswd;
		this.score = score;
		loggedin = false;
		sender = null;
		
		this.friends = new ArrayList<Integer>();
		if(f.length() > 0){
			String [] strings = f.split(":");
			for(String s : strings){
				this.friends.add(Integer.parseInt(s));
			}
		}
		this.raisedRequests = new ArrayList<Integer>();
		if(raisedrequests.length() > 0){
			String [] strings = raisedrequests.split(":");
			for(String s : strings){
				this.raisedRequests.add(Integer.parseInt(s));
			}
		}
		this.handledRequests = new ArrayList<Integer>();
		if(handledrequests.length() > 0){
			String [] strings = handledrequests.split(":");
			for(String s : strings){
				this.handledRequests.add(Integer.parseInt(s));
			}
		}
	}
	
	public void setID(int value){
		id = value;
	}
	
	public int getID(){
		return id;
	}
	
	public void setName(String value){
		name = value;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPswd(){
		return pswd;
	}
	
	public void setPswd(String value){
		this.pswd = value;
	}
	
	public void setLoggedin(boolean value){
		loggedin = value;
	}
	
	public boolean getLoggedin(){
		return loggedin;
	}
	
	public void setFriends(ArrayList<Integer> value){
		friends = value;
	}
	
	public ArrayList<Integer> getFriends(){
		return friends;
	}
	
	public void setScore(int value){
		score = value;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setRaisedRequests(ArrayList<Integer> value){
		raisedRequests = value;
	}
	
	public ArrayList<Integer> getRaisedRequests(){
		return this.raisedRequests;
	}
	
	public void setHandledRequests(ArrayList<Integer> value){
		this.handledRequests = value;
	}
	
	public ArrayList<Integer> getHandledRequests(){
		return this.handledRequests;
	}
	
	public String getFriendsString(){
		return this.listToString(this.friends);
	}
	
	public String getRaisedRequestsString(){
		return this.listToString(this.raisedRequests);
	}
	
	public String getHandledRequestsString(){
		return this.listToString(this.handledRequests);
	}
	
	private String listToString(ArrayList<Integer> list){
		String s = "";
		int size = list.size();
		if(size > 0){
			s += list.get(0);
		}
		if(size > 1){
			int i = 1;
			for(i = 1;i < size;i++){
				s += ":";
				s += list.get(i);
			}
		}
		
		return s;
	}
}
