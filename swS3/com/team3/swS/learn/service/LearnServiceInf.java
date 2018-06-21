package team3.swS.learn.service;

import java.util.List;

import team3.swS.voca.vo.VocaVO;

public interface LearnServiceInf {

	public void btnO(VocaVO vocaVo);

	public void btnX(VocaVO vocaVo);

	public void getTextToLabel();

	
	public int btnOInputed (VocaVO vocaVO);
	
	public int btnXInputed (VocaVO vocaVO);
	

	/**
	 * 유료 회원의 종료일자를 검색하기  위한 메서드
	 * @param memJoin
	 * @return
	 */
	public int memberToEndDay (String memJoin);
}
