package program;

import java.util.ArrayList;

public class EventWorld {
	
	private ArrayList<VggEvent> EventList;

	
	//list of events on the map
	public EventWorld() {
		// TODO Auto-generated constructor stub
		int eventCount=50; 
		EventList= new ArrayList<VggEvent>(); //generates a maximum of 50 events, only if each event is placed in a free set of co-ordinates
		for(int i=0; i<50; i++)
		{
			boolean free= true;
			VggEvent e = new VggEvent();
			e.setId(i+1); // id is set for each event
			EventList.add(e);
			for(int j=0; j<EventList.size();j++) //this check can be removed to support multiple events in one location
			{
				if(e.getX()== EventList.get(j).getX())
				{
					if(e.getY()==EventList.get(j).getY());
					{
					free=false;
					}
				}
			}
			if(free==true)
			EventList.add(i,e);
			
		}
	}
	
	public ArrayList<VggEvent> getEventList() {
		return EventList;
	}

	public void setEventList(ArrayList<VggEvent> eventList) {
		EventList = eventList;
	}

}
