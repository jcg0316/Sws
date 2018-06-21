package team3.swS.memJoin.service;

import team3.swS.memJoin.dao.MemberJoinDao;
import team3.swS.memJoin.dao.MemberJoinDaoInf;
import team3.swS.memJoin.vo.MemberJoinVo;

public class MemberJoinService implements MemberJoinServiceInf{
	
	private MemberJoinDaoInf memDao;
	
	private static MemberJoinService service = new MemberJoinService();
	// Service객체는 DAO 객체를 사용해야 하기 때문에 DAO 객체를 생성해야 한다.
	private MemberJoinService(){
		memDao = MemberJoinDao.getInstance();
	}
	
	public static MemberJoinService getInstance(){
		return service;
	}
	
	/**
	 * 회원가입
	 * @param tmp (insert 할 회원 정보가 들어있는 tempVO 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	@Override
	public int insertMember(MemberJoinVo mbj) {
		return memDao.insertMember(mbj);
	}
	
	/**
	 * 회원 아이디 중복 검사
	 * @param id 회원아이디
	 * @return	1이면 있고 0이면 없음
	 */
	public int IdCheckMember(String id){
		return memDao.IdCheckMember(id);
	}

	@Override
	public int mailCheckMember(String email) {
		return memDao.mailCheckMember(email);
	}

}
