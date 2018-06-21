package team3.swS.comments.service;

import java.util.List;

import team3.swS.comments.vo.CommentsVo;

public interface CommentsServiceInf {
	
	/**
	 * 댓글의 정보를 읽어오는 메서드
	 * @return
	 */
	
	public List<CommentsVo> getAllComments(CommentsVo cv);
	
	/**
	 * 댓글 쓰기
	 * @param bd (insert 할 글 정보가 들어있는 CommentsVo 객체)	
	 * @return 작업성공 : 1 이상의 값
	 * 		    실패 : 0
	 */
	public int insertComments(CommentsVo cv);
	
	/**
	 * 댓글 삭제
	 * @return
	 */
	public int deleteComments(CommentsVo cv);
}
