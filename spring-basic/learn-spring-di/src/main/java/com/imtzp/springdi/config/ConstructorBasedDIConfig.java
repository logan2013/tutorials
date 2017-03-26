package com.imtzp.springdi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = ParserConfig.class)
@ComponentScan(basePackages = "com.imtzp.springdi.constructor")
public class ConstructorBasedDIConfig {

}
