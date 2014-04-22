package net;

import model.UserManager;

import org.jdom.*;
import org.jdom.output.XMLOutputter;

import java.io.*;
import java.net.*;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * A DataSender is bound to a client socket, all data server wants to send to a client should be put to the 
 * end of the bounded DataSender's toSend queue
 */
public class DataSender implements Runnable {
	private Socket sock;
	private LinkedBlockingQueue<Document> toSend;
	private XMLOutputter xmlOutputter;
	private boolean stopped = false;
	//private String name;// user name
	private UserManager userManager;
	
	public UserManager getUserManager(){
		return userManager;
	}
	
	public String getIP(){
		return sock.getInetAddress().getHostAddress();
	}
	
	public synchronized boolean isStopped(){
		return this.stopped;
	}
	
	public synchronized void close(){
		this.stopped = true;
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DataSender(Socket sock, UserManager userManager){
		this.sock = sock;
		this.userManager = userManager;
		toSend =  new LinkedBlockingQueue<Document>();
		xmlOutputter = new XMLOutputter();
	}
	
	public void add(Document doc){
		try {
			toSend.put(doc);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(isStopped() == false){
			try {
				Document doc = toSend.take();
				String data = xmlOutputter.outputString(doc) + "\0";
				System.err.println("send to client" + data);
				
				try {
					OutputStream out = sock.getOutputStream();
					out.write(data.getBytes());
					out.flush();
					Thread.currentThread().sleep(300);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
