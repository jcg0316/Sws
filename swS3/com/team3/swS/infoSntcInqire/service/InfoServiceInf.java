package team3.swS.infoSntcInqire.service;

import java.util.List;

import team3.swS.infoSntcInqire.vo.InfoVO;

public interface InfoServiceInf {
	
	
	
	public List<InfoVO> getAllMember();
	
	public void btnAdd(InfoVO infoVo);
}
