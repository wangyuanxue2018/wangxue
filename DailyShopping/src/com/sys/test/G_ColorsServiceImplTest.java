package com.sys.test;

import java.util.List;

import com.sys.model.G_Colors;
import com.sys.service.G_ColorsService;
import com.sys.serviceImpl.G_ColorsServiceImpl;

/**
 * 商品颜色业务层测试
 * 
 * @author Administrator
 *
 */
public class G_ColorsServiceImplTest {

	public static void main(String[] args) {
		// addG_Colors();
		delG_Colors();
		// updateG_Colors();
		// queryG_Colors();
	}

	public static void addG_Colors() {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		int num = g_ColorsService.addG_Colors("绿66色");
		if (num == 1) {
			System.out.println("添加颜色成功");
		} else {
			System.out.println("添加颜色失败");
		}
	}

	public static void delG_Colors() {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		int num = g_ColorsService.delG_Colors("绿66色");
		if (num == 1) {
			System.out.println("删除颜色成功");
		} else {
			System.out.println("删除颜色失败");
		}
	}

	public static void updateG_Colors() {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		int num = g_ColorsService.updateG_Colors(6, "呼呼");
		if (num == 1) {
			System.out.println("修改颜色成功");
		} else {
			System.out.println("修改颜色失败");
		}
	}

	public static void queryG_Colors() {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		List<G_Colors> list = g_ColorsService.queryG_Colors();
		for (G_Colors g_Colors : list) {
			System.out.println(g_Colors);
		}
	}
}
