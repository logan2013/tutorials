package com.imtzp.springdi.parser;

import java.io.File;
import java.util.Objects;

public interface Parser {

	void parse(File file);

	FileType getFileType();

	public default boolean canParse(File file) {
		return Objects.nonNull(file) && file.getName().endsWith(getFileType().getExtension());
	}
}
