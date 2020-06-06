package com.example.demo.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertOrder(){
        for(int i=0;i<10;i++){
        	userMapper.insertUser(1L+i,"stan"+i,"1");
        }
    }
    
    @Test
    public void testSelectUserById(){
    	Map<String, Object> map = userMapper.selectUserById(1L);
    	System.out.println(map);
    }
    
    @Test
    public void testSelectUserList(){
    	List<Long> userIds = Arrays.asList(1L,2L);
    	List<Map<String, Object>> list = userMapper.selectUserList(userIds);
    	System.out.println(list);
    }
}