
public class Event
{
	public boolean deletion;
	public int position;
	public String change; 
	
	public Event(boolean deletion, int position, String change)
	{
		this.deletion = deletion;
		this.position = position;
		this.change = change;
	}
}
