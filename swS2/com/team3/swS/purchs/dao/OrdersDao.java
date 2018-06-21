package team3.swS.purchs.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public class OrdersDao implements OrdersDaoInf {
	private static OrdersDao dao = new OrdersDao();
	private SqlMapClient smc;
	
	private  OrdersDao() {
		try {
			Reader rd= Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static OrdersDao getInstace() {
		return dao;
	}
	
	@Override
	public int btnbuy(MemberJoinVo memVo) {
		int mileage = 0;
		try {
			mileage= smc.update("orders.btnbuy", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mileage;
		
		
	}
	@Override
	public int getOrders(OrdersVO orderVo) {
		int mileage  = 0;
//		if(Session.memJoin.getMem_no().equals(orderVo.getOrders_mem_no()) )
		try {
			mileage= (int) smc.queryForObject("orders.getOrders");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("session 정보와 DB정보를 비교한 데이터의 결과가 없습니다");
		}
		return mileage;
	}
//	@Override
//	public int getDate(OrdersVO orderVo) {
//		int date = 0;
//		try {
//			date = (int) smc.queryForObject("orders.getDate", orderVo);
//			System.out.println(date);
//			System.out.println(orderVo);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
	@Override
	public int insertOrders(OrdersVO ordersVo) {
		int result = 0;
		try {
			Object obj = smc.insert("orders.insertOrders",ordersVo);
			if(obj !=null) {
				result=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<ProdVO> getDate() {
		List<ProdVO> date = null;
		try {
			date =  smc.queryForList("orders.getDate");
			System.out.println(date);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}


}
