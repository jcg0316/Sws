package team3.swS.memJoin.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;

public class MemberJoinDao implements MemberJoinDaoInf {
	
	private static MemberJoinDao dao = new MemberJoinDao();
	private SqlMapClient smc;
	
	private MemberJoinDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberJoinDao getInstance() {
		return dao;
	}
	
	
	@Override
	public int insertMember(MemberJoinVo mbj) {
		int result = 0;
		try {
			Object obj = smc.insert("MemJoin.insertMember", mbj);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int IdCheckMember(String id) {
		int result = 0;
		try {
			Object obj = (MemberJoinVo)smc.queryForObject("MemJoin.idCheckMember", id);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int mailCheckMember(String email) {
		int result = 0;
		try {
			Object obj = (MemberJoinVo)smc.queryForObject("MemJoin.mailCheckMember", email);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
