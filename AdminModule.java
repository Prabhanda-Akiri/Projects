package Project;
import java.util.Scanner;
import ProjectFlight.*;

interface Admin
{
	public boolean CreateAccount();
	public boolean LoginAccount();
	public void LogoutAccount();
	public void ChangePassword();

	public void AddAirline();

	public void ChangeFare();
	public void DailyTransaction();
}

abstract class AdminAccount implements Admin
{
	String FirstName,LastName;
	String PhoneNo;
	String email;
	String UserName,Password;
	
	Scanner in=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	public boolean CreateAccount()
	{
		int n;
		System.out.println("PLEASE ENTER YOUR VALID DETAILS TO CREATE AN ACCOUNT .......\n\n");
		System.out.print("FIRST NAME: ");
		FirstName=s.next();

		System.out.print("LAST NAME: ");
		LastName=s.next();
		System.out.println("\n");
		try
		{
			System.out.print("PHONE NUMBER: ");
			PhoneNo=s.next();
			System.out.println("\n");
			if (PhoneNo.length()<10)
			{
				throw new ArithmeticException("SHOULD CONTAIN 10 DIGIT NUMBER!!!\nPLEASE ENTER A VALID PHONE NUMBER:");
			}

		}
		catch(ArithmeticException e)
		{
			System.out.print("Error:"+e.getMessage());
			PhoneNo=s.next();
			System.out.println("\n");
		}

		finally
		{
			System.out.print("EMAIL ID : ");
			email=s.next();
			System.out.println("\n");

			System.out.print("PLEASE ENTER A VALID USERNAME: ");
			UserName=s.next();
			System.out.println("\n");

			System.out.print("PLEASE ENTER A 8 DIGIT PASSWORD:");
			Password=s.next();
			System.out.println("\n");

			System.out.println("CONGRAGULATIONS!!!!.......YOUR ACCOUNT HAS BEEN SUCCESSFULLY CREATED\n\n");
			System.out.print("Do u want to continue?\n Please enter (1 for YES/2 for NO):");
			n=s.nextInt();
			if(n==1)
				return true;
			else
				return false;

		}
	}

	public boolean LoginAccount()
	{
		int i=0;
		String name,pwd;

		while(i<=2)
		{
			System.out.print("ENTER THE USERNAME: ");
			name=s.next();
			System.out.println("\n\n");
			System.out.print("ENTER THE PASSWORD: ");
			pwd=s.next();
			if(name.equals(UserName) && pwd.equals(Password))
			{
				System.out.println("Successfully logged in!!!\n\n");
				return true;
			}
			else

				System.out.println("INCORRECT USERNAME OR PASSWORD!!!....PLEASE TRY AGAIN!!! "+(int)(2-i)+" CHANCES ARE LEFT ");

			i=i+1;
		}

		System.out.println("SORRY NUMBER OF TRIALS OVER!!!");
		return false;
	}

	public void LogoutAccount()
	{
		System.out.println("You have been successfully logged out");
	}

	public void ChangePassword()
	{
		String Passwd;
     	String Passwd2;
     	int t1=2;
     	int t2=3;
     
    	System.out.println("Your password must contain minimum 8 characters");
    	System.out.println("Atleast one character must be numeric");
    	System.out.println("Enter your new password:");
     
     	while(t1>1)
     	{
  			Passwd=in.next();
  
  			int length=Passwd.length();
  
  			if(length>=8)
  			{
  
     			System.out.println("Re-enter your password:");
      			Passwd2=in.next();
      			while(t2>1)
      			{
          
          			if(Passwd.equals(Passwd2))
          			{
              			System.out.println("Password successfully changed");
              			Password=Passwd;
              			t2=0;
              			t1=0;
          			}
          			else
          			{
              			System.out.println("Re-enter your password");
          			}
      			}
  			}

  			else
  			{
      			System.out.println("Please enter a valid password:");
      
  			}
  
     	}
	}
	
}


abstract class AdminAbstract extends AdminAccount
{
	public void AddAirline()
	{
		ProjectFlight.Flights F1=new ProjectFlight.Flights();

		F1.Add();

	}

}

public class AdminModule extends AdminAbstract
{
	public void ChangeFare()
	{
		ProjectFlight.Flights ob=new ProjectFlight.Flights();

		System.out.println("Here are the details of the Flights provided");
		ob.show();

		Scanner in=new Scanner(System.in);
		System.out.println("Choose the Flight to change the Fare..\n");
		int n=in.nextInt();
		System.out.println("Enter your new Fare..\n");
		double f=in.nextDouble();

		ob.Fls[n].Fare=f;

		System.out.println("Your New fare is updated\n");

		ob.show();
	}

	public void DailyTransaction()
	{
		ProjectFlight.Flights ob=new ProjectFlight.Flights();

		System.out.println("Todays Daily Transactions are\n"+"						Rs."+ob.transaction+"/- only....");
	}
}

