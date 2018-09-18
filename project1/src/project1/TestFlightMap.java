package project1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.Test;

public class TestFlightMap
{

	@Test
	public void test()
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
		/*P W 200
		/P R 300
		/R X 200
		/Q X 375
		/W S 250
		/S T 300
		/T W 350
		/W Y 500
		Y Z 450
		Y R 600*/
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
		Vector<Vector<String> > answers = new Vector<Vector<String> >();
		//vector of strings for answers
		Vector<String> wanswer = new Vector<String>();
		Vector<String> sanswer = new Vector<String>();
		Vector<String> tanswer = new Vector<String>();
		Vector<String> ranswer = new Vector<String>();
		Vector<String> yanswer = new Vector<String>();
		Vector<String> zanswer = new Vector<String>();
		Vector<String> xanswer = new Vector<String>();
		//w
		wanswer.add("W");
		wanswer.add("PW");
		wanswer.add("200");
		//s
		sanswer.add("S");
		sanswer.add("PWS");
		sanswer.add("450");
		//t
		tanswer.add("T");
		tanswer.add("PWST");
		tanswer.add("750");
		//r
		ranswer.add("R");
		ranswer.add("PWYR");
		ranswer.add("1300");
		//y
		yanswer.add("Y");
		yanswer.add("PWY");
		yanswer.add("700");
		//z
		zanswer.add("Z");
		zanswer.add("PWYZ");
		zanswer.add("1150");
		//x
		xanswer.add("X");
		xanswer.add("PWYRX");
		xanswer.add("1500");
		
		answers.add(wanswer);
		answers.add(sanswer);
		answers.add(tanswer);
		answers.add(yanswer);
		answers.add(zanswer);
		answers.add(ranswer);
		answers.add(xanswer);

		assertEquals(results, answers);
		
		
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

}
