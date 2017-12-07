package com.yh.st.web.controller;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.base.controller.BaseController;
import com.yh.st.base.domain.News;
import com.yh.st.base.service.NewsService;
import com.yh.st.base.service.NoticeService;
import com.yh.st.common.util.poi.CommonExcel;

/**
 * 我的工作台
 * 
 * @author yh
 * @Date 2017年11月28日
 * @desc
 */
@Controller
@RequestMapping("work")
public class WorkController extends BaseController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private NewsService newsService;

	/**
	 * 公告列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("noticeListView")
	public String noticeList() {
		return "work/notice-list";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("noticeListData")
	@ResponseBody
	public Object noticeListData(HttpServletRequest request) {
		return noticeService.queryNotice(getParams(request), getPageNum(request), pageSize);
	}

	/**
	 * 取未读消息数量
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("messageNum")
	@ResponseBody
	public Object messageNum(long userId) {
		return noticeService.countMessageNumByUserId(userId);
	}

	/**
	 * 公告添加
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("notice/add")
	public String noticeAdd() {
		return "work/notice-add";
	}

	/**
	 * 新闻列表
	 * 
	 * @return
	 */
	@RequestMapping("newsView")
	public String newsView() {
		return "work/news-list";
	}

	// TODO excel导入
	// @RequestMapping(value = "/importEmployee")
	// public void uploadExcel(@RequestParam("file") MultipartFile file,
	// HttpServletRequest request) {
	// try {
	// CommonExcel excel = new CommonExcel();
	// List<Object> employeeDTOList = excel.importExcel(Test.class,
	// file.getInputStream());
	// // 可做持久化操作，现只打印观察
	// for (Object employeeDTO : employeeDTOList) {
	// System.out.println(((Test) employeeDTO).toString());
	// }
	// } catch (Exception e) {
	// }
	// }

	@RequestMapping("excelNews")
	public void excelNews(HttpServletResponse response) {
		try {
			response.setContentType("application/xls");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(("eeelist").getBytes("UTF-8"), "iso-8859-1") + ".xls");
			CommonExcel base = new CommonExcel();
			Map<String, Object> params = new HashMap<String, Object>();
			BufferedInputStream input = new BufferedInputStream(base.excelModelbyClass(News.class,
					newsService.queryNews(params, 1, 100).getList()));
			byte buffBytes[] = new byte[1024];
			OutputStream os = response.getOutputStream();
			int read = 0;
			while ((read = input.read(buffBytes)) != -1) {
				os.write(buffBytes, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
