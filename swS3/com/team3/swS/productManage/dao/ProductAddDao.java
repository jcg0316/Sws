package team3.swS.productManage.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import team3.swS.productManage.vo.ProdVO;

public class ProductAddDao implements ProductAddDaoInf{
	
	private static ProductAddDao dao = new ProductAddDao();
	
		private SqlMapClient smc;
		
		private ProductAddDao() {
			try {
				Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
				smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static ProductAddDao getInstance() {
			return dao;
		}

	@Override
	public int insertProduct(ProdVO prodVo) {
		int cnt=0;
		try {
			Object obj = smc.insert("prod.prodInsert",prodVo);
			if(obj == null);
			cnt=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ProdVO> getAllProduct() {
		List<ProdVO> prodList = new ArrayList<ProdVO>();
		try {
			prodList= smc.queryForList("prod.getProductAll");
		} catch (SQLException e) {
			prodList = null;
			e.printStackTrace();
		}
		return prodList;
	}
	@Override
	public int updateProduct(ProdVO prodVo) {
		int cnt = 0;
		try {
			cnt = smc.update("prod.prodUpdate", prodVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteProduct(String voucher_no) {
		int cnt=0;
		try {
			cnt = smc.delete("prod.prodDelete", voucher_no);
			if(cnt>0){
				cnt=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
