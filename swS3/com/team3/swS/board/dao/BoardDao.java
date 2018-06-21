package team3.swS.board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;


public class BoardDao implements BoardDaoInf {

	private static BoardDao dao = new BoardDao();
	private SqlMapClient smc;
	
	Reader rd = null;
	private BoardDao() {
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static BoardDao getInstance() { return dao; }
//	싱글턴 적용 완료
	
	@Override
	public BoardVO getRead(BoardVO bd) {
		BoardVO wr = null;
		try {
			wr = (BoardVO) smc.queryForObject("Board.getRead", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wr;
		
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_A() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_A");
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	
	@Override
	public int insertboard_A(BoardVO bd) {
		int result = 0;
		try {
			Object obj = smc.insert("Board.insertBoard_A", bd);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int updateboard_A(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.updateBoard_A", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteboard_A(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.deleteBoard_A", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_B() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_B");
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int insertboard_B(BoardVO bd) {
		int result = 0;
		try {
			Object obj = smc.insert("Board.insertBoard_B", bd);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int updateboard_B(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.updateBoard_B", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteboard_B(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.deleteBoard_B", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_C() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_C");
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int insertboard_C(BoardVO bd) {
		int result = 0;
		try {
			Object obj = smc.insert("Board.insertBoard_C", bd);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int updateboard_C(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.updateBoard_C", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteboard_C(BoardVO bd) {
		int cnt = 0;
		try {
			cnt = smc.update("Board.deleteBoard_C", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/	
	
	@Override
	public List<BoardVO> getAllBoard_Writer_A(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Writer_A",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	
	@Override
	public List<BoardVO> getAllBoard_Contents_A(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Contents_A",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	
	@Override
	public List<BoardVO> getAllBoard_Title_A(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Title_A",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/	
	
	@Override
	public List<BoardVO> getAllBoard_Writer_B(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Writer_B",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoard_Contents_B(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Contents_B",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoard_Title_B(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Title_B",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
	@Override
	public List<BoardVO> getAllBoard_Writer_C(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Writer_C",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoard_Contents_C(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Contents_C",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoard_Title_C(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard_Title_C",bd);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
}