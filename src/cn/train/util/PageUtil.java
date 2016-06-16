package cn.train.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息辅助类
 * 
 * @author hp
 * 
 */
@SuppressWarnings("all")
public class PageUtil {

	private List list = new ArrayList();

	private Page page = new Page();

	public void buildPage(int currentPage, List list, Integer recordNum) {

		this.list = list;

		page.setTotalCount(recordNum);
		// 计算总页数
		page.setTotalPage((page.getTotalCount() % page.getPageSize() == 0) ? page
				.getTotalCount() / page.getPageSize()
				: (page.getTotalCount() / page.getPageSize()) + 1);

		//
		// 判断上一页
		if (currentPage == 1) {
			page.setPrePage(1);
		} else {
			page.setPrePage(currentPage - 1);
		}
		// 判断下一页
		if (currentPage == page.getTotalPage()) {
			page.setNextPage(currentPage);
		} else {
			page.setNextPage(currentPage + 1);
		}
		page.setEndPage(page.getTotalPage());
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
