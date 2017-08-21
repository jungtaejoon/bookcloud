package bookcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import bookcloud.dto.User;
//import bookcloud.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private PrePath pre;
//	@Autowired
//	private UserService userService;
	
//	@RequestMapping("createUserForm")
//	public String createUserForm() {
//		return "createUserForm";
//	}
	
//	@RequestMapping("createUser")
//	public String createUser(User user) {
//		userService.createUser(user);
//		return "home";
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return pre.getPATH_FOR_BOOKCLOUDHOME() + "index";
	}
	
	@RequestMapping("left-sidebar")
	public String leftsidebar() {
		return "bookcloudHome/left-sidebar";
	}

	@RequestMapping("right-sidebar")
	public String right_sidebar() {
		return "bookcloudHome/right-sidebar";
	}
	
	@RequestMapping("no-sidebar")
	public String no_sidebar() {
		return "bookcloudHome/no-sidebar";
	}
	
	@RequestMapping("elements")
	public String elements() {
		return "bookcloudHome/elements";
	}
	
	// Login form
	@RequestMapping("login")
	public String login() {
		return "loginForm";
	}

	// Login form with error
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "loginForm";
	}

	@RequestMapping(value="header", method = RequestMethod.GET)
	public String header() {
		return "header";
	}
	
	@RequestMapping("createUserForm")
	public String createUserForm() {
		return "createUserForm";
	}
	
	
}
