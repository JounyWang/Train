package cn.train.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;

import cn.train.dao.TrainDAO;
import cn.train.entity.Train;
import cn.train.util.Page;
import cn.train.util.PageUtil;

@Controller
public class TrainController {
	@Resource(name = "trainDAO")
	TrainDAO traindao;

	public TrainDAO getTraindao() {
		ContextLoaderListener ccc;
		return traindao;
	}

	public void setTraindao(TrainDAO traindao) {
		this.traindao = traindao;
	}

	/**
	 * 显示全部列车信息
	 * 
	 * @param request
	 * @param page
	 * @param trainNumber
	 * @return
	 */
	@RequestMapping("/trainList")
	public String getTrain(HttpServletRequest request, Page page,
			String trainNumber) {
		try {
			request.setCharacterEncoding("UTF-8");
			PageUtil pu = new PageUtil();
			List<Train> listss = traindao.getAlltrain(page, trainNumber);
			int recordNum = traindao.getCount();
			pu.buildPage(page.getCurrentPage(), listss, recordNum);
			HttpSession session = request.getSession();
			session.setAttribute("trainNumber", trainNumber);
			session.setAttribute("recordNum", recordNum);
			session.setAttribute("pu", pu);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "TrainList";
	}

	/**
	 * 修改单个列车信息
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Train train) {
		try {
			traindao.update(train);
			return "redirect:trainList";

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:trainList";
		}
	}

	/**
	 * 添加列车信息
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request, Train train) {
		return "addTrain";
	}

	@RequestMapping("/addTrain")
	public String addTrain(HttpServletRequest request, Train train) {
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
			traindao.add(train);
			return "redirect:trainList";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("REGSTATE", "添加失败");
			return "redirect:trainList";
		}
	}

	/**
	 * 显示单个列车详细信息
	 * 
	 * @param train
	 * @param request
	 * @return
	 */
	@RequestMapping("/find")
	public String find(Train train, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Train tt = traindao.find(train);
			session.setAttribute("tt", tt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Train";
	}

	/**
	 * 删除单个列车
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@RequestMapping("/delTrain")
	public String delTrain(HttpServletRequest request, Train train) {
		HttpSession session = request.getSession();
		try {
			traindao.del(train);
			return "redirect:trainList";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("REGSTATE", "添加失败");
			return "redirect:trainList";
		}
	}

	/**
	 * 删除多条列车信息
	 * 
	 * @param request
	 * @param array
	 * @return
	 */
	@RequestMapping("/delAll")
	public String delAll(HttpServletRequest request, String array) {
		String[] arr = array.split(",");
		try {
			traindao.delAll(arr);
			return "redirect:trainList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:trainList";
		}
	}
}
