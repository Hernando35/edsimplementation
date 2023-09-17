package com.servlet.eds;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.eds.model.ObjectType;

@WebServlet("/my-servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger("com.servlet.eds");
	private ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getServletPath();

		if ("/types".equals(servletPath)) {
			String repositoryId = request.getParameter("repositoryId");
			mapper.writeValue(response.getWriter(), getObjectTypes(repositoryId));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   // Get JSON data from the request body
	    String json = request.getReader().lines().collect(Collectors.joining());
	    InheritanceRequest inheritanceRequest = mapper.readValue(json, InheritanceRequest.class);
	    // Handle inheritance logic here
	    boolean success = handleInheritance(inheritanceRequest);
	    // Send a response based on the success
	    if (success) {
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.getWriter().write("Inheritance successful");
	    } else {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write("Inheritance failed");
	    }
	}

	private boolean handleInheritance(InheritanceRequest inheritanceRequest) {
	    // Perform the inheritance tasks here based on the data in inheritanceRequest
	    // Return true if successful, false if there was an issue
	    // You can implement your inheritance logic and return the result accordingly
	    return true; // Change this based on your logic
	}

	

	private ObjectType[] getObjectTypes(String repositoryId) {
		final String[] objectTypeNames = getObjectTypeNames(repositoryId);
		final ObjectType[] objectTypes = new ObjectType[objectTypeNames.length];
		int index = 0;
		for (String objectTypeName : objectTypeNames) {
			objectTypes[index++] = new ObjectType(objectTypeName);
		}
		return objectTypes;
	}

	/**
	 * Returns the names of the all the object types handled by this servlet. This
	 * is only relevant for IBM Content Navigator implementations.
	 * 
	 * @param repositoryId the id of the repository.
	 * 
	 * @return a list of object types handled by this servlet.
	 */
	public String[] getObjectTypeNames(String repositoryId) {
		return new String[0];
	}

}
