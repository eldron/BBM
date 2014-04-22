package model;

public class Request {
	private int id;// request id, unique for each request
	private String content;// content of the request
	private String time;
	private String location;
	private User owner;// who raised the request
	private User [] handlers;// people who handled the request
	private boolean handled;// whether the request is handled
	
	public void setID(int value){
		id = value;
	}
	
	public int getID(){
		return id;
	}
	
	public void setContent(String value){
		content = value;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setTime(String value){
		time = value;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setLocation(String value){
		location = value;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setOwner(User value){
		owner = value;
	}
	
	public User getOwner(){
		return owner;
	}
	
	public void setHandlers(User [] value){
		handlers = value;
	}
	
	public User [] getHandlers(){
		return handlers;
	}
	
	public void setHandled(boolean value){
		handled = value;
	}
	
	public boolean getHandled(){
		return handled;
	}
}
