package ProjectAdmin;
import java.util.Scanner;

interface Admin
{
	public boolean CreateAccount();
	public boolean LoginAccount();
	public void LogoutAccount();
	public void ChangePassword();

	public void AddAirline();
	public void StopAirline();

	public void ChangeFare();
	public void DailyTransaction();
}

abstract class AdminAccount implements Admin
{
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

	public void LogoutAccount()
	{
		System.out.println("pass");
	}

	public void ChangePassword()
	{
		System.out.println("pass");
	}
}


abstract class AdminAbstract extends AdminAccount
{
	public void AddAirline()
	{
		System.out.println("pass");
	}

	public void StopAirline()
	{
		System.out.println("pass");
	}
}

public class AdminModule extends AdminAbstract
{
	public void ChangeFare()
	{
		System.out.println("pass");
	}

	public void DailyTransaction()
	{
		System.out.println("pass");
	}
}

