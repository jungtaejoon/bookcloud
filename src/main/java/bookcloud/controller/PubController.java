package bookcloud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bookcloud.dao.PubDAO;
import bookcloud.dto.Pub;

@Controller
@RequestMapping(value="/pub/")
public class PubController {
	
	@Autowired
	private PrePath pre;
	
	@Autowired
	private PubDAO dao;

	@RequestMapping("insertform")
	public String insertForm() {
		return pre.getPATH_FOR_PUB() + "pubInsertForm";
	}
	
	@RequestMapping("insert")
	public String insert(@Valid Pub dto, Errors errors) {
		if(errors.hasErrors()) return pre.getPATH_FOR_PUB() + "pubInsertForm";
		if(dao.insert(dto)) return "home";
		return pre.getPATH_FOR_PUB() + "pubInsertForm";
	}
	
	@RequestMapping("getlist")
	public String getList(Model model) {
		List<Pub> list = dao.getList();
		model.addAttribute("list", list);
		return pre.getPATH_FOR_PUB() + "getPubList";
	}
	
}
