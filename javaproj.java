import java.util.Scanner;

interface User
{
	public void CreateAccount();
	public boolean LoginAccount();

	public void BookTickets();
	public void ChangePassword();

	public void CancelTickets();
	public void FlightDetails();
	public void LogoutAccount();
}

abstract class UserAbstract implements User
{
	public void CreateAccount()
	{
		System.out.println("pass");
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

class UserModule extends UserAbstract

{
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


interface Admin
{
	public void CreateAccount();
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
	public void CreateAccount()
	{
		System.out.println("pass");
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

class AdminModule extends AdminAbstract
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


public class javaproj
{
	public static void main(String[] args)
	{
		
		Scanner in=new Scanner(System.in);

		System.out.println("\n\n	****************************WELCOME TO SPICE JET AIRWAYS...!!!****************************\n\n");

		System.out.println("	Here are the modules we offer to provide the safe and secure management of the information..\n\n");

		System.out.println("-->1.User Module\n-->2.Administrative Module\n-->3.Exit\n");

		System.out.println("Choose Your Module..\n");

		int ModuleSelection;

		while(2>1)
		{
			ModuleSelection=in.nextInt();

			if(ModuleSelection<1 || ModuleSelection>3)
				System.out.println("\nChoose your Module properly..");
			else
				break;
		}

		if(ModuleSelection==1)
		{
			System.out.println("\n\nWelcome to the User-Module..!!\n");

			UserModule user=new UserModule();

			System.out.println("1.Not yet Registered??	Make an account and start enjoying the services of SPICE JET....\n");
			System.out.println("2.Already a member of the SPICE JET family??	Login and check the flight details..\n");

			System.out.println("Choose your option..!!\n");

			int UserStatus;

			while(2>1)
			{
				UserStatus=in.nextInt();

				if(UserStatus<1 || UserStatus>2)
					System.out.println("\nChoose your option properly..");
				else
					break;
			}

			if(UserStatus==1)
			{
				user.CreateAccount();
			}

			if(UserStatus==2)
			{
				System.out.println("To continue in the Registered User-Module you must login to your account..");

				boolean LoginDetails;
				LoginDetails=user.LoginAccount();

				if(LoginDetails==true)
				{
					System.out.println("You are properly logged into your account..\n\nHere are the services provided to your module..\n");

					System.out.print("1.Book your tickets\n2.Cancel your already booked tickets\n");
					System.out.println("3.Search for the Flights available on different dates(in case you don't want to book your ticket now)");
					System.out.println("4.Logout and Exit the User Module");
					System.out.println("\nChoose your service..");

					int UserServices;

					while(2>1)
					{
						UserServices=in.nextInt();

						if(UserServices<1 || UserServices>4)
							System.out.println("Choose your service properly");
						else
							break;
					}

					if(UserServices==1)
					{
						user.BookTickets();
						System.out.println("\nThank You for using SPICE JET....!!!\n");
						System.out.println("Have a Great Day..!!\n");
					}

					else if(UserServices==2)
					{
						user.CancelTickets();
						System.out.println("\nThank You for using SPICE JET....!!!\n");
						System.out.println("Have a Great Day..!!\n");
					}

					else if(UserServices==3)
					{
						user.FlightDetails();
						System.out.println("\nThank You for using SPICE JET....!!!\n");
						System.out.println("Have a Great Day..!!\n");
					}

					else
					{
						user.LogoutAccount();
					}

				}

				else if(LoginDetails==false)
				{
					System.out.println("Sorry!!..\nWe couldn't log you in to the account\nHere are the alternate options we can provide\n");
					System.out.println("1.Forgot password??	Change your password");
					System.out.println("2.In case you are not the user of the accout you tried to login,Create a new account\n");
					System.out.println("Choose your option..");
					int FalseChoice;

					while(2>1)
					{
						FalseChoice=in.nextInt();

						if(FalseChoice<1 || FalseChoice>2)
							System.out.println("\nChoose your option properly");
						else
							break;
					}

					if(FalseChoice==1)
					{
						user.ChangePassword();
					}

					else if(FalseChoice==2)
					{
						user.CreateAccount();
					}
				}

			}

		}

		else if(ModuleSelection==2)
		{
			System.out.println("\n\nWelcome to the Administrative Module...!!");

			AdminModule admin=new AdminModule();

			System.out.println("To continue in the Admin module you must Login for the secure management of the SPICE JET Airlines..");

			System.out.println("1.Are you a new staff member of SPICE JET?	Create an account and perform your tasks..");
			System.out.println("2.Already have an account?	Login and perform your tasks..\n");

			int AdminStatus;
			System.out.println("Choose your status..\n");

			while(2>1)
			{
				AdminStatus=in.nextInt();

				if(AdminStatus<1 || AdminStatus>2)
					System.out.println("\nChoose your status properly..");

				else
					break;
			}

			if(AdminStatus==1)
			{
				admin.CreateAccount();
			}

			else if(AdminStatus==2)
			{
				System.out.println("You must Login to your account to perform the tasks..\n");

				boolean AdminLogin;

				AdminLogin=admin.LoginAccount();

				if(AdminLogin==true)

				{
					System.out.println("Here are the services provided to your Module..\n");

					System.out.println("1.Introduce a new Airline\n2.Change fares of Airlines\n3.Stop the services of certain Airline");
					System.out.println("4.Check daily Transactions\n5.Logout and Exit the Administrative Module\n");

					int AdminService;

					System.out.println("Choose your Service\n");

					while(2>1)
					{
						AdminService=in.nextInt();

						if(AdminService<1 || AdminService>4)
							System.out.println("\nChoose your service properly");

						else
							break;					
					}

					if(AdminService==1)
					{
						admin.AddAirline();
						System.out.println("Your changes are Updated..!!!\n    SPICE JET offers sincere regards to your Services    \n");
						System.out.println("Have a Great Day...!!\n");
					}

					else if(AdminService==2)
					{
						admin.ChangeFare();
						System.out.println("Your changes are Updated..!!!\n    SPICE JET offers sincere regards to your Services    \n");
						System.out.println("Have a Great Day...!!\n");
					}

					else if(AdminService==3)
					{
						admin.StopAirline();
						System.out.println("Your changes are Updated..!!!\n    SPICE JET offers sincere regards to your Services    \n");
						System.out.println("Have a Great Day...!!\n");
					}

					else if(AdminService==4)
					{
						admin.DailyTransaction();
						System.out.println("Your changes are Updated..!!!\n    SPICE JET offers sincere regards to your Services    \n");
						System.out.println("Have a Great Day...!!\n");
					}

					else if(AdminService==5)
					{
						admin.LogoutAccount();
					}



				}

				else if(AdminLogin==false)
				{
					System.out.println("Sorry..!!\nWe couldn't log you in to the account chosen\nHere are the alternate options we could provide\n");
					System.out.println("1.Forgot password??	Change your password");
					System.out.println("2.In case you are not the user of the accout you tried to login,Create a new account\n");
					System.out.println("Choose your option..");
					int FalseChoice;

					while(2>1)
					{
						FalseChoice=in.nextInt();

						if(FalseChoice<1 || FalseChoice>2)
							System.out.println("\nChoose your option properly");
						else
							break;
					}

					if(FalseChoice==1)
					{
						admin.ChangePassword();
					}

					else if(FalseChoice==2)
					{
						admin.CreateAccount();
					}			
				}
			}

		}

		else
			System.out.println("\n\n	Have a Nice Day..!!\n\n");

		System.out.println("\n\n	SPICE JET  ---	Fastest and Safest....!!!!\n\n");
	}

}
