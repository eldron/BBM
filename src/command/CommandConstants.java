package command;

public class CommandConstants {
	// commands received from clients or send to clients
	public static final String CMD_LOG_IN =  "LogInCommand";
	public static final String CMD_LOG_OUT = "LogOutCommand";
	public static final String CMD_REGISTER = "RegisterCommand";
	
	// commands send to clients
	public static final String CMD_LOG_IN_RESULT = "LogInResultCommand";
	public static final String CMD_LOG_OUT_RESULT = "LogOutResultCommand";
	public static final String CMD_REGISTER_RESULT = "RegisterResultCommand";
	
	// attribute names
	public static final String ATTR_USER_NAME = "UserName";
	public static final String ATTR_IP = "IP";
	public static final String ATTR_SUCCESS = "Success";
	
	// element names
	public static final String ELE_USER = "User";
}
