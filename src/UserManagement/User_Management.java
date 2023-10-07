package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class User_Management {
	static ArrayList<User> list = new ArrayList<>();	
	public static void UserManagement(Object UserOptions) throws IOException
	{
		Scanner sc = new Scanner(System.in);		
		boolean CanIKeepRunningTheProgram = true;		
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println( " USER MANAGEMENT  ");
			System.out.println("\n");
			System.out.println("What  You Are Interested Like To Do ?");
			System.out.println("1. ADD_USER");
			System.out.println("2. EDIT_USER");
			System.out.println("3. SEARCH_USER");
			System.out.println("4. DELETE_USER");
			System.out.println("5. QUIT");			
			int OptionSelectedByUser = sc.nextInt();			
					Object u;
					if(OptionSelectedByUser == UserOption.ADD_USER.options)
					{
						AddUser();
						System.out.println("\n");
					} else
						
							if(OptionSelectedByUser == UserOption.EDIT_USER.options)
							{
								System.out.println("Enter the User name which you want to edit : ");
								sc.nextLine();
								String eu = sc.nextLine();
								EditUser(eu);
								System.out.println("\n");
							}
							else if(OptionSelectedByUser == UserOption.SEARCH_USER.options)
							{
								System.out.println("Enter Username which you want to search : ");
								sc.nextLine();
								String su = sc.nextLine();
								SearchUser(su);
								System.out.println("\n");
							}
							else if(OptionSelectedByUser == UserOption.DELETE_USER.options)
							{
								System.out.println("Enter Username which you want to delete : ");
								sc.nextLine();
								String du = sc.nextLine();
								DeleteUser(du);
								System.out.println("\n");
							}
							else if(OptionSelectedByUser == UserOption.QUIT.options)
							{
								File file = new File("C:\\Users\\shambhuraje\\eclipse-workspace\\Task Manager\\src\\UserManagement\\Users");
								FileWriter fr = new FileWriter(file,false);
								BufferedWriter br = new BufferedWriter(fr);
								for(User u1 : list)
								{
									System.out.println(u1.UserName+","+u1.LoginName+","+u1.ConfirmPassword+","+u1.UserRole+"\n");
									br.write(u1.UserName+","+u1.LoginName+","+u1.ConfirmPassword+","+u1.UserRole+"\n");
								}
								br.close();
								fr.close();
								file = null;								
								CanIKeepRunningTheProgram = false;								
								System.out.println(" PROGRAM CLOSED");
							}
		}			
	}
	public static void AddUser()
	{
		Scanner sc = new Scanner(System.in);
		User u = new User();		
		System.out.println("Enter User Name : ");
		u.UserName = sc.nextLine();		
		System.out.println("Enter Login Name : ");
		u.LoginName = sc.nextLine();		
		System.out.println("Enter Confirm Password : ");
		u.ConfirmPassword = sc.nextLine();		
		System.out.println("Enter User Role : ");
		u.UserRole = sc.nextLine();		
		System.out.println("Adding User "+u.UserName+" with the details.");		
		list.add(u);		
	}
	public static boolean ValidateLoginnameAndPassword(String Loginname,String Password)
	{
		Iterator<User> itr = list.iterator();
		
		while(itr.hasNext())
		{
			User u = itr.next();
			
			if(u.LoginName.equalsIgnoreCase(Loginname) && u.ConfirmPassword.equalsIgnoreCase(Password) )
			{
				System.out.println("Login Successfull.");
				System.out.println("\n");
				return true;
			}
		}
		return false;		
	}
	public static void EditUser(String eu)
	{
		Scanner sc = new Scanner(System.in);
		for(User u  : list)
		{
			if(u.UserName.equalsIgnoreCase(eu))
			{
				System.out.println("Current Username : "+eu);
				
				System.out.println("New User Name is : ");
				String UserName = sc.nextLine();
				
				System.out.println("New Login Name is : ");
				String LoginName = sc.nextLine();
				
				System.out.println("New  Confirm Password is : ");
				String ConfirmPassword = sc.nextLine();
				
				System.out.println("New User Role is : ");
				String UserRole = sc.nextLine();
				
				System.out.println("User Information is updated.");
				return;
				
			}
		}
				System.out.println("User Not Found.");			
		
	}
	public static void SearchUser(String su)
	{
		Scanner sc = new Scanner(System.in);
		
		for(User u : list)
		{
			if(u.UserName.equalsIgnoreCase(su))
			{
				System.out.println("User Found Successfully.The Follwoing Information Of User Is :");
				System.out.println("UserName is : "+u.UserName);
				System.out.println("LoginName is : "+u.LoginName);
				System.out.println("ConfirmPassword is : "+u.ConfirmPassword);
				System.out.println("UserRole is : "+u.UserRole);
				return;
			}
		}
			
				System.out.println("User Not Found.");		
	}
	public static void DeleteUser(String du)
	{
		Scanner sc = new Scanner(System.in);		
		Iterator<User> itr = list.iterator();		
		while(itr.hasNext())
		{
			User u = itr.next();			
			if(u.UserName.equalsIgnoreCase(du))
			{
				itr.remove();
				System.out.println("User "+u.UserName+" has been deleted");
				break;
			}
			}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\shambhuraje\\eclipse-workspace\\Task Manager\\src\\UserManagement\\User");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			User v = new User();
			String [] UserDataArray = line.split(",");
			if(UserDataArray.length>3)
			{
				v.UserName = UserDataArray[0];
				v.LoginName = UserDataArray[1];
				v.ConfirmPassword = UserDataArray[2];
				v.UserRole = UserDataArray[3];
								list.add(v);
		}			
	}
		fr.close();
		br.close();
		file = null;
}
	public static void User_Management() {
		// TODO Auto-generated method stub		
	}
	public static void UserManagement() {
		// TODO Auto-generated method stub
		
	}
}
