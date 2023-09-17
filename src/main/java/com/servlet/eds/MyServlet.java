package com.servlet.eds;

import java.io.IOException;
import java.util.logging.Logger;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
