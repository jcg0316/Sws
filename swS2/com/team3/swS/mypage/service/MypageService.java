package team3.swS.mypage.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.mypage.dao.MypageDao;
import team3.swS.mypage.dao.MypageDaoInf;
import team3.swS.mypage.vo.VoucherVO;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public class MypageService	implements MypageServiceInf {
	
private MypageDaoInf myDao;
	
	private static MypageService service = new MypageService();
	// Service객체는 DAO 객체를 사용해야 하기 때문에 DAO 객체를 생성해야 한다.
	
	private MypageService(){
		myDao = MypageDao.getInstance();
	}
	
	public static MypageService getInstance(){
		return service;
	}
	
	@Override
	public int updateMember(MemberJoinVo mbj) {
		return myDao.updateMember(mbj);
	}

	@Override
	public int deleteMember(String pw) {
		return myDao.deleteMember(pw);
		
	}

	@Override
	public List getAllVoucher(String memNo) {
		return myDao.getAllVoucher(memNo);
	}

	@Override
	public List<OrdersVO> select_memNo(String memNo) {
		
		return myDao.select_memNo(memNo);
	}

	

	
	
}
