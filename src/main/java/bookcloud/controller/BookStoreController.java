package bookcloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bookcloud.dao.BookStoreDAO;
import bookcloud.dto.BookStore;

@Controller
@RequestMapping(value="/bookstore/")
public class BookStoreController {
	
	@Autowired
	private PrePath pre;
	
	@Autowired
	private BookStoreDAO dao;

	@RequestMapping("insertform")
	public String bookStoreInsertForm() {
		return pre.getPATH_FOR_BOOKSTORE() + "bookStoreInsertForm";
	}
	
	@RequestMapping("insert")
	public String bookStoreInsert(@Valid BookStore dto, Errors errors) {
		if(errors.hasErrors()) return pre.getPATH_FOR_BOOKSTORE() + "bookStoreInsertForm";
		if(dao.insert(dto)) return "home";
		return pre.getPATH_FOR_BOOKSTORE() + "bookStoreInsertForm";
	}
	
	@RequestMapping("getlist")
	public String getBookStoreList(Model model) {
		model.addAttribute("list", dao.getList());
		return pre.getPATH_FOR_BOOKSTORE() + "getBookStoreList";
	}
	
}

