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

import com.jwt.hibernate.bean.Skill;
import com.jwt.hibernate.dao.ClientDAO;
import com.jwt.hibernate.dao.UserDAO;

public class ClientControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String clientName = request.getParameter("clientName");
		String comments = request.getParameter("comments");
		String year = request.getParameter("year");
		String quarter = request.getParameter("quarter");
		String odds = request.getParameter("odds");
		Integer staffNumber = Integer.valueOf(request.getParameter("staffNumber"));
		Integer nonInterlockNumber = Integer.valueOf(request.getParameter("nonInterlockNumber"));
		Integer interlockNumber = Integer.valueOf(request.getParameter("interlockNumber"));
		Integer resourceNumber = Integer.valueOf(request.getParameter("resourceNumber"));
		String contactInfo = request.getParameter("contactInfo");
		String status = request.getParameter("status");//serviceLine
		Integer serviceLine = Integer.valueOf(request.getParameter("serviceLine"));//serviceLine
				
		String[] skills = request.getParameterValues("skills");
		Set<Skill>listIds = new HashSet<Skill>(0);;
		
		for (int i = 0; i < skills.length; i++) {
			Skill skill=new Skill();
			skill.setId(Integer.valueOf(skills[i]));
			skill.setName(skills[i]);
			listIds.add(skill);
		}
			
		
		HttpSession session = request.getSession(true);
		try {
			ClientDAO clientDAO = new ClientDAO();
			clientDAO.addClientDetails(clientName, year,comments, quarter, odds, staffNumber,nonInterlockNumber,interlockNumber,resourceNumber,contactInfo,status,serviceLine,listIds);
			//response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
