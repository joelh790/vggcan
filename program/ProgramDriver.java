package program;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class ProgramDriver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EventWorld world= new EventWorld(); // new map of events
		Scanner in = new Scanner(System.in);
		System.out.println("Enter co-ordinates:");
		String input= in.nextLine(); //input of co-ordinates is taken from the user
		String[] coordinates= input.split(",");
		int x1=Integer.parseInt(coordinates[0]);
		int y1=Integer.parseInt(coordinates[1]);
		
		for(int i=0; i<world.getEventList().size(); i++)
		{
			world.getEventList().get(i).calculateSubjectDistance(x1,y1); //distance is calculated between each event and the users co-ordinates
			
		}
		
		
		ArrayList<VggEvent> events= world.getEventList();
		Collections.sort(events); //events are sorted by the shortest distance from the user in ascending order
		for (int j=0; j<5; j++)
		{
			System.out.println(events.get(j).toString()); //first 5 are printed
		}
		
	}
	
	
}
