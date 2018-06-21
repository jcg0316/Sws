package team3.swS.memJoin.dao;

import team3.swS.memJoin.vo.MemberJoinVo;


public interface MemberJoinDaoInf {
	
	/**
	 * 회원가입
	 * @param mbj (insert 할 회원 정보가 들어있는 MemberJoinVO 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	public int insertMember(MemberJoinVo mbj);
	
	/**
	 * 회원 아이디 중복 검사
	 * @param id 회원아이디
	 * @return	1이면 있고 0이면 없음
	 */
	public int IdCheckMember(String id);
	
	/**
	 * 회원 메일 중복 검사
	 * @param email 회원이메일
	 * @return	1이면 있고 0이면 없음
	 */
	public int mailCheckMember(String email);
	
}
