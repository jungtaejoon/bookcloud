package bookcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.ForTax;

@Mapper
public interface TaxMapper {

	public List<ForTax> getList(String year, String month); //list 타입 교체
}
