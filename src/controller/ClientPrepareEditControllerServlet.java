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
import com.jwt.hibernate.bean.Skill;
import com.jwt.hibernate.dao.ClientDAO;
import com.jwt.hibernate.dao.UserDAO;
import com.jwt.hibernate.resources.HibernateUtil;

public class ClientPrepareEditControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		HibernateUtil.getSessionFactory().openSession();
		System.out.println("ClientPrepareEditControllerServlet.doPost()");
		String id = request.getParameter("id");
		ClientDAO clientDAO = new ClientDAO();
		
		Client client= clientDAO.getClientById(Integer.valueOf(id));
		System.out.println("ClientPrepareEditControllerServlet.doPost()"+ client.getId());
		request.setAttribute("clientName",client.getClientName());
		 request.setAttribute("comments", client.getComments());
		 request.setAttribute("year", client.getYear());
		 request.setAttribute("quarter",client.getQuarter());
		request.setAttribute("odds",client.getOdds());
		request.setAttribute("staffNumber",client.getStaffNumber());
		request.setAttribute("nonInterlockNumber",client.getNonInterlockNumber());
		request.setAttribute("interlockNumber",client.getInterlockNumber());
		request.setAttribute("resourceNumber",client.getResourceNumber());
		request.setAttribute("contactInfo",client.getContactInfo());
		request.setAttribute("status",client.getStatus());//serviceLine
		request.setAttribute("serviceLine",client.getServiceLine().getId());//serviceLine
		
		
		
		request.setAttribute("selectedSkills",client.getSkills());//serviceLine
				
		String[] skills = request.getParameterValues("skills");
		Set<Skill>listIds = new HashSet<Skill>(0);;
		
		/*for (int i = 0; i < skills.length; i++) {
			Skill skill=new Skill();
			skill.setId(Integer.valueOf(skills[i]));
			skill.setName(skills[i]);
			listIds.add(skill);
		}
			*/
		
      //  request.getRequestDispatcher( "/WEB-INF/client/editClient.jsp" ).forward(request, response);
		try {
			
			//clientDAO.addClientDetails(clientName, year,comments, quarter, odds, staffNumber,nonInterlockNumber,interlockNumber,resourceNumber,contactInfo,status,serviceLine,listIds);
			//response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
