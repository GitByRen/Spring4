package com.important.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

/**
 * 在WEB中应用Spring的基本思路
 */
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext ac = (ApplicationContext) getServletContext().getAttribute("ApplicationContext");
		Person bean = ac.getBean(Person.class);
		bean.hello();
	}

}
