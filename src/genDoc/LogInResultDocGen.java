package genDoc;

import org.jdom.Document;
import org.jdom.Element;

import command.CommandConstants;

public class LogInResultDocGen {
	public static Document genDoc(int id){
		Document doc = new Document();
		Element root = new Element(CommandConstants.CMD_LOG_IN_RESULT);
		root.setAttribute(CommandConstants.ATTR_USER_ID, id + "");
		doc.setRootElement(root);
		
		return doc;
	}
}
