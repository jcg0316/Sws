package team3.swS.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegCheck {
	
	// 아이디 정규식
	public boolean idRegex(String id) {

		Pattern p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$");
		Matcher m = p.matcher(id);
		boolean result = m.matches();

		return result;
	}

	// 비밀번호 정규식
	public boolean passwordRegex(String pw) {

		Pattern p = Pattern.compile("^[a-z].[A-Za-z0-9!@#$%^&*]{6,12}$");
		Matcher m = p.matcher(pw);
		boolean result = m.matches();

		return result;
	}
	
	// 닉네임 정규식
	public boolean nickRegex(String nick) {
		
		Pattern p = Pattern.compile("^[a-zA-Z0-9가-힣_]{1,8}$");
		Matcher m = p.matcher(nick);
		boolean result = m.matches();
		
		return result;
	}
	
	// 전화번호 정규식
	public boolean telRegex(String tel) {
		
		Pattern p = Pattern.compile("^01[016-9]-\\d{3,4}-\\d{4}$");
		Matcher m = p.matcher(tel);
		boolean result = m.matches();
		
		return result;
	}
	
	// 이메일 정규식
	public boolean mailRegex(String mail) {
		
		Pattern p = Pattern.compile("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$");
		Matcher m = p.matcher(mail);
		boolean result = m.matches();
		
		return result;
	}
	
}