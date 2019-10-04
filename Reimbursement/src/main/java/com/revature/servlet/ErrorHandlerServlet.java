package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandlerServlet extends HttpServlet {

	private static final long serialVersionUID = -8455671738061653614L;

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getting useful information about the error that occurred client side
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Class<?> exceptionType = (Class<?>) request.getAttribute("javax.servlet.error.exception_type");
		String message = (String) request.getAttribute("javax.servlet.error.message");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		// String exception = (String) request.getAttribute("javax.servlet.error.exception");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		// displaying it to the console
		System.out.println("StatusCode: " + statusCode);
		System.out.println("ExceptionType: " + exceptionType);
		System.out.println("Message: " + message);
		System.out.println("RequestUri: " + requestUri);
		// System.out.println("Exception: " + exception);
		System.out.println("ServletName: " + servletName);
		// redirecting them to the error page
		request.getRequestDispatcher("Error.html").forward(request, response);
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
