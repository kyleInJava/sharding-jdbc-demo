package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Order;

@Mapper
public interface OrderMapper {
	
	 /**
     * 新增订单
     * @param price 订单价格
     * @param userId 用户id
     * @param status 订单状态
     * @return
     */
    @Insert("insert into t_order(price,user_id,status) value(#{price},#{userId},#{status})")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId")Long userId, @Param("status")String status);
    
    /**
     * 新增订单2 
     * @param price 订单价格
     * @param userId 用户id
     * @param status 订单状态
     * @return
     */
    @Insert("insert into t_order(price,user_id,status) value(#{price},#{userId},#{status})")
    @Options(useGeneratedKeys=true,keyProperty="orderId",keyColumn="order_id")
    int insertOrder2(Order order);
    
    /**
     * 根据orderId查询单个订单
     * @param id
     * @return
     */
    @Select("select * from t_order where order_id = #{orderId}")
    Map<String,Object> selectOrderByOrderId(@Param("orderId")Long orderId);
    
    /**
     * 根据userId查询单个订单
     * @param userId
     * @return
     */
    @Select("select * from t_order where t_order.user_id = #{userId}")
    List<Map<String,Object>> selectOrderByUserId(@Param("userId")Long userId);

    /**
     * 根据id列表查询多个订单
     * @param orderIds 订单id列表
     * @return
     */
    @Select({"<script>" +
            "select " +
            " * " +
            " from t_order t" +
            " inner join t_order_item as toi on t.order_id = toi.order_id "+
            " where t.order_id in " +
            "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
            " #{id} " +
            "</foreach>"+
            "</script>"})
    List<Map<String,Object>> selectOrderbyIds(@Param("orderIds")List<Long> orderIds);
    
    /**
     * 插入订单描述信息
     */
    @Insert("insert into t_order_item(order_id,user_id,order_description) value(#{orderId},#{userId},#{orderDescription})")
    int insertOrderItem(@Param("orderId")Long orderId,@Param("userId")Long userId, @Param("orderDescription")String orderDescription);

}
