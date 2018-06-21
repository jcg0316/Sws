package team3.swS.lvoca.service;

import java.util.List;

import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.vo.VocaVO;

public interface LvocaServiceInf {
	
	
	
	/**
	 * VocaVO에 있는 단어들을 추출하기
	 * @param vo 
	 * @return 해당하는 단어장이 있으면 1, 없으면 0을 반환한다.
	 */
	public List<VocaVO> getAllWord();
	
	
	/**
	 * 단어장에 있는 데이터 가져오기
	 * @param mv 추가할 단어장
	 * @return 해당하는 단어장이 있으면 1, 없으면 0을 반환한다.
	 */
	public List<LvocaVO> getAllVoca();
	
	
	/**
	 * 엑셀에 있는 데이터를 디비에 저장하기 위한 메서드
	 * @param vo
	 * @return
	 */
	public String Add_ExcelToDB(VocaVO vo);
	
	
	/**
	 * LVoca에 데이터 저장
	 * @param lvo
	 * @return
	 */
	public String addLVoca(LvocaVO lvo);
	
	
	/**
	 * lvoca_no의 값을 리턴해주는 메서드
	 * @return
	 */
	public String select_LvocaNo(String select_LvocaNo);
	
	
	/**
	 * VocaVO 테이블 삭제
	 * @param v
	 * @return
	 */
	public int onDelete_VocaBook(String vo);
	
	
	/**
	 * LVocaVO테이블 삭제하는 메서드
	 * @param lvo
	 * @return
	 */
	public int onDelete_LVoca(String lvo);
	
	
	/**
	 * lvoca 테이블에서 선택한 아이템의 lvoca_no으로 단어와 뜻을 가져온다.   
	 * @param lvo 'lvoca_no'
	 * @return 성공하면 1, 실패하면 0
	 */
	public List<VocaVO> findLVoca_WordAndMean(String lvo);
	
	

}
