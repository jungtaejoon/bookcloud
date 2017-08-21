package bookcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.BookStore;

@Mapper
public interface BookStoreMapper {
	public int insert(BookStore dto);

	public List<BookStore> getList();
}
