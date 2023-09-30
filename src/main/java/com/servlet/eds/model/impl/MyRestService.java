package com.servlet.eds.model.impl;

import java.awt.PageAttributes.MediaType;
import java.lang.annotation.Target;
import java.util.List;

import com.filenet.api.property.Properties;
import com.filenet.apiimpl.property.PropertiesImpl;
import com.filenet.apiimpl.transport.Response;
import com.servlet.eds.datamodel.AbstractCaseManagerClass;
import com.servlet.eds.datamodel.PropertiesData;
import com.servlet.eds.datamodel.util.InheritedFieldsUtility;
import com.servlet.eds.model.factory.DataModelFactory;

//@Path("/data")
public class MyRestService {
   
    //@Produces(MediaType.APPLICATION_JSON)
    public Response getData(String modelName) {
        // Determine the data model class based on the request parameter
    	Properties props = new PropertiesImpl();
    	props.getStringValue("Case status");
        AbstractCaseManagerClass dataModel = DataModelFactory.createDataModel(modelName, props);

        // Get and convert inheritable properties to JSON
        List<PropertiesData> inheritableProperties = dataModel.getInheritableProperties();
        String json = InheritedFieldsUtility.convertInheritablePropertiesToJson(inheritableProperties);

        // Include the JSON data in the REST API response
        return null;
        
    }
}

