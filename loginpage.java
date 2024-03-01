import java.util.Scanner;
import java.util.*;

public class loginpage {

	public static void main(String[] args) {
		while(true) {

		//Getting Input By Using Scanner Class 
		Scanner sc = new Scanner(System.in);

		//Home
		System.out.println("Welcome to INFO collage");
		System.out.println();
		System.out.println("1.Admin login \n2.Student login\n");
		System.out.print("Enter a choice(admin or student) : ");
		String login = sc.next();

		//student Login 
		if(login.equals("student")) {
			System.out.println("Welcome student ");

			//Checking ID and Passcode
			System.out.print("Enter a User ID : ");
			String sid=sc.next();
			System.out.print("Enter a Password : ");
			String spass = sc.next();
			if((sid.equals("student")) && (spass.equals("student123"))) {
				user user = new user();
				System.out.println("Welcome student");
				System.out.println("1. Student details \n2. View the Percentage of student \n3. View timetable \n4.Logout");
				System.out.print("Enter a choice : ");
				int ch = sc.nextInt();
				if(ch == 1) {
					System.out.print("Enter a Student ID : ");
					int id = sc.nextInt();
					user.select(id);				
				}else if(ch == 2) {
					System.out.print("Enter a Student result : ");
					int id = sc.nextInt();
					user.result(id);
				}else if(ch == 3) {
					System.out.print("Enter a Department : ");
					String dep = sc.next();
					user.timetable(dep);
				}else {
					System.out.print("Invalid Option");
				}	
			}else {
				System.out.println("Invalid login and try again");
			}
			
		//Admin Login
		}else if(login.equals("admin")) {
			String a = "admin",b = "admin123";
			System.out.println("Welcome Admin");
			System.out.print("Enter a Login ID : ");
			String aid = sc.next();
			System.out.print("Enter a Password : ");
			String apass = sc.next();

			//Checking ID and Passcode
			if((aid.equals(a)) && (apass.equals(b))){
				System.out.println("Welcome admin");
			 admin ad = new admin();
			 System.out.println("1. Add the Student details \n2. Modify the Student details \n3. View the Student detail \n4. Delete the Student details \n5. View Exam timetable \n6. Logout");
			 System.out.print("Enter a choice : ");
			 int ch = sc.nextInt();
			 if(ch == 1) {
					System.out.print("Enter a Student ID : ");
					int id = sc.nextInt();
					System.out.print("Enter a Student name  : ");
					String name = sc.next();
					System.out.print("Enter a Student department  : ");
					String dep = sc.next();
					System.out.print("Enter a Student Percentage : ");
					int per = sc.nextInt();
					int u = ad.insert( id, name, dep, per);
					System.out.println((u>=1)?"Record Inserted":"Not inserted");	
			 }else if(ch == 2) {
				    System.out.print("Enter a Student ID : ");
					int id = sc.nextInt();
					System.out.print("Enter a Percentage : ");
					int per = sc.nextInt();
				    ad.update( per,id);
			 }else if(ch == 3) {
				 ad.view();
			 }else if(ch == 4) {
				     System.out.print("Enter a Student ID : ");
				     int id = sc.nextInt();   
				     ad.delete(id);
			 }else if(ch == 5) {
				      ad.timetable();
			 }else if(ch == 6) {
				System.out.println("Thank you");
			 }
			}else {
				System.out.println("Invalid login");
			}
		}else {
			System.out.print("Inalid login");
		}
		}
	}

}
