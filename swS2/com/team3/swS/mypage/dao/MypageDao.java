package team3.swS.mypage.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.mypage.vo.VoucherVO;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public class MypageDao implements MypageDaoInf{
	
	private static MypageDao dao = new MypageDao();
	private SqlMapClient smc;
	
	private MypageDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MypageDao getInstance() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao;
	}
	
	
	@Override
	public int updateMember(MemberJoinVo mbj) {
		int cnt = 0;
		try {
			cnt = smc.update("Mypage.updateMember", mbj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String pw) {
		int cnt = 0;
		try {
			cnt = smc.update("Mypage.deleteMember", pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	@Override
	public List<VoucherVO> getAllVoucher(String memNo) {
		List<VoucherVO> voucList = new ArrayList<VoucherVO>();
		try {
			voucList = smc.queryForList("Mypage.getAllVoucher", memNo);
		} catch (SQLException e) {
			voucList=null;
			e.printStackTrace();
		}
		return voucList;
	}

	@Override
	public List<OrdersVO> select_memNo(String memNo) {
		List<OrdersVO> list = new ArrayList<>();
//		OrdersVO result_memNo=null;
		try {
			list= smc.queryForList("Mypage.select_memNo", memNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
