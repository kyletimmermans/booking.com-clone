package application;

public class cities 
{
	String name;
	String type;
	int rating;
	float price;

	public cities(String name, String type, int rating, float price)
	{
		this.name = name;
	    this.type = type;
	    this.rating = rating;
	    this.price = price;
	}
	
	public void setName(String n)
	{
		this.name = n; 
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setType(String t)
	{
		this.type = t; 
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setRating(int r)
	{
		this.rating = r;
	}
	
	public int getRating()
	{
		return rating;
	}
	
	public void setPrice(float p)
	{
		if(price >= 0)
		{
			this.price = p; 
		}
	}
	
	public float getPrice()
	{
		return price;
	}
}