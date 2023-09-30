package com.servlet.eds.model.factory;

import com.filenet.api.property.Properties;
import com.servlet.eds.datamodel.AbstractCaseManagerClass;
import com.servlet.eds.datamodel.GeneralFolder;
import com.servlet.eds.datamodel.HeadFolder;
import com.servlet.eds.datamodel.ProcessFolder;

public class DataModelFactory {
	public static AbstractCaseManagerClass createDataModel(String modelName, Properties props) {
		switch (modelName) {
		case "HeadFolder":
			return new HeadFolder<>(props);
		case "ProcessFolder":
			return new ProcessFolder<>(props);
		case "GeneralFolder":
			return new GeneralFolder<>(props);
		default:
			throw new IllegalArgumentException("Invalid data model: " + modelName);
		}
	}
}
