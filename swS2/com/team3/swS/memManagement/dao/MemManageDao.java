package team3.swS.memManagement.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;

public class MemManageDao implements MemberManageDaoInf {
	
	private static MemManageDao dao = new MemManageDao();
	private SqlMapClient smc;
	
	private MemManageDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapconfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MemManageDao getInstace() {
		return dao;
	}
	@Override
	public List<MemberJoinVo> getMemberInfo() {
		List<MemberJoinVo> memList = new ArrayList<MemberJoinVo>();
		try {
			memList=smc.queryForList("setl.getMemberInfo");
		} catch (SQLException e) {
			memList=null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public String updateMemAuthor(MemberJoinVo author) {
		String cnt = null;
		try {
			cnt = ""+smc.update("memManage.updateMemAuthor",author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String updateMemStop(MemberJoinVo stop) {
		String cnt = null;
		try {
			cnt = ""+smc.update("memManage.updateMemStop",stop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String updateMemMile(MemberJoinVo mile) {
		String cnt = null;
		try {
			cnt = ""+smc.update("memManage.updateMemMile",mile);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberJoinVo> getMemEmailInfo(MemberJoinVo member) {
		List<MemberJoinVo> memList = new ArrayList<MemberJoinVo>();
		try {
			memList=smc.queryForList("memManage.getMemEmailInfo",member);
		} catch (SQLException e) {
			memList=null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public List<MemberJoinVo> getMemUserInfo(MemberJoinVo memberVo) {
		List<MemberJoinVo> memList = new ArrayList<MemberJoinVo>();
		try {
			memList=smc.queryForList("memManage.getMemUserInfo",memberVo);
		} catch (SQLException e) {
			memList=null;
			e.printStackTrace();
		}
		return memList;
	}

	

}
