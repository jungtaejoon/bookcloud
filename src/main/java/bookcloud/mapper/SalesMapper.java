package bookcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.Sales;

@Mapper
public interface SalesMapper {
	public int insert(Sales dto); //dto 클래스 교체

	public List<Sales> getList(); //list 타입 교체
}
