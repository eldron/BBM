package genDoc;

import org.jdom.Document;
import org.jdom.Element;

import command.CommandConstants;

public class RegisterResultDocGen {
	public static Document genDoc(int ID){
		Document doc = new Document();
		Element root = new Element(CommandConstants.CMD_REGISTER_RESULT);
		root.setAttribute(CommandConstants.ATTR_USER_ID, ID + "");
		doc.setRootElement(root);
		
		return doc;
	}
}
