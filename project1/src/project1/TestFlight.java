package project1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFlight
{

	@Test
	public void testDest()
	{
		Flight flight = new Flight('a', "1997");
		assertEquals(flight.getDestination(), 'a');
	}
	
	@Test
	public void testPrice()
	{
		Flight flight = new Flight('a', "1997");
		assertEquals(flight.getPrice(), 1997);
	}

}
