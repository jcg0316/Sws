package team3.swS.charge.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.charge.vo.ChargeVO;
import team3.swS.memJoin.vo.MemberJoinVo;

public class ChargeDao implements ChargeDaoInf {
	
	private static ChargeDao dao = new ChargeDao();
	private SqlMapClient smc;
	
	private ChargeDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapconfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ChargeDao getInstace() {
		return dao;
	}
	

	@Override
	public String insertCharge(ChargeVO chargeVO) {
		String cnt = null;
		try {
			cnt = (String) smc.insert("charge.insertCharge", chargeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
//	@Override
//	public int btnChargeOper(MemberJoinVo memVo) {
//		int mileage =0;
//		try {
//			mileage = smc.update("charge.btnChargeOper",memVo);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mileage;
//	}

}
