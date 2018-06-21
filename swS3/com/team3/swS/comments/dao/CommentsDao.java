package team3.swS.comments.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.comments.vo.CommentsVo;

public class CommentsDao implements CommentsDaoInf{
	
	private static CommentsDao dao = new CommentsDao();
	private SqlMapClient smc;
	
	Reader rd = null;
	private CommentsDao() {
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static CommentsDao getInstance() { return dao;}
	
	@Override
	public List<CommentsVo> getAllComments(CommentsVo cv) {
		List<CommentsVo> boardList = new ArrayList<CommentsVo>();
		boardList = null;
		try {
			boardList = smc.queryForList("Comments.getAllComments",cv);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int insertComments(CommentsVo cv) {
		int result = 0;
		try {
			Object obj = smc.insert("Comments.insertComments", cv);
			if(obj != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteComments(CommentsVo cv) {
		int cnt = 0;
		try {
			cnt = smc.update("Comments.deleteComments", cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
