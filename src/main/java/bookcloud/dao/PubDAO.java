package bookcloud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.Pub;
import bookcloud.mapper.PubMapper;

@Component
public class PubDAO {
	
	@Autowired
	private PubMapper mapper; //mapper 클래스 교체

	public boolean insert(Pub dto) { //dto 클래스 교체
		// TODO Auto-generated method stub
		boolean b = false;
		int a = mapper.insert(dto);
		if(a == 1) b = true;
		return b;

	}

	public List<Pub> getList() {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getList();
	}
}
