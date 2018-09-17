package project1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class FlightMap 
{
	private Map <Character, Vector<Flight> > flights;
	char origin;
	Vector<Vector<String> > destinations;
	Set<Character> reached;
	
	public FlightMap(char originArg, Map <Character, Vector<Flight> > flightsArg)
	{
		this.origin = originArg;
		this.flights = flightsArg;
		destinations = new Vector<Vector<String> >();
		reached = new HashSet<Character>();
	}
	
	public Vector<Vector<String> > findPaths()
	{
		String path = origin + "";
		int pathCost = 0;
		reached.add(origin);
		dfs(origin, path, pathCost);
		return destinations;	
	}
	
	private void dfs(char c, String path, int pathCost)
	{
		if(!flights.containsKey(c))
		{
			return;
		}
		Vector<Flight> flightVec = flights.get(c);
		for(int i = 0; i < flightVec.size(); i++)
		{
			Flight tempFlight = flightVec.get(i);
			char tempDest = tempFlight.getDestination();
			if(!reached.contains(tempDest))
			{
				Vector<String> tempResult = new Vector<String>();
				tempResult.add(tempDest+"");
				tempResult.add(path+tempDest);
				int tempCost = pathCost + tempFlight.getPrice();
				tempResult.add(Integer.toString(tempCost));
				destinations.addElement(tempResult);
				reached.add(tempDest);
				dfs(tempDest, path + tempDest, tempCost);
			}
		}
	}
}
