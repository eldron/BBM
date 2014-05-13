package command;

import net.SocketHandler;
import model.UserManager;
import org.jdom.*;
import net.DataSender;

public abstract class ICommand {
	public abstract void init(Document doc);
	public abstract void act(DataSender sender, UserManager userManager);
}
