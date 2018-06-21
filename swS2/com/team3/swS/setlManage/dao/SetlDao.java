package team3.swS.setlManage.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.charge.dao.ChargeDao;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.memJoin.vo.MemberJoinVo;

public class SetlDao implements SetlDaoInf {
	
	private static SetlDao dao = new SetlDao();
	private SqlMapClient smc;
	
	private SetlDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapconfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SetlDao getInstace() {
		return dao;
	}
	
	@Override
	public List<ChargeVO> getChargeInfo() {
		List<ChargeVO> setlList = new ArrayList<ChargeVO>();
		try {
			setlList=smc.queryForList("setl.getChargeInfo");
		} catch (SQLException e) {
			setlList=null;
			e.printStackTrace();
		}
		return setlList;
	}
	
	@Override
	public String updateChargeAppro(ChargeVO chargeAppro) {
		String cnt = null;
		try {
			cnt = (String) smc.insert("setl.updateChargeAppro", chargeAppro);
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
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
	public String updateMemberMileage(MemberJoinVo member) {
		String cnt = null;
		try {
			cnt = (String) smc.insert("setl.updateMemberMileage", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<ChargeVO> getChargeUserInfo(ChargeVO chargeVo) {
		List<ChargeVO> setlList = new ArrayList<ChargeVO>();
		try {
			setlList=smc.queryForList("setl.getChargeUserInfo", chargeVo);
		} catch (SQLException e) {
			setlList=null;
			e.printStackTrace();
		}
		return setlList;
	}
	@Override
	public List<ChargeVO> getChargeEmailInfo(MemberJoinVo member) {
		List<ChargeVO> setlList = new ArrayList<ChargeVO>();
		try {
			setlList=smc.queryForList("setl.getChargeEmailInfo", member);
		} catch (SQLException e) {
			setlList=null;
			e.printStackTrace();
		}
		return setlList;
	}
	@Override
	public List<ChargeVO> getChargeTelInfo(MemberJoinVo member) {
		List<ChargeVO> setlList = new ArrayList<ChargeVO>();
		try {
			setlList=smc.queryForList("setl.getChargeTelInfo", member);
		} catch (SQLException e) {
			setlList=null;
			e.printStackTrace();
		}
		return setlList;
	}
	

}
