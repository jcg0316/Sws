package team3.swS.login.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;

public class LoginDao implements LoginDaoInf {

	private static LoginDao dao = new LoginDao();
	private SqlMapClient smc;
	
	private LoginDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static LoginDao getInstance() {
		return dao;
	}
	
	@Override
	public MemberJoinVo getLoginData(MemberJoinVo mbj) {
		MemberJoinVo mem = null;
		try {
			mem = (MemberJoinVo) smc.queryForObject("Login.getId", mbj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}
	
}
