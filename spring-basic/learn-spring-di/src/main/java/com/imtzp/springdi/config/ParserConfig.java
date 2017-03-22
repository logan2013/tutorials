package com.imtzp.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imtzp.springdi.parser.JsonFileParser;
import com.imtzp.springdi.parser.Parser;

@Configuration
public class ParserConfig {

	@Bean
	Parser jsonFileParser() {
		return new JsonFileParser();
	}
}
