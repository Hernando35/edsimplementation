package com.servlet.eds.datamodel;

public enum PropertiesData {
	NAME("name", false),
	LAST_NAME("last name", false),
	DATE_CREATION("Date creation", false),
	CASE_PUBLICED("Publiced", true),
	CASE_STATUS("Case status", true),
	CASE_MANAGER("Case manager", true),
	ADDRESS("Address", false),
	DEPARTMENT("Department", false);

	private final String symbolicName;
	private boolean inheritable;

	PropertiesData(String symbolicName, boolean inheritable) {
		this.symbolicName = symbolicName;
		this.inheritable = inheritable;
	}

	public String getSymbolicName() {
		return symbolicName;
	}

	public boolean isInheritable() {
		return inheritable;
	}


}
