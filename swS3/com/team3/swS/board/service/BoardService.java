package team3.swS.board.service;

import java.util.List;

import team3.swS.board.dao.BoardDao;
import team3.swS.board.dao.BoardDaoInf;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.memJoin.vo.MemberJoinVo;

public class BoardService implements BoardServiceInf{
	
	private static BoardService service = new BoardService();
	private BoardDaoInf dao;
	
	private BoardService() {
		dao = BoardDao.getInstance();
	}
	
	public static BoardService getInstance() {
		return service;
	}

	@Override
	public BoardVO getRead(BoardVO bd) {
		return dao.getRead(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/	
	@Override
	public List<BoardVO> getAllBoard_A() {
		return dao.getAllBoard_A(); 
	}

	@Override
	public int insertboard_A(BoardVO bd) {
		return dao.insertboard_A(bd);
	}


	@Override
	public int updateboard_A(BoardVO bd) {
		return dao.updateboard_A(bd);
	}

	@Override
	public int deleteboard_A(BoardVO bd) {
		return dao.deleteboard_A(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_B() {
		return dao.getAllBoard_B();
	}

	@Override
	public int insertboard_B(BoardVO bd) {
		return dao.insertboard_B(bd);
	}

	@Override
	public int updateboard_B(BoardVO bd) {
		return dao.updateboard_B(bd);
	}

	@Override
	public int deleteboard_B(BoardVO bd) {
		return dao.deleteboard_B(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

	@Override
	public List<BoardVO> getAllBoard_C() {
		return dao.getAllBoard_C();
	}

	@Override
	public int insertboard_C(BoardVO bd) {
		return dao.insertboard_C(bd);
	}

	@Override
	public int updateboard_C(BoardVO bd) {
		return dao.updateboard_C(bd);
	}

	@Override
	public int deleteboard_C(BoardVO bd) {
		return dao.deleteboard_C(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_Writer_A(BoardVO bd) {
		return dao.getAllBoard_Writer_A(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Contents_A(BoardVO bd) {
		return dao.getAllBoard_Contents_A(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Title_A(BoardVO bd) {
		return dao.getAllBoard_Title_A(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_Writer_B(BoardVO bd) {
		return dao.getAllBoard_Writer_B(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Contents_B(BoardVO bd) {
		return dao.getAllBoard_Contents_B(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Title_B(BoardVO bd) {
		return dao.getAllBoard_Title_B(bd);
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_Writer_C(BoardVO bd) {
		return dao.getAllBoard_Writer_C(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Contents_C(BoardVO bd) {
		return dao.getAllBoard_Contents_C(bd);
	}

	@Override
	public List<BoardVO> getAllBoard_Title_C(BoardVO bd) {
		return dao.getAllBoard_Title_C(bd);
	}
}
