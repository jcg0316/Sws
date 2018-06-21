package team3.swS.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Ray
 *
 */
public class SMTPAuthenticator extends Authenticator {

	protected PasswordAuthentication getPasswordAuthentication() {
		String username = "cksruddlek@gmail.com"; // gmail 사용자;
		String password = "mvbaewrdofblflxk"; // 패스워드;
		return new PasswordAuthentication(username, password);
	}

}