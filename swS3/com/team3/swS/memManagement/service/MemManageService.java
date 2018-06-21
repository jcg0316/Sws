package team3.swS.memManagement.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.memManagement.dao.MemManageDao;
import team3.swS.memManagement.dao.MemberManageDaoInf;

public class MemManageService implements MemManageServiceInf{

	private MemberManageDaoInf manageDao;
	
	private static MemManageService service = new MemManageService();
	
	private MemManageService() {
		manageDao = MemManageDao.getInstace();
	}
	
	public static MemManageService getInstance(){
		return service;
	}
	@Override
	public List<MemberJoinVo> getMemberInfo() {
		return manageDao.getMemberInfo() ;
	}

	@Override
	public String updateMemAuthor(MemberJoinVo author) {
		return manageDao.updateMemAuthor(author);
	}

	@Override
	public String updateMemStop(MemberJoinVo stop) {
		return manageDao.updateMemStop(stop);
	}

	@Override
	public String updateMemMile(MemberJoinVo mile) {
		return manageDao.updateMemMile(mile);
	}

	@Override
	public List<MemberJoinVo> getMemEmailInfo(MemberJoinVo member) {
		return manageDao.getMemEmailInfo(member);
	}

	@Override
	public List<MemberJoinVo> getMemUserInfo(MemberJoinVo memberVo) {
		return manageDao.getMemUserInfo(memberVo);
	}


}
