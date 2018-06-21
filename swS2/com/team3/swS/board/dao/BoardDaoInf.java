package team3.swS.board.dao;

import java.util.List;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.memJoin.vo.MemberJoinVo;

public interface BoardDaoInf {
	
	/**
	 * 글 하나의 정보를 얻어오기 위한 메서드
	 * @param bd
	 * @return
	 */

	public BoardVO getRead(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	/**
	 * 게시판의 정보를 읽어오는 메서드
	 * @return
	 */
	
	public List<BoardVO> getAllBoard_A();
	
	/**
	 * 글쓰기
	 * @param bd (insert 할 글 정보가 들어있는 BoardVO 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	public int insertboard_A(BoardVO bd);
	
	/**
	 * 글 수정
	 * @param bd
	 * @return
	 */
	public int updateboard_A(BoardVO bd);
	
	/**
	 * 글 삭제
	 * @return
	 */
	public int deleteboard_A(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/	
	
	/**
	 * 게시판의 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_B();
	
	/**
	 * 글쓰기
	 * @param bd (insert 할 글 정보가 들어있는 BoardVO 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	public int insertboard_B(BoardVO bd);
	
	/**
	 * 글 수정
	 * @param bd
	 * @return
	 */
	public int updateboard_B(BoardVO bd);
	
	/**
	 * 글 삭제
	 * @return
	 */
	public int deleteboard_B(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	/**
	 * 게시판의 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_C();
	
	/**
	 * 글쓰기
	 * @param bd (insert 할 글 정보가 들어있는 BoardVO 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	public int insertboard_C(BoardVO bd);
	
	/**
	 * 글 수정
	 * @param bd
	 * @return
	 */
	public int updateboard_C(BoardVO bd);
	
	/**
	 * 글 삭제
	 * @return
	 */
	public int deleteboard_C(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/	
	
	/**
	 * 게시판의 작성자 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Writer_A(BoardVO bd);
	
	/**
	 * 게시판의 내용 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Contents_A(BoardVO bd);
	
	/**
	 * 게시판의 제목 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Title_A(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	/**
	 * 게시판의 작성자 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Writer_B(BoardVO bd);
	
	/**
	 * 게시판의 내용 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Contents_B(BoardVO bd);
	
	/**
	 * 게시판의 제목 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Title_B(BoardVO bd);
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	/**
	 * 게시판의 작성자 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Writer_C(BoardVO bd);
	
	/**
	 * 게시판의 내용 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Contents_C(BoardVO bd);
	
	/**
	 * 게시판의 제목 정보를 읽어오는 메서드
	 * @return
	 */
	public List<BoardVO> getAllBoard_Title_C(BoardVO bd);
	
	
}
