package project1;

/**
 * Flight class that will hold a destination and the price to get to that destination
 * @author alexyoung
 *
 */
public class Flight
{
	private char destination; 
	private int price;
	

	/**
	 * Constructor that creates a flight object with a destination and price
	 * @param dest char of destination
	 * @param pri String that will be parsed to an int
	 */
	public Flight(char dest, String pri)
	{
		destination = dest;
		price = Integer.parseInt(pri);
	}

	/**
	 * Getter function for Destination
	 * @return destination
	 */
	public char getDestination()
	{
		return destination;
	}

	/**
	 * Getter function for price
	 * @return price
	 */
	public int getPrice()
	{
		return price;
	}
	
	
}
