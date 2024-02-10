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
import dto.Movie_DTO;

@WebServlet("/UpdateAdmin")
public class UpdateMovie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Movie_DAO dao = new Movie_DAO();
		try {
			HttpSession session = req.getSession();
			String adminName = (String) session.getAttribute("adminName");

			if (adminName != null) {
				Movie_DTO list = dao.findDetails(id);
				if (list != null) {
					req.setAttribute("message", list);
					RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
					dispatcher.include(req, resp);
				} else {
					req.setAttribute("error", "Something Went Wrong...!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
					dispatcher.include(req, resp);
				}
			} else {
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
