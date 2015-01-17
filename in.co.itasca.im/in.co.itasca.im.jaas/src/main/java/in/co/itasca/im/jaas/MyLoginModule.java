package in.co.itasca.im.jaas;

import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class MyLoginModule implements LoginModule {
	
	private CallbackHandler handler;
	  private Subject subject;
	  private UserPrincipal userPrincipal;
	  private RolePrincipal rolePrincipal;
	  private String login;
	  private List<String> userGroups;

	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {

		
		handler = callbackHandler;
		this.subject=subject;
	}

	public boolean login() throws LoginException {
	
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("login");
		callbacks[1] = new PasswordCallback("password", true);
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
