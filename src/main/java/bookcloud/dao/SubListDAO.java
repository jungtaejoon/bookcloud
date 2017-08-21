package bookcloud.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.Sales;
import bookcloud.mapper.SubListMapper;

@Component
public class SubListDAO {
	
	@Autowired
	private SubListMapper mapper; //mapper 클래스 교체

	public List<Map<String, Object>> getBookSubList() {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getBookSubList();
	}

	public List<Map<String, Object>> getBookStoreSubList() {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getBookStoreSubList();
	}

	public List<Sales> getSalesSubList() {
		// TODO Auto-generated method stub
		return mapper.getSalesSubList();
	}

	public List<Map<String, Object>> getPeriodList(Map<String, Object> parseMap) {
		// TODO Auto-generated method stub
		return mapper.getPeriodList(parseMap);
	}
}
