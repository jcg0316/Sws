package team3.swS.idSearch.dao;

import team3.swS.memJoin.vo.MemberJoinVo;

public interface IdSearchDaoInf {

	/**
	 * 이메일을 검색하기 위해 회원 하나의 VO 정보를 가져오는 메서드
	 * @return mbj 검색된 회원의 정보
	 */
	public MemberJoinVo getIdSearchData(MemberJoinVo mbj);

}
