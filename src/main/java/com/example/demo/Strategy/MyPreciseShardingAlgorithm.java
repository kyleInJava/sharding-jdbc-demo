package com.example.demo.Strategy;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
	
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		
		for (String name : availableTargetNames) {
			//订单号取模 与 订单表t_order_1 和 t_order_2的尾号做比对，如相等，就直接返回t_order_1 或 t_order_2
			if (name.endsWith(String.valueOf(shardingValue.getValue() % 2))) {
				return name;
			}
		}
		return null;
	}
}