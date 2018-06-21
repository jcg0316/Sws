package team3.swS.infoSntcInqire.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.infoSntcInqire.vo.InfoVO;

public class InfoDao implements InfoDaoInf {

	private static InfoDao dao = new InfoDao();
	private SqlMapClient smc;
	
	private InfoDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc= SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InfoDao getInstace() {
		return dao;
	}
	@Override
	public void btnAdd(InfoVO infoVo) {
		Object obj;
		try {
			
			obj=smc.insert("info.btnAdd",infoVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<InfoVO> getAllMember() {
		List<InfoVO> infoList = new ArrayList<InfoVO>();
		try {
			infoList = smc.queryForList("Info.getInfoAll");
		} catch (SQLException e) {
			infoList = null;
			e.printStackTrace();
		}
		return infoList;
	}

}
