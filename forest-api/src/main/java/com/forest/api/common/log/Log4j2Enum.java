package com.forest.api.common.log;

/**
 * 
 * @author forest
 *
 */
public enum Log4j2Enum {

	BUSSINESS("bussiness"),

	PLATFORM("platform"),

	DB("db"),

	EXCEPTION("exception"),

	;

	private String category;

	Log4j2Enum(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
