package bookcloud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.Sales;
import bookcloud.mapper.SalesMapper;

@Component
public class SalesDAO {
	
	@Autowired
	private SalesMapper mapper; //mapper 클래스 교체

	public boolean insert(Sales dto) { //dto 클래스 교체
		// TODO Auto-generated method stub
		boolean b = false;
		int a = mapper.insert(dto);
		if(a == 1) b = true;
		return b;

	}

	public List<Sales> getList() {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getList();
	}
}
