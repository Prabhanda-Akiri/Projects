package ProjectFlight;
import java.util.Scanner;

class Flight
{
	String Boarding,Destination;
	double DepTime,ArrTime;
	double Fare;
	int FlightNumber;

	Flight(String b,String d,int fno,double dt,double at,double fare)
	{
		Boarding=b;
		Destination=d;
		FlightNumber=fno;
		DepTime=dt;
		ArrTime=at;
		Fare=fare;

	}

}

public class Flights
{	
	int number=5;
	double transaction=0;
	int i;

	Flight Fls=new Flight[20];

	Scanner in=new Scanner(System.in);

	public void Menu()
	{
		
		Fls[0]=new Flight("Mumbai","Delhi",73521,3.40,5.20,6030.70);
		Fls[1]=new Flight("Bangalore","Chennai",56372,8.30,10.05,5372.50);
		Fls[2]=new Flight("Hyderabad","Vishakapatnam",23094,2.40,4.50,3956.40);
		Fls[3]=new Flight("Kolkata","Hyderabad",56321,14.50,16.20,5986.10);
		Fls[4]=new Flight("Kashmir","Delhi",83562,17.48,18.35,3564.70);		
	}

	public void show()
	{
		System.out.println("S.No	Flight.No	Boarding-Point	Destination-Point	Dept-Time	Arr-Time	Fare");
		for(i=0;i<number;i++)
		{
			System.out.print(i+".	"+Fls[i].FlightNumber+"	"+Fls[i].Boarding+"	"+Fls[i].Destination+"	"+Fls[i].DepTime)
			System.out.println("	"+Fls[i].ArrTime+"	"+Fls[i].Fare);
		}
	}

	public void Add()
	{
		System.out.println("Here are the Flight Details:\n");
		show();

		System.out.print("\nEnter the flight number:	");
		int fno=in.nextInt();

		System.out.print("\nBoarding-point:	");
		String b=in.next();

		System.out.print("\nDestination-point:	");
		String d=in.next();

		System.out.print("\nDeparture-time:	");
		double dt=in.nextDouble();

		System.out.print("\nArrival-time:	");
		double at=in.nextDouble();

		System.out.print("\nEnter the Fare:	");
		double fare=in.nextDouble();

		number=number+1;
		Fls[number-1]=new Flight(b,d,fno,dt,at,fare)

		System.out.print("\n\nYour Details are added to the new Airline...!!!\n");

		show();

	}


	public void Delete()
	{
		System.out.print("hi");

	}


}
