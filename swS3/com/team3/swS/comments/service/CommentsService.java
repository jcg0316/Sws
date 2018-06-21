package team3.swS.comments.service;

import java.util.List;

import team3.swS.comments.dao.CommentsDao;
import team3.swS.comments.dao.CommentsDaoInf;
import team3.swS.comments.vo.CommentsVo;

public class CommentsService implements CommentsServiceInf {
	
	private static CommentsService service = new CommentsService();
	private CommentsDaoInf dao;
	
	private CommentsService() {
		dao = CommentsDao.getInstance();
	}
	
	public static CommentsService getInstance() {
		return service;
	}
	
	@Override
	public List<CommentsVo> getAllComments(CommentsVo cv) {
		return dao.getAllComments(cv);
	}
	
	@Override
	public int insertComments(CommentsVo cv) {
		return dao.insertComments(cv);
	}

	@Override
	public int deleteComments(CommentsVo cv) {
		return dao.deleteComments(cv);
	}


}
