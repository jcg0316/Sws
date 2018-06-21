package team3.swS.idSearch.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;

public class IdSearchDao implements IdSearchDaoInf {
	
	private static IdSearchDao dao = new IdSearchDao();
	private SqlMapClient smc;
	
	private IdSearchDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static IdSearchDao getInstance() {
		return dao;
	}
	
	@Override
	public MemberJoinVo getIdSearchData(MemberJoinVo mbj) {
		MemberJoinVo mem = null;
		
		try {
			mem = (MemberJoinVo) smc.queryForObject("IdSearch.getIdSearch", mbj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mem;
	}

}
