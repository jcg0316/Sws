package team3.swS.voca.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.vo.VocaVO;

public class VocaDao implements VocaDaoInf {

	private static VocaDao dao = new VocaDao();

	private SqlMapClient smc;

	public VocaDao() {
		Reader rd;

		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static VocaDao getInstance() {
		return dao;
	}
	
	// 엑셀 -> 디비
	@Override
	public int onFileDB(VocaVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("voca.onFileDB", vo);
			// if(obj == null) {
			// cnt = 1;
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	// lvoco테이블에 있는 시퀀스 가져오기
	@Override
	public String select_LvocaNo() {
		String result_lvocaNo = null;
		try {
			// result_nextLvocaNo = (int) smc.queryForObject("voca.seqOfLvocaNo");
			result_lvocaNo = (String) smc.queryForObject("voca.select_LvocaNo");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result_lvocaNo;
	}
	
	// Voca시퀀스
	@Override
	public int seqOfVocaNo() {
		int result_nextVocaNo = 0;
		try {
			result_nextVocaNo = (Integer) smc.queryForObject("voca.seqOfVocaNo");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result_nextVocaNo;
	}
	
	
	// lvoca 시퀀스
	@Override
	public String addLVoca(LvocaVO lvo) {
		
		String result_next_LvocaNo = null;
		try {
			result_next_LvocaNo = (String) smc.insert("voca.addLVoca", lvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result_next_LvocaNo;
	}

	
	// lvoca에 셋팅
	@Override
	public int inVocaBook(LvocaVO lvo) {
		int result_invoca = 0;
		try {
			Object obj = smc.insert("voca.inVocaBook", lvo);
			if(obj == null) {
				result_invoca = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result_invoca;
	}

	@Override
	public String find_vocaName() {
		String vocaName = "";
		try {
			vocaName = (String) smc.queryForObject("voca.find_vocaName");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vocaName;
	}
	
	
	

}
