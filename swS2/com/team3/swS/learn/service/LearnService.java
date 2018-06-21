package team3.swS.learn.service;

import java.util.ArrayList;
import java.util.List;

import team3.swS.common.Session;
import team3.swS.learn.dao.LearnDao;
import team3.swS.learn.dao.LearnDaoInf;
import team3.swS.lvoca.main.LvocaController;
import team3.swS.voca.vo.VocaVO;

public class LearnService implements LearnServiceInf {
	
	private static LearnService service = new LearnService();
	
	private LearnDaoInf learnDao;
	
	private LearnService() {
		learnDao = LearnDao.getInstance();
	}
	
	public static LearnService getInstance() {
		return service;
	}

	@Override
	public void btnO(VocaVO vocaVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnX(VocaVO vocaVo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTextToLabel() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public int btnOInputed (VocaVO vocaVO) {
		return learnDao.btnOInputed(vocaVO); 
	}

	@Override
	public int btnXInputed(VocaVO vocaVO) {
		return learnDao.btnXInputed(vocaVO);
	}

	@Override
	public int memberToEndDay(String memJoin) {
		return learnDao.memberToEndDay(memJoin);
	}
	
	
}
