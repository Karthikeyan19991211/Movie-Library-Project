package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin_DTO;

public class Admin_DAO 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary","root","root");
	}
	
	public int insertDetails(Admin_DTO a) throws ClassNotFoundException, SQLException
	{
		Connection con= getConnection();
		PreparedStatement pst = con.prepareStatement("insert into admin values (?,?,?,?,?,?);");
		
		pst.setInt(1,a.getAdminId());
		pst.setString(2,a.getAdminName());
		pst.setLong(3, a.getAdminContact());
		pst.setString(4, a.getAdminEmail());
		pst.setString(5, a.getAdminPassword());
		
		Blob image = new SerialBlob(a.getAdminImage());		
		pst.setBlob(6, image);
		
		int result = pst.executeUpdate();		
		con.close();
		
		return result;
	}
	
	public Admin_DTO findDetails(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from admin where adminEmail = ?;");
		pst.setString(1, email);
		
		ResultSet result = pst.executeQuery();
			
		
		if(result.next())
		{
			Admin_DTO dto = new Admin_DTO();
			dto.setAdminId(result.getInt(1));
			dto.setAdminName(result.getString(2));
			dto.setAdminContact(result.getLong(3));
			dto.setAdminEmail(result.getString(4));
			dto.setAdminPassword(result.getString(5));
			
			Blob img = result.getBlob(6);
			
			byte[] image = img.getBytes(1,(int) img.length());
			dto.setAdminImage(image);
			
			
			con.close();
			
			return dto;
		}		
		else return null;		
	}
	
	
}
