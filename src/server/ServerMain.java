package server;
import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.UserManager;
import net.SocketHandler;

public class ServerMain {
	private static ExecutorService pool;
	private static Connection c = null;
	private static Statement stmt = null;
	
	public static Statement getStatement(){
		return stmt;
	}
	
	public static void main(String [] args){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bbm.db");
			c.setAutoCommit(true);
			stmt = c.createStatement();
			System.out.println("========================>>>>>>>>>>>>>>>>>>>>>Connected to database successfully<<<<<<<<<<<<<<<<<<<<<<=======.");
			
			pool = Executors.newCachedThreadPool();
			try{
				ServerSocket serverSocket = new ServerSocket(ServerConstants.PORT);
				
				while(true){
					Socket sock = serverSocket.accept();
					System.err.println("=============>>>>>>>>>>>>> Connection from " + sock.getInetAddress().getHostAddress());
					sock.setKeepAlive(true);
					sock.setSoTimeout(0);
					pool.submit(new SocketHandler(sock, UserManager.getUserManager()));
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
