package MainLogin;
import java.io.IOException;
import java.util.Scanner;
import TaskManagement.Task_Management;
import UserManagement.User_Management;
public class Main_Login {
	public static void main(String args[]) throws IOException
	{
		Scanner s = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		System.out.println(" Introducing The Task Management System");
		System.out.println(" Welcome To Login Page");
		System.out.println("\n");				
		System.out.println(" Enter The Login Name");
		String LoginName = s.nextLine();		
		System.out.println(" Enter The Correct Password");
		String Password = s.nextLine();
		if(User_Management.ValidateLoginnameAndPassword(LoginName,Password))
		{
			System.out.println("\n");
			System.out.println(" LOGIN FAILED");
			return;
		}
	
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println(" Welcome To Task Manager ");
			System.out.println("\n");			
			System.out.println("What  you are Interested to do ?");
			System.out.println("1. UserManagement");
			System.out.println("2. TaskMangement");
			System.out.println("3. Exit");
			int OptionSelectedByUser = s.nextInt();			
			if(OptionSelectedByUser == 1)
			{
				User_Management.User_Management();
			}
			else if(OptionSelectedByUser == 2)
			{
				Task_Management.TaskManagement();
			}
			else if(OptionSelectedByUser == 3)
			{
				CanIKeepRunningTheProgram=false;
				System.out.println("PROGRAM  CLOSED");	
				break;
			}
		}
	}
