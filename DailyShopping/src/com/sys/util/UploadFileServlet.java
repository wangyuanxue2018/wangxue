package com.sys.util;

/**
 * 上传数据 从本地上传到数据库（图片。文件夹~~）的后台连接类   文件目录的解密（解析）
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sys.model.G_Colors;
import com.sys.model.G_Size;
import com.sys.model.G_rank;
import com.sys.model.G_son;
import com.sys.model.G_sort1;
import com.sys.model.G_sort2;
import com.sys.model.Goods;
import com.sys.service.G_ColorsService;
import com.sys.service.G_SizeService;
import com.sys.service.G_rankService;
import com.sys.service.G_sonService;
import com.sys.service.G_sort1Service;
import com.sys.service.G_sort2Service;
import com.sys.service.GoodsService;
import com.sys.serviceImpl.G_ColorsServiceImpl;
import com.sys.serviceImpl.G_SizeServiceImpl;
import com.sys.serviceImpl.G_rankServiceImpl;
import com.sys.serviceImpl.G_sonServiceImpl;
import com.sys.serviceImpl.G_sort1ServiceImpl;
import com.sys.serviceImpl.G_sort2ServiceImpl;
import com.sys.serviceImpl.GoodsServiceImpl;

@WebServlet("/file.do")
public class UploadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		// String savePath =
		// this.getServletContext().getRealPath("/WEB-INF/upload");
		String savePath = "C:/dailyShopping_images";
		// 上传时生成的临时文件保存目录（缓存：如果一个文件很大 ，不可能一下就上传完的，就需要一个零时的 文件做缓存）
		// String tempPath =
		// this.getServletContext().getRealPath("/WEB-INF/temp");
		String tempPath = "C:/dailyShopping_images/temp";
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}

		// 消息提示（上传，下载 成功，失败 提示）
		String message = "";
		Connection conn = null;
		int g_ID = 0;
		int G_sort1ID = 0;
		int G_sort2ID = 0;
		int g_sonID = 0;
		int g_colorsID = 0;
		int g_sizeID = 0;
		int g_integral = 0;
		double g_g_price = 0.0;
		String g_src = null;
		int g_rankID = 0;
		String filename = null;
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
			// 设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 监听文件上传进度
			/*
			 * upload.setProgressListener(new ProgressListener() { public void update(long
			 * pBytesRead, long pContentLength, int arg2) { System.out.println("文件大小为：" +
			 * pContentLength + ",当前已处理：" + pBytesRead);
			 *//**
				 * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367 文件大小为：14608,当前已处理：11419
				 * 文件大小为：14608,当前已处理：14608
				 *//*
					 * } });
					 */
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}

			// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
			upload.setFileSizeMax(1024 * 1024);
			// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024 * 1024 * 10);
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);

			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					if ("g_ID".equals(name)) {
						g_ID = Integer.parseInt(value);
					} else if ("G_sort1ID".equals(name)) {
						G_sort1ID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					} else if ("G_sort2ID".equals(name)) {
						G_sort2ID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					} else if ("g_sonID".equals(name)) {
						g_sonID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					} else if ("g_colorsID".equals(name)) {
						g_colorsID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					} else if ("g_sizeID".equals(name)) {
						g_sizeID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					} else if ("g_integral".equals(name)) {
						g_integral = Integer.parseInt(value);
					} else if ("g_g_price".equals(name)) {
						g_g_price = Double.valueOf(value);
					} else if ("g_src".equals(name)) {
						g_src = value;
					} else if ("g_rankID".equals(name)) {
						g_rankID = Integer.parseInt(value.substring(0, value.indexOf(" ")));// 拆分字符串
					}
				} else {// 如果fileitem中封装的是上传文件
						// 得到上传的文件名称，
					filename = item.getName();
					// System.out.println("上传图片名" + filename + "!!!");
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					// 得到上传文件的扩展名
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
					// System.out.println("上传的文件的扩展名是：" + fileExtName);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 得到文件保存的名称
					g_src = makeFileName(filename);
					// 得到文件的保存目录
					String realSavePath = makePath(g_src, savePath);
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(realSavePath + "\\" + g_src);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					// item.delete();
					message = "文件上传成功！";
				}
			}
			// 添加商品数据
			Goods goods = new Goods();
			// goods.setG_ID(g_ID);
			goods.setG_colorsID(g_colorsID);
			goods.setG_g_price(g_g_price);
			goods.setG_integral(g_integral);
			goods.setG_rankID(g_rankID);
			goods.setG_sizeID(g_sizeID);
			goods.setG_sonID(g_sonID);
			goods.setG_sort1ID(G_sort1ID);
			goods.setG_sort2ID(G_sort2ID);
			goods.setG_src(g_src);
			conn = JDBCUtil.getConnection();
			GoodsService goodsService = new GoodsServiceImpl();
			int num = goodsService.addGoods(goods);
			if (num == 1) {
				// System.out.println("添加商品成功");
			} else {
				// System.out.println("添加商品失败");
			}

		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "单个文件超出最大值！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			message = "文件上传失败！";
			e.printStackTrace();
		}
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		G_rankService g_rankService = new G_rankServiceImpl();
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		List<G_Colors> listG_Colors = g_ColorsService.queryG_Colors();
		List<G_rank> listG_rank = g_rankService.queryG_rank();
		List<G_Size> listG_Size = g_SizeService.queryG_Size();
		List<G_son> listG_son = g_sonService.queryG_son();
		List<G_sort1> listG_sort1 = G_sort1Service.queryG_sort1();
		List<G_sort2> listG_sort2 = G_sort2Service.queryG_sort2();
		request.setAttribute("listG_Colors", listG_Colors);
		request.setAttribute("listG_rank", listG_rank);
		request.setAttribute("listG_Size", listG_Size);
		request.setAttribute("listG_son", listG_son);
		request.setAttribute("listG_sort1", listG_sort1);
		request.setAttribute("listG_sort2", listG_sort2);
		g_ID++;
		request.setAttribute("g_ID", g_ID);
		// System.out.println(message);
		request.getRequestDispatcher("addGoods.jsp?g_ID=" + g_ID).forward(request, response);
	}

	// 生成随机文件名
	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @param filename
	 *            文件的原始名称
	 * @return uuid+"_"+文件的原始名称
	 */
	private String makeFileName(String filename) { // 2.jpg
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}

	// 生成随机目录名
	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储：主要防止一个目录下同名（同一个用户，不能有同名的）
	 * 
	 * @Method: makePath
	 * @param filename
	 *            文件名，要根据文件名生成存储目录
	 * @param savePath
	 *            文件存储路径
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		// 构造新的保存目录
		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}