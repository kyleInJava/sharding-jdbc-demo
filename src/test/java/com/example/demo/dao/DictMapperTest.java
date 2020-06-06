package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DictMapperTest {

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void TestinsertDict(){
    	dictMapper.insertDict(1L, "user_type", "0", "超级管理员");
    	dictMapper.insertDict(2L, "user_type", "1", "普通员工");
    }
    
    @Test
    public void TestSelectDictById(){
    	Map<String, Object> map = dictMapper.selectDictById(1L);
    	System.out.println(map);
    }
    
    @Test
    public void TestSelectDictList(){
    	List<Map<String, Object>> list = dictMapper.selectDictList();
    	System.out.println(list);
    }
}