package in.co.itasca.im.jaas;

import java.security.Principal;

public class UserPrincipal implements Principal {
private String name;

public void setName(String name) {
	this.name = name;
}
public UserPrincipal(String name){
	
	super();
	this.name=name;
}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
