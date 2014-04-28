package command;

import genDoc.RegisterResultDocGen;
import model.UserManager;
import net.DataSender;

import org.jdom.Document;

public class RegisterCommand extends ICommand {
	private String name;
	
	@Override
	public void init(Document doc) {
		// TODO Auto-generated method stub
		name = doc.getRootElement().getAttributeValue(CommandConstants.ATTR_USER_NAME);
	}

	@Override
	public void act(DataSender sender, UserManager userManager) {
		// TODO Auto-generated method stub
		int id = userManager.register(name);
		Document doc = RegisterResultDocGen.genDoc(id);
		sender.add(doc);
	}
}
