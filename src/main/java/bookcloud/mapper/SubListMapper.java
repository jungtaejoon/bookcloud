package bookcloud.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.Sales;

@Mapper
public interface SubListMapper {
	public List<Map<String, Object>> getBookSubList();

	public List<Map<String, Object>> getBookStoreSubList();

	public List<Sales> getSalesSubList();

	public List<Map<String, Object>> getPeriodList(Map<String, Object> parseMap);
}
