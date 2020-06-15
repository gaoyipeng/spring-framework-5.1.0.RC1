package com.sxdx.config;

import com.sxdx.entity.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring
 * @description: 配置类
 * @author: garnett
 * @create: 2020-04-17 17:55
 **/

@Configuration
public class LifeCycle {


	//@Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
	public Processor processor(){
		return new Processor();
	}
}
