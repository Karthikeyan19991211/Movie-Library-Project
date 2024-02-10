package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.User_DTO;

public class User_DAO 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary","root","root");
	}
	
	public int insertDetails(User_DTO a) throws ClassNotFoundException, SQLException
	{
		Connection con= getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user values (?,?,?,?,?);");
		
		pst.setInt(1,a.getUserId());
		pst.setString(2,a.getUserName());
		pst.setLong(3, a.getUserContact());
		pst.setString(4, a.getUserEmail());
		pst.setString(5, a.getUserPassword());		
		
		int result = pst.executeUpdate();		
		con.close();
		
		return result;
	}
	
	public User_DTO findDetails(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where userEmail = ?;");
		pst.setString(1, email);
		
		ResultSet result = pst.executeQuery();
		
		if(result.next())
		{
			User_DTO dto = new User_DTO();
			dto.setUserId(result.getInt(1));
			dto.setUserName(result.getString(2));
			dto.setUserContact(result.getLong(3));
			dto.setUserEmail(result.getString(4));
			dto.setUserPassword(result.getString(5));
			
			con.close();
			
			return dto;
		}
		else return null;		
	}
}
