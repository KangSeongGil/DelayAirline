package Model;

import SCS.*;

public class LoginInfo {
	private String ID;
	private char[] PW = new char[10];
	private AccessProxy accessProxy;
	
	public boolean requestAuthority(){
		boolean success;
		accessProxy = accessProxy.getInstance();
		success = accessProxy.requestAuthority(this.ID, this.PW);
		return(success);
	}
	
	public LoginInfo(){		
		
	}
	
	public void setID(String userID){
		this.ID = userID;
	}
	
	public void setPW(char[] userPW){
		this.PW = userPW;
	}
	
	

}
