package bookcloud.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookcloud.dao.SubListDAO;

@Controller
@RequestMapping(value="/sublist/")
public class SubListController {
	
	@Autowired
	private SubListDAO subDao; //표준이 아니다.
	
	@RequestMapping("getbookstorelist")
	public @ResponseBody List<Map<String, Object>> getBookStoreList() {
		List<Map<String, Object>> list = subDao.getBookStoreSubList();
		return list;
	}
	
	@RequestMapping("getbooklist")
	public @ResponseBody List<Map<String, Object>> getBookList() {
		List<Map<String, Object>> list = subDao.getBookSubList();
		return list;
	}

	@RequestMapping("getperiodlist")
	public @ResponseBody List<Map<String, Object>> getPeriodList(HttpServletRequest request) {
		Enumeration<String> e = request.getParameterNames();
		String reqName = e.nextElement();
		JacksonJsonParser jack = new JacksonJsonParser();
		List<Map<String, Object>> list = subDao.getPeriodList(jack.parseMap(reqName));
		return list;	
	}
}
