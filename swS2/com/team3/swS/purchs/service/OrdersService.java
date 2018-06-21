package team3.swS.purchs.service;

import java.util.List;

import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.dao.OrdersDao;
import team3.swS.purchs.dao.OrdersDaoInf;
import team3.swS.purchs.vo.OrdersVO;

public class OrdersService implements OrdersServiceInf {
	private OrdersDaoInf ordersDao;
	
	private static OrdersService service = new OrdersService();
	
	private  OrdersService() {
		ordersDao = OrdersDao.getInstace();
	}
	public static OrdersService getInstance() {
		return service;
	}
	@Override
	public int getOrders(OrdersVO orderVo) {
		
		return ordersDao.getOrders(orderVo);
		
	}
	@Override
	public int btnbuy(MemberJoinVo memVo) {
		return ordersDao.btnbuy(memVo);
	}
//	@Override
//	public int getDate(OrdersVO orderVo) {
//		return ordersDao.getDate(orderVo);
//	}
	@Override
	public int insertOrders(OrdersVO ordersVo) {
		return ordersDao.insertOrders(ordersVo);
	}
	@Override
	public List<ProdVO> getDate( ) {
		return ordersDao.getDate();
	}

}
