package com.servlet.eds.datamodel;

import com.filenet.api.property.Properties;

public class GeneralFolder<T extends GeneralFolder<T>> extends AbstractCaseManagerClass {
	public GeneralFolder(Properties props) {
		super(props);
	}

	@SuppressWarnings("unchecked")
	protected T getThis() {
		return (T)this;
	}
}
