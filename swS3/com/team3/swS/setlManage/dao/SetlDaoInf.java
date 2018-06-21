package team3.swS.setlManage.dao;

import java.util.List;

import team3.swS.charge.vo.ChargeVO;
import team3.swS.memJoin.vo.MemberJoinVo;


public interface SetlDaoInf {
	
	
	public List<ChargeVO> getChargeInfo();

	public List<ChargeVO> getChargeUserInfo(ChargeVO chargeVo);
	
	public List<ChargeVO> getChargeEmailInfo(MemberJoinVo member);

	public List<ChargeVO> getChargeTelInfo(MemberJoinVo member);

	public String updateChargeAppro(ChargeVO chargeAppro);
	
	public List<MemberJoinVo> getMemberInfo();

	public String updateMemberMileage(MemberJoinVo member);
}
