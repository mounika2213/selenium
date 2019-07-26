package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tc1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/";
		String dbname="mysample";
		String DBdriver="com.mysql.jdbc.Driver";
		String username="root";
		String password="7416371713";
		Connection conn;
		//create object for database
		Class.forName(DBdriver).newInstance();
		//create connection  to database
		conn=DriverManager.getConnection(url+dbname,username,password);
		//insert query
		PreparedStatement psmt=conn.prepareStatement("select*from emp");
		//execute query
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(6));
		}

	}

}
