package team3.swS.voca.service;


import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.dao.VocaDao;
import team3.swS.voca.dao.VocaDaoInf;
import team3.swS.voca.vo.VocaVO;

public class VocaService implements VocaServiceInf {

	private static VocaService service = new VocaService();
	
	private VocaDaoInf vocaDao;
	
	private VocaService() {
		vocaDao = VocaDao.getInstance();
	}
	
	public static VocaService getInstance() {
		return service;
	}
	
	
	
	@Override
	public int onFileDB(VocaVO vo) {
	
		return vocaDao.onFileDB(vo);
	}
	

	@Override
	public String select_LvocaNo() {
		String lvoca_seq = vocaDao.select_LvocaNo();
		return lvoca_seq;
	}
	
	
	@Override
	public int seqOfVocaNo() {
		int voca_seq = vocaDao.seqOfVocaNo();
		return voca_seq;

	}

	
	
	@Override
	public String addLVoca(LvocaVO lvo) {
		String input_LVocaNo=null;
		input_LVocaNo = vocaDao.addLVoca(lvo);
		return input_LVocaNo;
	}

	@Override
	public int inVocaBook(LvocaVO lvo) {
		return vocaDao.inVocaBook(lvo);
	}

	@Override
	public String find_vocaName() {
		return vocaDao.find_vocaName();
	}
	
}
