package bookcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.Book;

@Mapper
public interface BookMapper {
	public int insert(Book dto); //dto 클래스 교체

	public List<Book> getList(); //list 타입 교체
}
