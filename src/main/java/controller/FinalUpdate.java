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
import javax.servlet.http.Part;

import dao.Movie_DAO;
import dto.Movie_DTO;

@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize = 25 * 1024 * 1024)
public class FinalUpdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("movieId"));
		String name = req.getParameter("movieName");
		double price = Double.parseDouble(req.getParameter("moviePrice"));
		double rating = Double.parseDouble(req.getParameter("movieRating"));
		String general = req.getParameter("movieGeneral");
		String language = req.getParameter("movieLanguage");

		Part img = req.getPart("movieImage");

		Movie_DAO dao = new Movie_DAO();

		Movie_DTO dto = new Movie_DTO();
		dto.setMovieId(id);
		dto.setMovieName(name);
		dto.setMovieCost(price);
		dto.setMovieRating(rating);
		dto.setMovieGeneral(general);
		dto.setMovieLanguage(language);

		try {
			if (img.getSize() > 0) {
				dto.setMovieImage(img.getInputStream().readAllBytes());
				dao.updateDetails(dto);
				
				req.setAttribute("message", dao.findAll());
				RequestDispatcher dis = req.getRequestDispatcher("AdminHome.jsp");
				dis.include(req, resp);
			}
			else
			{
				Movie_DTO movie = dao.findDetails(id);
				dto.setMovieImage(movie.getMovieImage());
				dao.updateDetails(dto);
				
				req.setAttribute("message", dao.findAll());
				RequestDispatcher dis = req.getRequestDispatcher("AdminHome.jsp");
				dis.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
