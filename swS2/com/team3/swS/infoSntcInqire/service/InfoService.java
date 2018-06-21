package team3.swS.infoSntcInqire.service;

import java.util.List;

import team3.swS.infoSntcInqire.dao.InfoDao;
import team3.swS.infoSntcInqire.dao.InfoDaoInf;
import team3.swS.infoSntcInqire.vo.InfoVO;

public class InfoService implements InfoServiceInf {
	private InfoDaoInf infoDao;
	// 자기 참조 변수
	private static InfoService service = new InfoService();
	
	// 생성자
	private InfoService(){
		infoDao = InfoDao.getInstace();
	}
	public static InfoService getInstance() {
		return service;
	}
	
	@Override
	public void btnAdd(InfoVO infoVo) {
		infoDao.btnAdd(infoVo);
		
	}
	@Override
	public List<InfoVO> getAllMember() {
		return infoDao.getAllMember();
	}

}
