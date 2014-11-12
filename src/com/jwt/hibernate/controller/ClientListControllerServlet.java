package com.jwt.hibernate.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.bean.Client;
import com.jwt.hibernate.bean.ServiceLine;
import com.jwt.hibernate.bean.Skill;
import com.jwt.hibernate.dao.ClientDAO;
import com.jwt.hibernate.dao.ServiceLineDAO;
import com.jwt.hibernate.dao.UserDAO;

public class ClientListControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ClientListControllerServlet.doPost()");
		ClientDAO clientDAO=new ClientDAO();
		List<Client>clients=clientDAO.getClients();
		request.setAttribute("clients", clients);
		HttpSession session = request.getSession(true);
		session.setAttribute("clients", clients);
		
		ServiceLineDAO  serviceLineDAO= new ServiceLineDAO();
		List<ServiceLine>serviceLineList=serviceLineDAO.getServiceLineList();
		request.setAttribute("serviceLineList", serviceLineList);
		session.setAttribute("serviceLineList", serviceLineList);
		
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
