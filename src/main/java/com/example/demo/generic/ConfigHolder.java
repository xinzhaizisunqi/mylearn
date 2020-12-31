package com.example.demo.generic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunqi
 *
 * 2020年9月8日
 */
public class ConfigHolder {
	
private final Map<ConfigTypeEnum, IConfig<?>> map = new ConcurrentHashMap<>();
	
	public IConfig<?> getConfig(ConfigTypeEnum templateType){
		return map.get(templateType);
	}
	
	public void add(ConfigTypeEnum type, IConfig<?> template){
		this.map.put(type, template);
	}

	public Map<ConfigTypeEnum, IConfig<?>> getMap() {
		return map;
	}
	
}
