package team3.swS.infoSntcInqire.dao;


import java.util.List;

import team3.swS.infoSntcInqire.vo.InfoVO;

public interface InfoDaoInf {
	
	public List<InfoVO> getAllMember();
	
	public void btnAdd(InfoVO infoVo);
}
