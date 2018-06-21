package team3.swS.productManage.service;

import java.util.List;

import team3.swS.productManage.dao.ProductAddDao;
import team3.swS.productManage.dao.ProductAddDaoInf;
import team3.swS.productManage.vo.ProdVO;

public class ProductAddService implements ProductAddServiceInf{
	private ProductAddDaoInf prodDao;
	
	private static ProductAddService service= new ProductAddService();
	
	private  ProductAddService() {
		prodDao= ProductAddDao.getInstance();
	}

	public static ProductAddService getInstance() {
		return service;
	}
	@Override
	public int insertProduct(ProdVO prodVo) {
		return prodDao.insertProduct(prodVo);
	}

	@Override
	public List getAllProduct() {
		return prodDao.getAllProduct();
	}

	@Override
	public int updateProduct(ProdVO prodVo) {
		return prodDao.updateProduct(prodVo) ;
	}

	@Override
	public int deleteProduct(String voucher_no) {
		return prodDao.deleteProduct(voucher_no);
	}

	
}
