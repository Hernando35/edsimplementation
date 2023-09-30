package com.servlet.eds.datamodel.list;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum CaseStatus {
	OPEN("open", "Open"), CLOSED("closed", "Closed"), REVIEWED("reviewed", "Reviewed"), EMPTY(null, null);

	private final String status;
	private final String displayValue;
	private static final Map<String, CaseStatus> VALUE = new HashMap<>();

	private CaseStatus(String status, String displayValue) {
		this.status = status;
		this.displayValue = displayValue;
	}

	public String getStatus() {
		return status;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public static CaseStatus fromString(String status) {
		if (StringUtils.isBlank(status)) {
			return EMPTY;
		}
		return VALUE.get(status);
	}

}
