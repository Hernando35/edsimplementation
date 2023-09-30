package com.servlet.eds.datamodel.util;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.eds.datamodel.PropertiesData;

public class InheritedFieldsUtility {
    public static String convertInheritablePropertiesToJson(List<PropertiesData> allProperties) {
        List<PropertiesData> inheritableProperties = allProperties.stream()
                .filter(PropertiesData::isInheritable) // Filter based on your condition
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(inheritableProperties.stream()
                    .map(PropertiesData::getSymbolicName)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Handle the exception as needed
        }
    }
}


