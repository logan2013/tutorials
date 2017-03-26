package com.imtzp.springdi.parser;

import java.io.File;
import java.util.logging.Logger;

public class JsonFileParser implements Parser {

	private static final Logger logger = Logger.getLogger(JsonFileParser.class.getName());

	@Override
	public void parse(File file) {
		// Logic to parse json file
		logger.info("Inside JSON Parser");
	}

	@Override
	public FileType getFileType() {
		return FileType.JSON;
	}
}
