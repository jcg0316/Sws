package team3.swS.voca.service;

import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.vo.VocaVO;

public interface VocaServiceInf {
	
	/**
	 * 엑셀파일을 디비에 저장하기 위한 메서드
	 * @param vo 추가할 단어장
	 * @return 해당하는 단어장이 있으면 1, 없으면 0을 반환한다.
	 */
	public int onFileDB(VocaVO vo);
	
	
	/**
	 * lvoca_no을 시퀀스로 지정하기 위한 메서드
	 * @return 
	 */
	public String select_LvocaNo();


	public int seqOfVocaNo();
	

	/**
	 * lvoca_no을 시퀀스로 지정하기 위한 메서드
	 * @return
	 */
	public String addLVoca(LvocaVO lvo);
	
	
	/**
	 * lvoca에 셋팅
	 * @param lvo
	 * @return
	 */
	public int inVocaBook(LvocaVO lvo);
	
	
	/**
	 * 파일이름을 가져오기 위한 메서드
	 * @return 파일이름
	 */
	public String find_vocaName();

}
