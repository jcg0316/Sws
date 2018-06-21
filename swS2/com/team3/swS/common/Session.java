package team3.swS.common;

import java.util.ArrayList;
import java.util.List;

import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.comments.vo.CommentsVo;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.voca.vo.VocaVO;

public class Session {
	
	public static MemberJoinVo memJoin;
	public static List<VocaVO> wordAndMean_list = new ArrayList<>(); // 암기하기에서 쓰기 위한 단어vo객체가 담겨있는 리스트
	public static BoardVO boardtemp;
	public static MemberJoinVo mileage; 
	public static CommentsVo commenttemp;
}
