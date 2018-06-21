package team3.swS.memManagement.dao;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;

public interface MemberManageDaoInf {

	public List<MemberJoinVo> getMemberInfo();
	
	public String updateMemAuthor(MemberJoinVo author);
	
	public String updateMemStop(MemberJoinVo stop);
	
	public String updateMemMile(MemberJoinVo mile);
	
	public List<MemberJoinVo> getMemEmailInfo(MemberJoinVo member);
	
	public List<MemberJoinVo> getMemUserInfo(MemberJoinVo memberVo);
	
}
