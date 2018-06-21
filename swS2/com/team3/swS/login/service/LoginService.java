package team3.swS.login.service;

import java.util.List;

import team3.swS.login.dao.LoginDao;
import team3.swS.login.dao.LoginDaoInf;
import team3.swS.memJoin.vo.MemberJoinVo;

public class LoginService implements LoginServiceInf {
	
	private LoginDaoInf logDao;

	private static LoginService service = new LoginService();
	
	private LoginService() {
		logDao = LoginDao.getInstance();
	};
	
	public static LoginService getInstance() {
		return service;
	}
	
	@Override
	public MemberJoinVo getLoginData(MemberJoinVo mbj) {
		return logDao.getLoginData(mbj) ;
	}
	
}
