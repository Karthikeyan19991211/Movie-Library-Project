package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_DAO;
import dto.User_DTO;

@WebServlet("/userSignUp")
public class UserSignUp extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("userName");
		long contact = Long.parseLong(req.getParameter("userContact"));
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		
		User_DTO user = new User_DTO();
		user.setUserId(id);
		user.setUserName(name);
		user.setUserContact(contact);
		user.setUserEmail(email);
		user.setUserPassword(password);
		
		User_DAO dao = new User_DAO();
		try {
			int result = dao.insertDetails(user);
			
			if(result > 0)
			{
				req.setAttribute("message", "SignUp Successfully Done...!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminSignUp.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "SignUp Failed...!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("UserSignUp.jsp");
				dispatcher.include(req, resp);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
