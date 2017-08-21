package bookcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bookcloud.dto.Pub;

@Mapper
public interface PubMapper {
	public int insert(Pub dto); //dto 클래스 교체

	public List<Pub> getList(); //list 타입 교체
}
