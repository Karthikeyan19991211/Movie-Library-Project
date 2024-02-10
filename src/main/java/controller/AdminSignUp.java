package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Admin_DAO;
import dto.Admin_DTO;

@WebServlet("/adminSignUp")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class AdminSignUp extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("adminId"));
		String name = req.getParameter("adminName");
		long contact = Long.parseLong(req.getParameter("adminContact"));
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");
		
		Part image = req.getPart("adminImage");
		
		Admin_DTO admin = new Admin_DTO();
		admin.setAdminId(id);
		admin.setAdminName(name);
		admin.setAdminContact(contact);
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		admin.setAdminImage(image.getInputStream().readAllBytes());
		
		Admin_DAO dao = new Admin_DAO();
		try {
			int result = dao.insertDetails(admin);
			
			if(result > 0)
			{
				req.setAttribute("message", "Sign-Up Successfully Done.....!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminSignUp.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
