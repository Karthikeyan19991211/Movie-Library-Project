package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Movie_DTO;

public class Movie_DAO {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary", "root", "root");

	}

	public int saveDetails(Movie_DTO m) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into movie values(?,?,?,?,?,?,?);");
		pst.setInt(1, m.getMovieId());
		pst.setString(2, m.getMovieName());
		pst.setDouble(3, m.getMovieCost());
		pst.setDouble(4, m.getMovieRating());
		pst.setString(5, m.getMovieGeneral());
		pst.setString(6, m.getMovieLanguage());

		Blob img = new SerialBlob(m.getMovieImage());
		pst.setBlob(7, img);

		int res = pst.executeUpdate();

		con.close();

		return res;

	}

	public List<Movie_DTO> findAll() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from movie;");

		ResultSet res = pst.executeQuery();

		List<Movie_DTO> list = new ArrayList<Movie_DTO>();

		while (res.next()) {
			Movie_DTO m = new Movie_DTO();
			m.setMovieId(res.getInt(1));
			m.setMovieName(res.getString(2));
			m.setMovieCost(res.getDouble(3));
			m.setMovieRating(res.getDouble(4));
			m.setMovieGeneral(res.getString(5));
			m.setMovieLanguage(res.getString(6));

			Blob img = res.getBlob(7);
			byte[] image = img.getBytes(1, (int) img.length());
			m.setMovieImage(image);

			list.add(m);
		}

		return list;
	}
	
	public int deleteDetails(int id) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from movie where movieId=?;");
		pst.setInt(1, id);
		
		int res = pst.executeUpdate();
		
		con.close();
		
		return res;		
	}
	
	public Movie_DTO findDetails(int id) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from movie where movieId=?;");
		pst.setInt(1, id);
		
		ResultSet res = pst.executeQuery();
		
		Movie_DTO dao = new Movie_DTO();
		
		if(res.next())
		{
		dao.setMovieId(res.getInt(1));
		dao.setMovieName(res.getString(2));
		dao.setMovieCost(res.getDouble(3));
		dao.setMovieRating(res.getDouble(4));
		dao.setMovieGeneral(res.getString(5));
		dao.setMovieLanguage(res.getString(6));
		
		Blob img = res.getBlob(7);
		byte [] image = img.getBytes(1,(int) img.length());
		dao.setMovieImage(image);
		
		return dao;
		}
		
		con.close();
	   return null;
	}
	
	public int updateDetails(Movie_DTO m) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("update movie set movieName=?,moviePrice=?,movieRating=?,movieGeneral=?,movieLanguage=?,movieImage=? where movieId=?;");
	    
		pst.setString(1, m.getMovieName());
		pst.setDouble(2, m.getMovieCost());
		pst.setDouble(3, m.getMovieRating());
		pst.setString(4, m.getMovieGeneral());
		pst.setString(5, m.getMovieLanguage());

		Blob img = new SerialBlob(m.getMovieImage());
		pst.setBlob(6, img);
		
		pst.setInt(7, m.getMovieId());

		int res = pst.executeUpdate();

		con.close();

		return res;


	}

}
