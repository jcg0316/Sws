package team3.swS.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
db.properties파일의 내용을 읽어와 설정하는 예제

방법2) ResuorceBundle 객체 이용하기
*/
import java.util.ResourceBundle;

// 이 클래스는 JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 클래스 입니다.
public class DBUtil3 {
	static ResourceBundle bundle; // ResourceBundle 객체 선언
	
	static {
		bundle = ResourceBundle.getBundle("db"); //객체생성
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			/*return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "pc20", "java");*/
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
					
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!");
			return null;
		}
	}
}
