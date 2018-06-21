package team3.swS.purchs.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.vo.OrdersVO;

public interface OrdersServiceInf {
	
	public int getOrders(OrdersVO orderVo);
	
	public int btnbuy(MemberJoinVo memVo);
	
//	public int getDate(OrdersVO orderVo);
	
	public int insertOrders(OrdersVO ordersVo);
	
	public List<ProdVO> getDate();
}
