package com.example.demo.generic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunqi
 *
 * 2020年9月8日
 */
public class AConfigHolder {
	
private final Map<AConfigTypeEnum, AIConfig<?>> map = new ConcurrentHashMap<>();
	
	public AIConfig<?> getConfig(AConfigTypeEnum templateType){
		return map.get(templateType);
	}
	
	public void add(AConfigTypeEnum type, AIConfig<?> template){
		this.map.put(type, template);
	}

	public Map<AConfigTypeEnum, AIConfig<?>> getMap() {
		return map;
	}
	
}
