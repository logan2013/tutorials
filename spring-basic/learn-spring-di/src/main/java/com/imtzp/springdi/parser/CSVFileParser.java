package com.imtzp.springdi.parser;

import java.io.File;
import java.util.logging.Logger;

public class CSVFileParser implements Parser {
	private static final Logger logger = Logger.getLogger(CSVFileParser.class.getName());

	@Override
	public void parse(File file) {
		// logic to parse CSV file goes here
		logger.info("Inside CSVFileParser");
	}

	@Override
	public FileType getFileType() {
		return FileType.XML;
	}

}
