package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Movie_DAO;
import dto.Movie_DTO;

@WebServlet("/addmovie")
@MultipartConfig(maxFileSize = 20 * 1024 * 1024)
public class AddMovie extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("movieId"));
		String name = req.getParameter("movieName");
		double price = Double.parseDouble(req.getParameter("moviePrice"));
		double rating = Double.parseDouble(req.getParameter("movieRating"));
		String general = req.getParameter("movieGeneral");
		String lang = req.getParameter("movieLanguage");
		
		Part image = req.getPart("movieImage");
		
		Movie_DTO dto = new Movie_DTO();
		dto.setMovieId(id);
		dto.setMovieName(name);
		dto.setMovieCost(price);
		dto.setMovieRating(rating);
		dto.setMovieGeneral(general);
		dto.setMovieLanguage(lang);
		dto.setMovieImage(image.getInputStream().readAllBytes());
		
		Movie_DAO dao = new Movie_DAO();
		try {
			
			HttpSession session = req.getSession();
			String adminName=(String)session.getAttribute("adminName");
			
			if(adminName != null)
			{
				dao.saveDetails(dto);
//				int res=dao.saveDetails(dto);
//				if(res >= 0)
//				{
//					req.setAttribute("message", "Details added Successfully");
//					RequestDispatcher dispatcher1 = req.getRequestDispatcher("AdminHome.jsp");
//					dispatcher1.include(req, resp);
//				}
//				else
//				{
//					req.setAttribute("message", "Something went wrong..!");
//					RequestDispatcher dispatcher1 = req.getRequestDispatcher("AddMovie.jsp");
//					dispatcher1.include(req, resp);				
//				}
				
				List<Movie_DTO> list = dao.findAll();
				req.setAttribute("message", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
				dispatcher.include(req, resp);

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
