package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Admin_DAO;
import dao.Movie_DAO;
import dto.Admin_DTO;
import dto.Movie_DTO;

@WebServlet("/adminlogin")
public class AdminLogIn extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");
		
		Admin_DAO dao = new Admin_DAO();
		try {
			Admin_DTO dto= dao.findDetails(email);
			
			if(dto != null)
			{
				if(password.equals(dto.getAdminPassword()))
				{
					HttpSession session = req.getSession();
					session.setAttribute("adminName", dto.getAdminName());
					Movie_DAO movie = new Movie_DAO();
					req.setAttribute("message", movie.findAll());
					RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Invalid Password...!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLogIn.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "Invalid Email Id...!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLogIn.jsp");
				dispatcher.include(req, resp);				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

