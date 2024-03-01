import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class user {

	//Database Connection
	private Connection con;
	user() {
		String url = "jdbc:mysql://localhost:3306/info";
		String user = "root";
		String pass = "";
		try {
		con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			System.out.println("DaTABASE NOT CONNECTED");
		}
	}

	void select(int id) {
		String query = "select * from student where id=? ";
		try {
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		System.out.println("Details of student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		con.close();
		}catch(Exception e) {
			System.out.println("Error in showing details");
			e.printStackTrace();
		}
	}

	void result(int id) {
		String query = "select * from student where id=? ";
		try {
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		System.out.println("Details of student");
		while(rs.next()) {
			System.out.println(" "+rs.getString(2)+" your percentage in acadamic year "+rs.getInt(4));
		}
		con.close();
		}catch(Exception e) {
			System.out.println("Error in showing details");
			e.printStackTrace();
		}
	}
	
	void timetable(String dep) {
		String query = "select * from timetable where dname=? ";
		try {
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, dep);
		ResultSet rs = pst.executeQuery();
		System.out.println("Time table");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		con.close();
		}catch(Exception e) {
			System.out.println("Error in showing details");
			e.printStackTrace();
		}	
	}
}
