package program;

import java.util.ArrayList;
import java.lang.*;
import java.util.Comparator;
import java.util.Random;

public class VggEvent implements Comparable {
	
	private int id;
	private int x;
	private int y;
	private ArrayList<Double> prices;
	private int subjectDistance; 
	
	public VggEvent()
	{
		int max= 10;     
		int min= -10;
		int range= max-min+1;
		int randX= (int)(Math.random()* range)+min;
		setX(randX);
		int randY= (int)(Math.random()* range)+min;
		setY(randY);	// Generated random co-ordinates between -10 and 10;
		
		ArrayList<Double> rPrices= new ArrayList<Double>();
		for(int i=0; i<3; i++)
		{
			double maxPrice=99.99;
			double minPrice=1.00;	
			double priceRange= maxPrice-minPrice+1;
			double randPrice= (double)(Math.random()* priceRange)+minPrice;
			randPrice= Math.floor(randPrice * 100)/100;
			rPrices.add(randPrice); //Generates 3 random prices between 1 and 99.99
		}
		
		setPrices(rPrices);
	}

	public VggEvent(int x, int y, ArrayList<Double> prices){
		this.id=id;
		this.x=x;
		this.y=y;
		this.prices= prices;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x<=10||x>=-10) //Range can be increased for a larger world size
		{
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y<=10||y>=-10)
		{
		this.y = y;
		}
	}

	public ArrayList<Double> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Double> prices) {
		this.prices = prices;
		
	}
	
	public double cheapestPrice(){ //calculates the cheapest ticket price for each event
		double min=prices.get(0);
		for(int i=0; i<prices.size(); i++)
		{
			if(prices.get(i)<min)
				min=prices.get(i);
		}
		
		return min;
	}
	
	
	public void calculateSubjectDistance(int sx1,int sy1)
	{
		//Manhattan Distance: |y2-y1| + |x2-x1|
		int yvalue= this.y- sy1;
		if(yvalue<0){
			yvalue=yvalue*-1;
		}
		int xvalue= this.x- sx1;
		if(xvalue<0){
			xvalue=xvalue*-1;
		}
		
		int subjectDistance= xvalue+ yvalue;
		setSubjectDistance(subjectDistance);
	}

	public int getSubjectDistance() {
		return subjectDistance;
	}

	public void setSubjectDistance(int subjectDistance) {
		this.subjectDistance = subjectDistance;
	}

	@Override
	public String toString() {
		return "Event " + id + "- $" + this.cheapestPrice() + ", Distance " + getSubjectDistance(); //String that is printed for the output
	}
	

	@Override
	public int compareTo(Object compareEvent) { //used to object can be compared by closest distance
		VggEvent compareEventt= (VggEvent) compareEvent;
		int compareDistance= (int)compareEventt.getSubjectDistance();
		return (int) (this.getSubjectDistance()-compareDistance);
		
	}

	
	
	
	

}

