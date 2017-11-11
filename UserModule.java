package ProjectUser;
import java.util.Scanner;


interface User
{
	public boolean CreateAccount();
	public boolean LoginAccount();

	public void BookTickets();
	public void ChangePassword();

	public void CancelTickets();
	public void FlightDetails();
	public void LogoutAccount();
}

abstract class UserAbstract implements User
{
	String FirstName,LastName;
	long PhoneNo;
	String email;
	String UserName,Password;
	boolean BookingStatus;

	UserAbstract()
	{
		int a;
	}
		
	public boolean CreateAccount()
	{
		System.out.println("pass");

		return true;

	}

	public boolean LoginAccount()
	{
		System.out.println("pass");

		return true;
	}

	public void ChangePassword()
	{
		System.out.println("pass");
	}
}

public class UserModule extends UserAbstract

{
	public UserModule()
	{
		super();
	}

	public void BookTickets()
	{
		System.out.println("pass");
	}

	public void CancelTickets()
	{
		System.out.println("pass");
	}

	public void FlightDetails()
	{
		System.out.println("pass");
	}

	public void LogoutAccount()
	{
		System.out.println("pass");
	}
}


