package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class CateringDao {
	public static Connection getconnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esy_catering", "root", "root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return con;
		}
	}
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean registration(User u) throws SQLException
	{
		boolean isInserted=false;
		Connection con=getconnection();
		PreparedStatement ps=null;
		try {
			
			String query="insert into users (first_name,last_name,password,occupation,event_types,email,contact) values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1,u.getFname());
			ps.setString(2,u.getLname());
			ps.setString(3,u.getPsw());
			ps.setString(4,u.getOccupation());
			ps.setString(5,u.getEmail());
			ps.setString(6,u.getEvents());
			ps.setLong  (7,u.getContact());
			
			isInserted= ps.executeUpdate() > 0;
			System.out.println(isInserted);
			closeConnection(con);
			ps.close();
			return isInserted;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection(con);
			return isInserted;
		}
		finally {
			ps.close();
		}
	}
}
