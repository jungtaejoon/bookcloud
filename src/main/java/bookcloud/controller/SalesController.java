package bookcloud.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bookcloud.dao.SalesDAO;
import bookcloud.dto.Sales;

@Controller
@RequestMapping(value="/sales/") //부모 requestmapping 교체
public class SalesController {
	
	@Autowired
	private PrePath pre;
	
	@Autowired
	private SalesDAO dao; //dao 클래스 교체
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@RequestMapping("insertform")
	public String insertForm() { 
		return pre.getPATH_FOR_SALES() + "salesInsertForm"; //view 교체
	}
	
	@RequestMapping("insert")
	public String insert(@Valid Sales dto, Errors errors, Model model) { //dto 클래스 교체
		if(errors.hasErrors()) {
			model.addAttribute("salesInsertError", true);
			return pre.getPATH_FOR_SALES() + "salesInsertForm"; //view 교체
		}
		if(dao.insert(dto)) return pre.getPATH_FOR_SALES() + "salesInsertForm";
		return pre.getPATH_FOR_SALES() + "salesInsertForm"; //view 교체
	}
	
	@RequestMapping("getlist")
	public String getList(Model model) {
		return pre.getPATH_FOR_SALES() + "getSalesList"; //view 교체
	}

}
