package com.servlet.eds.datamodel;

import com.filenet.api.property.Properties;
import com.servlet.eds.datamodel.list.CaseStatus;

public class HeadFolder<T extends HeadFolder<T>> extends GeneralFolder<T>  {
	public HeadFolder(Properties props) {
		super(props);
	}

	@SuppressWarnings("unchecked")
	protected T getThis() {
		return (T) this;
	}

	public CaseStatus getCaseStatus() {
		return CaseStatus.fromString(getStringValue(PropertiesData.CASE_STATUS).orElse(""));
	}
	
	//getter and setters

}
