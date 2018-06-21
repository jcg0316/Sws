package team3.swS.mypage.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.mypage.vo.VoucherVO;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public interface MypageServiceInf {
	/**
	 * 회원정보 수정
	 * @param tmp (update할 회원 정보가 들어있는 tempVO 객체)
	 * @return 작업성공 : 1 이상의 값
	 *         실패 : 0 
	 */
	public int updateMember(MemberJoinVo tmp);
	
	/**
	 * 회원정보 삭제 ( 실제 삭제가 아닌 사용여부 false )
	 * @param pw
	 * @return 작업성공 : 1
	 *         실패 : 0
	 */
	public int deleteMember(String pw);
	
	public List<VoucherVO> getAllVoucher(String memNo);
	
	public List<OrdersVO>  select_memNo(String memNo) ;
}
