package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.OrdersDao;
import com.sys.model.Orders;

public class OrdersDaoImpl extends BaseDao implements OrdersDao {

	public OrdersDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addOders(Orders orders) throws SQLException {
		int num=0;
		String sql="insert into orders(orderID,o_InfoID,o_statusID,u_ID,o_beginTime"
				+ "o_money,o_add,o_name,o_phone) values(?,?,?,?,?,?,?,?)";
		Object[] params=new Object[9];
		params[0]=orders.getOrderID();
		params[1]=orders.getO_InfoID();
		params[2]=orders.getO_statusID();
		params[3]=orders.getU_ID();
		params[4]=orders.getO_beginTime();	
		params[5]=orders.getO_money();
		params[6]=orders.getO_add();
		params[7]=orders.getO_name();
		params[8]=orders.getO_phone();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int delOders(int orderID) throws SQLException {
		int num=0;
		String sql="delete from orders where orderID=?";
		Object[] params=new Object[1];
		params[0]=orderID;
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int updateOders(Orders orders) throws SQLException {
		int num=0;
		String sql="update orders set o_InfoID=?,o_statusID=?,u_ID=?,"
				+ "o_beginTime=?,o_money=?,o_add=?,o_name=?,o_phone"
				+ "where orderID =?";
		Object[] params=new Object[9];
		params[0]=orders.getO_InfoID();
		params[1]=orders.getO_statusID();
		params[2]=orders.getU_ID();
		params[3]=orders.getO_beginTime();	
		params[4]=orders.getO_money();
		params[5]=orders.getO_add();
		params[6]=orders.getO_name();
		params[7]=orders.getO_phone();
		params[8]=orders.getOrderID();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public List<Orders> getAllOders() throws SQLException {
		List<Orders> list=new ArrayList<Orders>();
		Orders orders=null;
		String sql="select orderID,o_InfoID,o_statusID,u_ID,o_beginTime"
				+ "o_money,o_add,o_name,o_phone from orders";
		ResultSet rs=super.executeQuery(sql);
		while(rs.next()) {
			orders=new Orders();
			orders.setOrderID(rs.getInt("orderID"));
			orders.setO_InfoID(rs.getInt("o_InfoID"));
			orders.setO_statusID(rs.getInt("o_statusID"));
			orders.setU_ID(rs.getInt("u_ID"));
			orders.setO_beginTime(rs.getString("o_beginTime"));
			orders.setO_money(rs.getDouble("o_money"));
			orders.setO_add(rs.getString("o_add"));
			orders.setO_name(rs.getString("o_name"));
			orders.setO_phone(rs.getString("o_phone"));
			list.add(orders);
		}
		return list;
	}

	@Override
	public Orders getOrdersInfo(int orderID) throws SQLException {
		Orders orders=null;
		String sql="select * from orders where orderID=?";
		Object[] params=new Object[1];
		params[0]=orderID;
		ResultSet rs=super.executeQuery(sql, params);
		while(rs.next()) {
			orders=new Orders();
			orders.setOrderID(rs.getInt("orderID"));
			orders.setO_InfoID(rs.getInt("o_InfoID"));
			orders.setO_statusID(rs.getInt("o_statusID"));
			orders.setU_ID(rs.getInt("u_ID"));
			orders.setO_beginTime(rs.getString("o_beginTime"));
			orders.setO_money(rs.getDouble("o_money"));
			orders.setO_add(rs.getString("o_add"));
			orders.setO_name(rs.getString("o_name"));
			orders.setO_phone(rs.getString("o_phone"));
		}
		return orders;
	}
   
}
