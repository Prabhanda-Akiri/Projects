
package FlightDetails;

public class Flight
{
	public String Boarding,Destination;
	public double DepTime,ArrTime;
	public double Fare;
	public int FlightNumber;

	public Flight(String b,String d,int fno,double dt,double at,double fare)
	{
		Boarding=b;
		Destination=d;
		FlightNumber=fno;
		DepTime=dt;
		ArrTime=at;
		Fare=fare;

	}

}
