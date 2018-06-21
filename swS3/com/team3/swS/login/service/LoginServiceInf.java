package team3.swS.login.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;

public interface LoginServiceInf {
	
	/**
	 * 회원 하나의 VO 정보를 가져오는 메서드
	 * @return mbj 검색된 회원의 정보
	 */
	public MemberJoinVo getLoginData(MemberJoinVo mbj);
}
