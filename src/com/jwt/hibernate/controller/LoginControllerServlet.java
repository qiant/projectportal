/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jwt.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.bean.User;
import com.jwt.hibernate.dao.UserDAO;

public class LoginControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);
		try {
			UserDAO userDAO = new UserDAO();
			List<User> records = userDAO.getUser(username, password);

			if (records.size() > 0) {
				/*request.setAttribute("loginstatus", "Login Successful.");
				// httpSession.setAttribute("username", username);
				getServletContext().getRequestDispatcher(
						"/register.jsp").forward(request, response);*/
				response.sendRedirect("/HibernateWebApp/listClient.jsp");
			} else {
				/*request.setAttribute("loginstatus",
						"Username/Password do not match.");
				getServletContext().getRequestDispatcher(
						"/login.jsp").forward(request, response);*/
				request.setAttribute("errorMessage", "Please enter a valid username/password");
				//response.sendRedirect("/HibernateWebApp/login.jsp");
	            request.getRequestDispatcher("/login.jsp").forward(request, response);

			}
			// response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}