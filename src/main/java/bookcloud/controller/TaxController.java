package bookcloud.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bookcloud.dao.TaxDAO;
import bookcloud.dto.ForTax;
import bookcloud.service.XlsView;

@Controller
@RequestMapping(value="/tax/")
public class TaxController {
	
	@Autowired
	private PrePath pre;
	
	@Autowired
	private TaxDAO dao;
	
	@Autowired
	private Date date;

	@Autowired
	private FastDateFormat df;
	
	@RequestMapping(value="getlist")
	public String getList(Model model, HttpServletRequest request) {
		String year = null;
		String month = null;
		if(request.getParameter("tYear") == null || request.getParameter("tMonth") == null) {
			String now = df.format(date);
			year = now.split("-")[0];
			month = now.split("-")[1];
		}
		else {
			year = request.getParameter("tYear");
			month = request.getParameter("tMonth");
		}
		List<ForTax> list = dao.getList(year, month);
		int totalTaxPrice = 0;
		for(ForTax item : list) {
			totalTaxPrice += item.getTaxPrice();
		}
		model.addAttribute("list", list);
		model.addAttribute("totalTaxPrice", totalTaxPrice);
		return pre.getPATH_FOR_TAX() + "getTaxList";
	}
	
	@RequestMapping(value="getlisttoexcel")
	public ModelAndView getListToExcel(Model model, HttpServletRequest request) {
		String year = null;
		String month = null;
		if(request.getParameter("tYear") == null || request.getParameter("tMonth") == null) {
			String now = df.format(date);
			year = now.split("-")[0];
			month = now.split("-")[1];
		}
		else {
			year = request.getParameter("tYear");
			month = request.getParameter("tMonth");
		}
		List<ForTax> list = dao.getList(year, month);
		return new ModelAndView(new XlsView(), "list", list);
	}

}
