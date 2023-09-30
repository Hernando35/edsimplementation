package com.servlet.eds.datamodel;

import com.filenet.api.property.Properties;

public class ProcessFolder<T extends ProcessFolder<T>> extends AbstractCaseManagerClass {
	public ProcessFolder(Properties props) {
		super(props);
	}

	@SuppressWarnings("unchecked")
	protected T getThis() {
		return (T)this;
	}
}