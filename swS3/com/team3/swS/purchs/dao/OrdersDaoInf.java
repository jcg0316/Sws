package team3.swS.purchs.dao;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public interface OrdersDaoInf {
	
	public int btnbuy(MemberJoinVo memVo);
	
	
	
	public int insertOrders(OrdersVO ordersVo);
	public int getOrders(OrdersVO orderVo);
	public List<ProdVO> getDate();
	
//	public int getDate(OrdersVO orderVo);
}
