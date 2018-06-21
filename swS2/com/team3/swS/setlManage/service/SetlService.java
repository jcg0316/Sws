package team3.swS.setlManage.service;

import java.util.List;

import team3.swS.charge.service.ChargeService;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.setlManage.dao.SetlDao;
import team3.swS.setlManage.dao.SetlDaoInf;

public class SetlService implements SetlServiceInf {
	private SetlDaoInf setlDao;
	
	private static SetlService service = new SetlService();
	
	private SetlService() {
		setlDao = SetlDao.getInstace();
	}
	
	public static SetlService getInstance() {
		return service;
	}

	@Override
	public List getChargeInfo() {
		return setlDao.getChargeInfo();
	}

	@Override
	public String updateChargeAppro(ChargeVO chargeAppro) {
		return setlDao.updateChargeAppro(chargeAppro);
	}

	@Override
	public List getMemberInfo() {
		return setlDao.getMemberInfo();
	}

	@Override
	public String updateMemberMileage(MemberJoinVo member) {
		return setlDao.updateMemberMileage(member);
	}

	@Override
	public List getChargeUserInfo(ChargeVO chargeVo) {
		return setlDao.getChargeUserInfo(chargeVo);
	}

	@Override
	public List<ChargeVO> getChargeEmailInfo(MemberJoinVo member) {
		return setlDao.getChargeEmailInfo(member);
	}

	@Override
	public List<ChargeVO> getChargeTelInfo(MemberJoinVo member) {
		return setlDao.getChargeTelInfo(member);
	}
	
	
	
}
