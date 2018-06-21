package team3.swS.charge.service;

import java.util.List;

import team3.swS.charge.dao.ChargeDao;
import team3.swS.charge.dao.ChargeDaoInf;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.memJoin.vo.MemberJoinVo;

public class ChargeService implements ChargeServiceInf {
	private ChargeDaoInf chargeDao;
	
	private static ChargeService service = new ChargeService();
	
	private  ChargeService() {
		chargeDao = ChargeDao.getInstace();
	}
	
	public static ChargeService getInstance() {
		return service;
	}

	@Override
	public String insertCharge(ChargeVO chargeVO) {
		return chargeDao.insertCharge(chargeVO);
	}

	

//	@Override
//	public int btnChargeOper(MemberJoinVo memVo) {
//		return chargeDao.btnChargeOper(memVo) ;
//	}

	
	

}
