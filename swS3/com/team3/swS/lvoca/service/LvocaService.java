package team3.swS.lvoca.service;

import java.util.List;

import team3.swS.lvoca.dao.LvocaDao;
import team3.swS.lvoca.dao.LvocaDaoInf;
import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.vo.VocaVO;

public class LvocaService implements LvocaServiceInf {
	
	private static LvocaService service = new LvocaService();
	
	private LvocaDaoInf lvocaDao;
	
	private LvocaService() {
		lvocaDao = LvocaDao.getInstance();
	}
	
	
	public static LvocaService getInstance() {
		return service;
	}
	
	
	@Override
	public List<VocaVO> getAllWord() {
		return lvocaDao.getAllWord();
	}

	
	@Override
	public List<LvocaVO> getAllVoca() {
		return lvocaDao.getAllVoca();
	}

	@Override
	public String Add_ExcelToDB(VocaVO vo) {
		return lvocaDao.Add_ExcelToDB(vo);
	}


	@Override
	public String addLVoca(LvocaVO lvo) {
		String input_LVocaNo = null;
		input_LVocaNo = lvocaDao.addLVoca(lvo);
		return input_LVocaNo;
	}

	@Override
	public String select_LvocaNo(String select_LvocaNo) {
		return lvocaDao.select_LvocaNo(select_LvocaNo);
	}


	@Override
	public int onDelete_VocaBook(String vo) {
		return lvocaDao.onDelete_VocaBook(vo);
	}


	@Override
	public int onDelete_LVoca(String lvo) {
		return lvocaDao.onDelete_LVoca(lvo);
	}


	@Override
	public List<VocaVO> findLVoca_WordAndMean(String lvo) {
		return lvocaDao.findLVoca_WordAndMean(lvo);
	}



}
