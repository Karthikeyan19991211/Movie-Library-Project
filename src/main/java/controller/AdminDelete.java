package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Movie_DAO;

@WebServlet("/DeleteAdmin")
public class AdminDelete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
int id = Integer.parseInt(req.getParameter("id"));
		
		Movie_DAO dao = new Movie_DAO();
			//dao.deleteDetails(id);
			
            try {
				HttpSession session = req.getSession();
				String adminName=(String)session.getAttribute("adminName");
				
				if(adminName!=null) 
				{
					int result = dao.deleteDetails(id);
					if(result >= 1)
					{
						req.setAttribute("message", dao.findAll());
						RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
						dispatcher.include(req, resp);
					}
					else
					{
						req.setAttribute("message", "Something Went Wrong Please Check...!");
						RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
						dispatcher.include(req, resp);
					}
					
				}
				else
				{
					req.setAttribute("message", "Access Denied , Admin Login Required..!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("AdminLogIn.jsp");
					dispatcher.include(req, resp);					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
