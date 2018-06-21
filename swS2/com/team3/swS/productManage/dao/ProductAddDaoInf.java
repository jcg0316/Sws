package team3.swS.productManage.dao;

import java.util.List;

import team3.swS.productManage.vo.ProdVO;

public interface ProductAddDaoInf {
	
	
	public int insertProduct(ProdVO prodVo);
	
	public List<ProdVO> getAllProduct();
	
	public int updateProduct(ProdVO prodVo);
	
	public int deleteProduct(String voucher_no);
}
