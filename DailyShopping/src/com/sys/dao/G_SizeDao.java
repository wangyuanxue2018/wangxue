package com.sys.dao;

/**
 * 商品规格刀层接口
 */
import java.util.List;

import com.sys.model.G_Size;

public interface G_SizeDao {
	/**
	 * 添加商品规格
	 */
	int addG_Size(String G_Size);

	/**
	 * 删除商品规格
	 * 
	 */
	int delG_Size(String g_Size);

	/**
	 * 修改商品规格
	 */
	int updateG_Size(int g_sizeID, String g_Size);

	/**
	 * 查询所有商品规格
	 */
	List<G_Size> queryG_Size();

	/**
	 * 查询指定商品规格
	 */
	G_Size getG_SizeByid(int g_sizeID);
}
