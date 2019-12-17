package org.lhasalimited.etransafe.wp6.clinical.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexStudy;

@Mapper
public interface StudyMapper {

	IndexStudy selectByPrimaryKey(Integer id);

	List<IndexStudy>  selectAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();

}