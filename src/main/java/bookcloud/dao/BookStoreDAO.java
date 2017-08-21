package bookcloud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bookcloud.dto.BookStore;
import bookcloud.mapper.BookStoreMapper;

@Component
public class BookStoreDAO {

	@Autowired
	private BookStoreMapper mapper;

	public boolean insert(BookStore dto) {
		// TODO Auto-generated method stub
		boolean b = false;
		int a = mapper.insert(dto);
		if(a == 1) b = true;
		return b;

	}

	public List<BookStore> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

}
