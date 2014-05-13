package net;

import java.io.IOException;
import java.net.Socket;
import model.UserManager;
import command.ICommand;

public class SocketHandler implements Runnable {
	public Socket getSocket(){
		return socket;
	}
	
	private Socket socket;
	private UserManager userManager;
	
	public SocketHandler(Socket sock, UserManager userManager){
		socket = sock;
		this.userManager = userManager;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			DataSender sender = new DataSender(socket, userManager);
			new Thread(sender).start();
			
			Parser parser = new Parser(socket.getInputStream());
			ICommand nextCommand = null;
			while((nextCommand = parser.nextCommand()) != null){
				nextCommand.act(sender, userManager);
			}
			
			sender.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
