package bookcloud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.ForTax;
import bookcloud.mapper.TaxMapper;

@Component
public class TaxDAO {
	
	@Autowired
	private TaxMapper mapper; //mapper 클래스 교체

	public List<ForTax> getList(String year, String month) {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getList(year, month);
	}
}
