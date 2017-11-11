package ProjectFlight;
import java.util.Scanner;
import FlightDetails.*;


public class Flights
{	
	public int number=5;
	public double transaction=0;
	int i;

	public FlightDetails.Flight Fls[]=new FlightDetails.Flight[20];

	Scanner in=new Scanner(System.in);

	public void Menu()
	{
		
		Fls[0]=new FlightDetails.Flight("Mumbai","Delhi",73521,3.40,5.20,6030.70);
		Fls[1]=new FlightDetails.Flight("Bangalore","Chennai",56372,8.30,10.05,5372.50);
		Fls[2]=new FlightDetails.Flight("Hyderabad","Vishakapatnam",23094,2.40,4.50,3956.40);
		Fls[3]=new FlightDetails.Flight("Kolkata","Hyderabad",56321,14.50,16.20,5986.10);
		Fls[4]=new FlightDetails.Flight("Kashmir","Delhi",83562,17.48,18.35,3564.70);		
	}

	public void show()
	{
		System.out.println("S.No	Flight.No	Boarding-Point	Destination-Point	Dept-Time	Arr-Time	Fare");
		for(i=0;i<number;i++)
		{
			System.out.print(i+".	"+Fls[i].FlightNumber+"	"+Fls[i].Boarding+"	"+Fls[i].Destination+"	"+Fls[i].DepTime);
			System.out.println("	"+Fls[i].ArrTime+"	"+Fls[i].Fare);
		}
	}

	public void Add()
	{
		System.out.println("Here are the Flight Details:\n");
		show();

		System.out.print("\nEnter the 5-digit flight number:	");
		int fno=in.nextInt();

		System.out.print("\nBoarding-point:	");
		String b=in.next();

		System.out.print("\nDestination-point:	");
		String d=in.next();

		System.out.print("\nDeparture-time(in 24-hr format):	");
		double dt=in.nextDouble();

		System.out.print("\nArrival-time(in 24-hr format):	");
		double at=in.nextDouble();

		System.out.print("\nEnter the Fare(in Rupees):	");
		double fare=in.nextDouble();

		number=number+1;
		Fls[number-1]=new Flight(b,d,fno,dt,at,fare);

		System.out.print("\n\nYour Details are added to the new Airline...!!!\n");

		show();

	}


	public void Delete()
	{
		System.out.print("hi");

	}


}
