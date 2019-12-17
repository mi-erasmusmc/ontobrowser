package org.lhasalimited.etransafe.wp6.clinical.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexFinding;

@Mapper
public interface FindingMapper {

	IndexFinding selectByPrimaryKey(Integer id);

	List<IndexFinding>  selectAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();

}