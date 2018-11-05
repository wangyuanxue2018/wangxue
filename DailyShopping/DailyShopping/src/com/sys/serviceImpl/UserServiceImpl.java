package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.UserDao;
import com.sys.daoImpl.UserDaoImpl;
import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.util.JDBCUtil;

public class UserServiceImpl implements UserService{
	
	@Override
	public User getLogin(User user) {
		User user1 = null;
		Connection conn = null;
		try {
			conn =JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			List<User> list=userDao.getLogin();
			for(User u:list){
				if(u.getU_loginName().equals(user.getU_loginName())){
					user1 = new User();
					user1 = u;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return user1;
	}

}
