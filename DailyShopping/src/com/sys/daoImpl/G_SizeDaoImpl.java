package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_SizeDao;
import com.sys.model.G_Size;
import com.sys.util.JDBCUtil;

public class G_SizeDaoImpl extends BaseDao implements G_SizeDao {

	public G_SizeDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_Size(String G_Size) {
		String sql = "INSERT INTO g_Size (g_size) VALUES (?)";
		return super.executeUpdate(sql, G_Size);
	}

	@Override
	public int delG_Size(String G_Size) {
		String sql = "DELETE FROM  g_Size WHERE G_Size=?";
		return super.executeUpdate(sql, G_Size);
	}

	@Override
	public int updateG_Size(int g_sizeID, String G_Size) {
		String sql = "UPDATE g_Size set G_Size=? WHERE g_sizeID=?";
		return super.executeUpdate(sql, G_Size, g_sizeID);
	}

	@Override
	public List<G_Size> queryG_Size() {
		String sql = "SELECT g_sizeID,g_size FROM g_Size";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_Size> list = new ArrayList<G_Size>();
		G_Size g_Size = null;
		try {
			while (resultSet.next()) {
				g_Size = new G_Size();
				g_Size.setG_sizeID(resultSet.getInt("g_sizeID"));
				g_Size.setG_size(resultSet.getString("g_size"));
				list.add(g_Size);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public G_Size getG_SizeByid(int g_sizeID) {
		String sql = "SELECT g_sizeID,g_size FROM g_Size WHERE g_sizeID = ?;";
		G_Size g_size = new G_Size();
		ResultSet rs = super.executeQuery(sql, g_sizeID);
		try {
			while (rs.next()) {
				g_size.setG_sizeID(rs.getInt("g_sizeID"));
				g_size.setG_size(rs.getString("g_size"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return g_size;
	}

}
