package team3.swS.learn.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.voca.vo.VocaVO;

public class LearnDao implements LearnDaoInf {
	// 싱글턴 시작
	private static LearnDao dao = new LearnDao();

	public static LearnDao getInstance() {
		return dao;
	}

	// 싱글턴 완료
	private SqlMapClient smc;

	public LearnDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void btnO(VocaVO vocaVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnX(VocaVO vocaVo) {
		// TODO Auto-generated method stub

	}

	/**
	 * i++ 라벨클리어 라벨에 텍스트 세팅(i-> i/총단어수; 영어->영어라벨; 한글->한글라벨)
	 */
	@Override
	public void getTextToLabel() {

	}

	/**
	 * OX 선택에 따라서 ox모두 있는 원시객체로 두느냐 x만 차있는 필터링된 객체로 두느냐 결정한다
	 */
	@Override
	public List<VocaVO> fillteringVocaVoToOX() {

		List<VocaVO> fillteredVocaVoList = null;// 필터링된 리스트가 담길 곳

		List<VocaVO> wordAndMean_list; // 전역변수로서 선택한 단어장이 저장되어 있음

		return fillteredVocaVoList;
	}

	@Override
	public int btnOInputed (VocaVO vocaVO) {
		int result_O = 0;
		try {
			result_O = smc.update("learnVoca.btnOInputed", vocaVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result_O;
	}

	@Override
	public int btnXInputed(VocaVO vocaVO) {
		int result_X = 0;
		try {
			result_X = smc.update("learnVoca.btnXInputed", vocaVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result_X;
	}

	@Override
	public int memberToEndDay(String memJoin) {
		int mem_remainDay = 0;
		try {
			mem_remainDay = (int) smc.queryForObject("learnVoca.memberToEndDay", memJoin);
			System.out.println("mem_remainDay : " + mem_remainDay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_remainDay;
	}
	
	
		
		

	//

}
