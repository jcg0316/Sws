package team3.swS.productManage.service;

import java.util.List;

import team3.swS.productManage.vo.ProdVO;

public interface ProductAddServiceInf {

	public int insertProduct(ProdVO prodVo);
	
	public List<ProdVO> getAllProduct();
	
	public int updateProduct(ProdVO prodVo);
	
	public int deleteProduct(String voucher_no);
}
