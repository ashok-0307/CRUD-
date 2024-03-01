import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class admin {

	//Database Connection
	Connection con;
	admin() {
		String url = "jdbc:mysql://localhost:3306/info";
		String user = "root";
		String pass = "";
		try {
		con=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			System.out.println("DaTABASE NOT CONNECTED\n");
		}
	}

	//Insertion Data into the student table
	public int insert(int id,String name,String dept,int per) {
		int c = 0;
		try {
			String query = "insert into student(id,name,dept,percenrage)values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, dept);
			pst.setInt(4, per);
			pst.executeUpdate();	
		}catch(Exception e) {
			System.out.print("Error in sertion");
			e.printStackTrace();
		}return c;
		
	}
	
	//Updating data in student table
	void update(int per,int id) {
		try{
			String query = "update student set percenrage=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, per);
			pst.setInt(2,id);
			int i = pst.executeUpdate();
			System.out.print((i>=1)?"updated":"Invalid student ID");
			con.close();
		}catch(Exception e) {
			System.out.print("Error in updating");
			e.printStackTrace();
		}
	}
	
	//Read the data in table
	void view() {
		String query = "select * from student";
		try {
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		System.out.println("Records of student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		System.out.print("End of records");
	    }catch(Exception e) {
	    	System.out.print("Error in viewing records");
	    	e.printStackTrace();
	    }

    }
	
	//Delete the Particular data using ID
	void delete(int id) {
		String query = "delete from student where id=?";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			int a = pst.executeUpdate();
			System.out.println((a >= 1)?"Record deleted":"Not deleted");
			con.close();
		}catch(Exception e) {
			System.out.print("Error in deletion");
			e.printStackTrace();
		}
	}
	
	//display the timetable data 
	void timetable() {
		String query = "select * from timetable";
		try {
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		System.out.println("Exam time table");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		con.close();
		}catch(Exception e) {
			System.out.println("Error in showing timetable");
			e.printStackTrace();
		}
	}
}