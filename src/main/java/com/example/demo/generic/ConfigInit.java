package com.example.demo.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunqi
 *
 * 2020年9月8日
 */

@Configuration
@EnableAutoConfiguration
public class ConfigInit implements ApplicationContextAware{
	
	private ApplicationContext ac;

	private List<String> rules = Arrays.asList("signScoreConfigImpl");
	
	@Bean
	public ConfigHolder configHolder(){
		ConfigHolder configHolder = new ConfigHolder();
	     for (String rule: rules) {
	    	 IConfig<?> bean = (IConfig<?>)this.ac.getBean(rule);
	    	 configHolder.add(bean.getType(), bean);
	     }

		return configHolder;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.ac = applicationContext;
	}

}
