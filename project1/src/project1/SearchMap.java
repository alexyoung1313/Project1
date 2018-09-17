package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SearchMap 
{
	public static void main (String[] args)
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader("inputfile.txt");
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		Map <Character, Vector<Flight> > flights = new HashMap<Character, Vector<Flight> >();
		String line;
		char origin = '1';
		try
		{
			line = br.readLine();
			line = line.replaceAll("\\s","");
			origin = line.charAt(0);
			line = br.readLine();
			while(line != null)
			{
				line = line.replaceAll("\\s","");
				char dept = line.charAt(0);
				char dest = line.charAt(1);
				String price = line.substring(2);
				Flight tempFlight = new Flight(dest, price);
				if(flights.containsKey(dept))
				{
					flights.get(dept).addElement(tempFlight);
				}
				else
				{
					Vector<Flight> tempVec = new Vector<Flight>();
					tempVec.add(tempFlight);
					flights.put(dept, tempVec);
				}
				line = br.readLine();
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		FlightMap fmap = new FlightMap(origin, flights);
		Vector<Vector<String> > results = fmap.findPaths();
		
		FileOutputStream fos;
		try
		{
			fos = new FileOutputStream("outputfile.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Writer writer = new BufferedWriter(osw);
			writer.flush();
			writer.write("Destination    Flight Route from " + origin + "   Total Cost \n");
			for(int i = 0; i < results.size(); i++)
			{
				Vector<String> tempDest = results.get(i);
				String writeLine = tempDest.get(0) +"              ";
				int count = 22;
				for(int j = 0; j < tempDest.get(1).length(); j++)
				{
					count = count - 2;
					writeLine += tempDest.get(1).charAt(j) + ",";
				}
				for(int j = 0; j < count; j++)
				{
					writeLine += " ";
				}
				writeLine += "$" + tempDest.get(2) + "\n";
				writer.write(writeLine);
				writer.flush();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		//close the files
	}
}
