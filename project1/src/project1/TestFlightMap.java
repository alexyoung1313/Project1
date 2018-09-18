package project1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.Test;

public class TestFlightMap
{

	
	@Test
	public void testDest()
	{
		Map <Character, Vector<Flight> > flights = new HashMap<Character, Vector<Flight> >();
		char origin = 'P';
		Vector<Flight> pdest = new Vector<Flight>();
		Vector<Flight> rdest = new Vector<Flight>();
		Vector<Flight> qdest = new Vector<Flight>();
		Vector<Flight> wdest = new Vector<Flight>();
		Vector<Flight> sdest = new Vector<Flight>();
		Vector<Flight> tdest = new Vector<Flight>();
		Vector<Flight> ydest = new Vector<Flight>();
		pdest.add(new Flight('W', "200"));
		pdest.add(new Flight('R', "300"));
		rdest.add(new Flight('X', "200"));
		qdest.add(new Flight('X', "375"));
		wdest.add(new Flight('S', "250"));
		sdest.add(new Flight('T', "300"));
		tdest.add(new Flight('W', "350"));
		wdest.add(new Flight('Y', "500"));
		ydest.add(new Flight('Z', "450"));
		ydest.add(new Flight('R', "600"));
		flights.put('P', pdest);
		flights.put('Q', qdest);
		flights.put('R', rdest);
		flights.put('S', sdest);
		flights.put('T', tdest);
		flights.put('W', wdest);
		flights.put('Y', ydest);
		
		FlightMap fm = new FlightMap(origin, flights);
		Vector<Vector<String> > results = fm.findPaths();
		//vector of strings for answers
		String answer = "WSTYZRX";
		String result = "";
		for(int i = 0; i < results.size(); i++)
		{
			result += results.get(i).get(0);
		}
		
		assertEquals(answer, result);
		

	}
		@Test
		public void testPath()
		{
			Map <Character, Vector<Flight> > flights = new HashMap<Character, Vector<Flight> >();
			char origin = 'P';
			Vector<Flight> pdest = new Vector<Flight>();
			Vector<Flight> rdest = new Vector<Flight>();
			Vector<Flight> qdest = new Vector<Flight>();
			Vector<Flight> wdest = new Vector<Flight>();
			Vector<Flight> sdest = new Vector<Flight>();
			Vector<Flight> tdest = new Vector<Flight>();
			Vector<Flight> ydest = new Vector<Flight>();
			pdest.add(new Flight('W', "200"));
			pdest.add(new Flight('R', "300"));
			rdest.add(new Flight('X', "200"));
			qdest.add(new Flight('X', "375"));
			wdest.add(new Flight('S', "250"));
			sdest.add(new Flight('T', "300"));
			tdest.add(new Flight('W', "350"));
			wdest.add(new Flight('Y', "500"));
			ydest.add(new Flight('Z', "450"));
			ydest.add(new Flight('R', "600"));
			flights.put('P', pdest);
			flights.put('Q', qdest);
			flights.put('R', rdest);
			flights.put('S', sdest);
			flights.put('T', tdest);
			flights.put('W', wdest);
			flights.put('Y', ydest);
			
			FlightMap fm = new FlightMap(origin, flights);
			Vector<Vector<String> > results = fm.findPaths();
			//vector of strings for answers
			String answer = "PWPWSPWSTPWYPWYZPWYRPWYRX";
			String result = "";
			for(int i = 0; i < results.size(); i++)
			{
				result += results.get(i).get(1);
			}
			
			assertEquals(answer, result);
		}
		
		@Test
		public void testPrice()
		{
			Map <Character, Vector<Flight> > flights = new HashMap<Character, Vector<Flight> >();
			char origin = 'P';
			Vector<Flight> pdest = new Vector<Flight>();
			Vector<Flight> rdest = new Vector<Flight>();
			Vector<Flight> qdest = new Vector<Flight>();
			Vector<Flight> wdest = new Vector<Flight>();
			Vector<Flight> sdest = new Vector<Flight>();
			Vector<Flight> tdest = new Vector<Flight>();
			Vector<Flight> ydest = new Vector<Flight>();
			pdest.add(new Flight('W', "200"));
			pdest.add(new Flight('R', "300"));
			rdest.add(new Flight('X', "200"));
			qdest.add(new Flight('X', "375"));
			wdest.add(new Flight('S', "250"));
			sdest.add(new Flight('T', "300"));
			tdest.add(new Flight('W', "350"));
			wdest.add(new Flight('Y', "500"));
			ydest.add(new Flight('Z', "450"));
			ydest.add(new Flight('R', "600"));
			flights.put('P', pdest);
			flights.put('Q', qdest);
			flights.put('R', rdest);
			flights.put('S', sdest);
			flights.put('T', tdest);
			flights.put('W', wdest);
			flights.put('Y', ydest);
			
			FlightMap fm = new FlightMap(origin, flights);
			Vector<Vector<String> > results = fm.findPaths();
			//vector of strings for answers
			String answer = "200450750700115013001500";
			String result = "";
			for(int i = 0; i < results.size(); i++)
			{
				result += results.get(i).get(2);
			}
			
			assertEquals(answer, result);
		}
		
		/*Destination    Flight Route from P   Total Cost 
		W              P,W,                  $200
		S              P,W,S,                $450
		T              P,W,S,T,              $750
		Y              P,W,Y,                $700
		Z              P,W,Y,Z,              $1150
		R              P,W,Y,R,              $1300
		X              P,W,Y,R,X,            $1500
		*/

}
