package com.example.demo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

	 @Insert("insert into t_user(user_id,fullname,user_type) value(#{user_id},#{fullname},#{user_type})")
	 int insertUser(@Param("user_id")Long userId,@Param("fullname")String fullname, @Param("user_type")String userType);
	 
	 @Select("select * from t_user where user_id = #{user_id}")
	 Map<String,Object> selectUserById(@Param("user_id")Long userId);
	 
	 @Select("<script>"
			 +"select * "
	 		 +"from t_user as tu "
			 +"inner join t_dict as td on td.type = 'user_type' and td.code = tu.user_type "
			 +"where tu.user_id in "
			 +"<foreach collection='user_ids' item='id' open='(' separator=',' close=')'> "
			 +  " #{id} "
			 +"</foreach>"
			 +"</script>")
	 List<Map<String,Object>> selectUserList(@Param("user_ids")List<Long> userIds);
}
