package com.example.demo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface DictMapper {

	 @Insert("insert into t_dict(dict_id,type,code,value) value(#{dict_id},#{type},#{code},#{value})")
	 int insertDict(@Param("dict_id")Long dictId,@Param("type")String type, @Param("code")String code,@Param("value")String value);
	 
	 @Select("select * from t_dict where dict_id = #{dict_id}")
	 Map<String,Object> selectDictById(@Param("dict_id")Long dictId);
	 
	 
	 @Select("select * from t_dict")
	 List<Map<String,Object>> selectDictList();
}
