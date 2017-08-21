package bookcloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bookcloud.dao.BookDAO;
import bookcloud.dto.Book;

@Controller
@RequestMapping(value="/book/")
public class BookController {
	
	@Autowired
	private PrePath pre;
	
	@Autowired
	private BookDAO dao;

	@RequestMapping("insertform")
	public String insertForm() {
		return pre.getPATH_FOR_BOOK() + "bookInsertForm";
	}
	
	@RequestMapping("insert")
	public String insert(@Valid Book dto, Errors errors) {
		if(errors.hasErrors()) return pre.getPATH_FOR_BOOK() + "bookInsertForm";
		if(dao.insert(dto)) return "home";
		return pre.getPATH_FOR_BOOK() + "bookInsertForm";
	}
	
	@RequestMapping("getlist")
	public String getList(Model model) {
		model.addAttribute("list", dao.getList());
		return pre.getPATH_FOR_BOOK() + "getBookList";
	}
	
}
