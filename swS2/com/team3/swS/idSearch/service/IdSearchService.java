package team3.swS.idSearch.service;

import team3.swS.idSearch.dao.IdSearchDao;
import team3.swS.idSearch.dao.IdSearchDaoInf;
import team3.swS.memJoin.vo.MemberJoinVo;

public class IdSearchService implements IdSearchServiceInf {
	
	private IdSearchDaoInf idSearchDao;
	
	private static IdSearchService service = new IdSearchService();
	
	private IdSearchService() {
		idSearchDao = IdSearchDao.getInstance();
	}
	
	public static IdSearchService getInstance(){
		return service;
	}

	@Override
	public MemberJoinVo getIdSearchData(MemberJoinVo mbj) {
		return idSearchDao.getIdSearchData(mbj);
	}

}
