package project1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Flight map will store the data of the flights, their destinations, and price
 * and then conduct a depth-first search to find all possible destinations,
 * the path to them and the price of that path.
 * @author alexyoung
 *
 */
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
	
	/**
	 * helper function for dfs that can be called on an instance of the class FLightMap.
	 * Creates variable for use in dfs.
	 * @return a vector of destinations, paths, and prices all in String format
	 */
	public Vector<Vector<String> > findPaths()
	{
		String path = origin + "";
		int pathCost = 0;
		reached.add(origin);
		dfs(origin, path, pathCost);
		return destinations;	
	}
	
	/**
	 * Will implement a depth first search on all flight from the origin
	 * and will record all destinations reach, the path to get there, and
	 * the price to get there.
	 * @param c the current city dfs is looking at
	 * @param path the path from the origin to the current city
	 * @param pathCost the cost from the origin to the current city
	 */
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
