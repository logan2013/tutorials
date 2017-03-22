package com.imtzp.springdi.parser;

public enum FileType {

	CSV(".csv"), XML(".xml"), JSON(".json"), PDF(".pdf"), RICHTEXT(".rtf"), TXT(".txt");

	private String extension;

	private FileType(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return this.extension;
	}
}
