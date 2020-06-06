package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsertOrder(){
        for(int i=1;i<11;i++){
        	orderMapper.insertOrder(new BigDecimal(i),8L,"SUCCESS");
        }
        for(int i=1;i<11;i++){
        	orderMapper.insertOrder(new BigDecimal(i),9L,"SUCCESS");
        }
    }
    
    @Test
    public void testInsertOrder2(){
		Order order = new Order();
		order.setPrice(new BigDecimal(12));
		order.setUserId(5L);
		order.setStatus("FAIL");
		orderMapper.insertOrder2(order);
		orderMapper.insertOrderItem(order.getOrder_id(),order.getUserId(), "描述");
    }
    
    @Test
    public void testSelectOrderByOrderId(){
    	Map<String, Object> map = orderMapper.selectOrderByOrderId(416155899472642049L);
    	System.out.println(map);
    }
    
    @Test
    public void testSelectOrderByUserId(){
    	List<Map<String,Object>> map = orderMapper.selectOrderByUserId(3L);
    	System.out.println(map);
    }
    
    @Test
    public void testSelectOrderbyIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(416200108556681216L);
        ids.add(416200108527321089L);
        ids.add(416200107516493824L);
        ids.add(416200107575214081L);
        List<Map<String,Object>> maps = orderMapper.selectOrderbyIds(ids);
        System.out.println(maps);
    }
    
}