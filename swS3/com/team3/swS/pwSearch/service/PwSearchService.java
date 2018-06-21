package team3.swS.pwSearch.service;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.pwSearch.dao.PwSearchDao;
import team3.swS.pwSearch.dao.PwSearchDaoInf;

public class PwSearchService implements PwSearchServiceInf{
	
	private PwSearchDaoInf pwSearchDao;
	
	private static PwSearchService service = new PwSearchService();
	
	private PwSearchService(){
		pwSearchDao = PwSearchDao.getInstance();
	}
	
	public static PwSearchService getInstance() {
		return service;
	}
	
	
	@Override
	public MemberJoinVo getIdMailSearchData(MemberJoinVo mbj) {
		return pwSearchDao.getIdMailSearchData(mbj);
	}

}
