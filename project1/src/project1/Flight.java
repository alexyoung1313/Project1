package project1;

public class Flight
{
	private char destination; 
	private int price;
	
	public Flight(char dest, String pri)
	{
		destination = dest;
		price = Integer.parseInt(pri);
	}

	public char getDestination()
	{
		return destination;
	}

	public int getPrice()
	{
		return price;
	}
	
	
}
