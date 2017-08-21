package bookcloud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.Book;
import bookcloud.mapper.BookMapper;

@Component
public class BookDAO {
	
	@Autowired
	private BookMapper mapper; //mapper 클래스 교체

	public boolean insert(Book dto) { //dto 클래스 교체
		// TODO Auto-generated method stub
		boolean b = false;
		int a = mapper.insert(dto);
		if(a == 1) b = true;
		return b;

	}

	public List<Book> getList() {  //list 타입 교체
		// TODO Auto-generated method stub
		return mapper.getList();
	}
}
