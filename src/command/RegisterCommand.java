package command;

import genDoc.RegisterResultDocGen;
import model.UserManager;
import net.DataSender;
import net.SocketHandler;
import org.jdom.Document;

public class RegisterCommand extends ICommand {
	private String name;
	private String pswd;
	
	@Override
	public void init(Document doc) {
		// TODO Auto-generated method stub
		name = doc.getRootElement().getAttributeValue(CommandConstants.ATTR_USER_NAME);
		pswd = doc.getRootElement().getAttributeValue(CommandConstants.ATTR_PASSWORD);
	}

	@Override
	public void act(DataSender sender, UserManager userManager) {
		// TODO Auto-generated method stub
		int id = userManager.register(sender, name, pswd);
		Document doc = RegisterResultDocGen.genDoc(id);
		sender.add(doc);
	}
}
