package team3.swS.lvoca.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.common.Session;
import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.vo.VocaVO;

public class LvocaDao implements LvocaDaoInf {
	
	private static LvocaDao dao = new LvocaDao();
	
	private SqlMapClient smc;
	
	public LvocaDao() {
		
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static LvocaDao getInstance() {
		return dao;
	}

	
	@Override
	public List<LvocaVO> getAllVoca() {
		List<LvocaVO> lvocaList = new ArrayList<LvocaVO>();
		try {
			lvocaList = smc.queryForList("lvoca.getAllVoca", Session.memJoin.getMem_no());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lvocaList;
	}


	@Override
	public List<VocaVO> getAllWord() {
		
		List<VocaVO> vocaList = null;
		try {
			vocaList = smc.queryForList("lvoca.getAllWord", Session.memJoin.getMem_no());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vocaList;
	}

	@Override
	public String Add_ExcelToDB(VocaVO vo) {
		String result_excelToDB = null;
		try {
			result_excelToDB =  (String) smc.insert("lvoca.Add_ExcelToDB", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result_excelToDB;
	}

//	@Override
//	public int seqOfVocaNo() {
//		int result_seqOfVocaNo = 0;
//		try {
//			result_seqOfVocaNo = (int) smc.queryForObject("lvoca.seqOfVocaNo");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return result_seqOfVocaNo;
//	}

	@Override
	public String addLVoca(LvocaVO lvo) {
		
		String result_LVoca = null;
		try {
			result_LVoca = (String) smc.insert("lvoca.addLVoca", lvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result_LVoca;
	}

	@Override
	public String select_LvocaNo(String select_LvocaNo) {
		String lvoca_no = null;
		try {
			lvoca_no = (String) smc.queryForObject("lvoca.select_LvocaNo", select_LvocaNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lvoca_no;
	}

	@Override
	public int onDelete_VocaBook(String vo) {
		int vocaBook_Delete = 0;
		try {
			vocaBook_Delete = smc.delete("lvoca.onDelete_VocaBook", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vocaBook_Delete;
	}

	@Override
	public int onDelete_LVoca(String lvo) {
		int delete_LVoca = 0;
		try {
			delete_LVoca = smc.delete("lvoca.onDelete_LVoca", lvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete_LVoca;
	}

	@Override
	public List<VocaVO> findLVoca_WordAndMean(String lvo) {
		List<VocaVO> WordAndMean_list = null;
		try {
			WordAndMean_list = smc.queryForList("lvoca.findVoca_WordAndMean", lvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return WordAndMean_list;
	}
	

}
