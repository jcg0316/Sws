package team3.swS.pwSearch.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;

public class PwSearchDao implements PwSearchDaoInf{
	
	private static PwSearchDao dao = new PwSearchDao();
	private SqlMapClient smc;
	
	private PwSearchDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static PwSearchDao getInstance() {
		return dao;
	}
	
	
	@Override
	public MemberJoinVo getIdMailSearchData(MemberJoinVo mbj) {
		MemberJoinVo mem = null;
		try {
			mem = (MemberJoinVo) smc.queryForObject("PdSearch.getPwSearch", mbj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

}
