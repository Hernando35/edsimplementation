package com.servlet.eds.datamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.filenet.api.property.Properties;

public abstract class AbstractCaseManagerClass {

	private Properties props;
	private HashMap<PropertiesData, Object> propertiesBackingMap = new HashMap<PropertiesData, Object>();

	public AbstractCaseManagerClass(Properties props) {
		this.props = props;
	}

	protected Optional<String> getStringValue(PropertiesData properties) {
		String res = props.getStringValue(properties.getSymbolicName());
		if (propertiesBackingMap.get(properties) != null) {
			res = propertiesBackingMap.get(properties).toString();
		}
		return StringUtils.isBlank(res) ? Optional.empty() : Optional.of(res);
	}

	public List<PropertiesData> getInheritableProperties() {
		return Stream.of(PropertiesData.values()).filter(PropertiesData::isInheritable).collect(Collectors.toList());
	}

}
