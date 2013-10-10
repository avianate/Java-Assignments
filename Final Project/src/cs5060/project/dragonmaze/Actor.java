// Nate Graham	A00305171



package cs5060.project.dragonmaze;


// an Actor is a GridCell so Actor inherits from GridCell
public class Actor extends GridCell {


	private char actorType;
	private char objectType;		// which object the hero has
	private boolean hasObject;		// hero has an object
	private boolean hasEnergy;		// hero got the energy drink
	private int energyCount;		// hero can move twice per turn for 10 turns after getting energy drink


	public Actor()
	{
		this.hasObject = false;
		this.hasEnergy = false;
		this.energyCount = 0;
	}







	public Actor(char type) 
	{	
		this.actorType = type;
		this.hasObject = false;
		this.hasEnergy = false;
		this.energyCount = 0;
	}






	public Actor (char type, int row, int column)
	{
		setActor(type);
		setRow(row);
		setColumn(column);
		
		this.hasObject = false;
	}







	public void setActor(char type)
	{
		this.actorType = type;
	}







	public char getActor()
	{
		return this.actorType;
	}
	
	
	
	
	
	
	public void pickUpObject(char gameObject)
	{
		this.objectType = gameObject;
		this.setHasObject(true);
	}
	
	
	
	
	
	
	public void setHasObject(boolean bool)
	{
		this.hasObject = bool;
	}
	
	
	
	
	
	
	public char getObject()
	{
		if (this.hasObject)
			return this.objectType;
		else
			return '!';
	}
	
	
	
	
	
	
	public void setHasEnergy(boolean bool)
	{
		if (bool)
			this.setEnergyCount(10);
		
		this.hasEnergy = bool;
	}
	
	
	
	
	
	
	public boolean hasEnergy()
	{
		if (this.getEnergyCount() == 0)
			this.setHasEnergy(false);
		
		return hasEnergy;
	}
	
	
	
	
	
	
	public void setEnergyCount(int count)
	{
		this.energyCount = count;
	}
	
	
	
	
	public int getEnergyCount()
	{
		return this.energyCount;
	}






	public boolean canStepOn(Actor cell)
	{	
//		if (cell != null)
//		{
			// which actor is calling the method
			char actor = this.getActor();
			
			// which cell is being checked
			char cellActor = cell.getActor();
			
		
			
			if (actor == 'H')
			{
				// if hero is moving to empty space or hero has key and is moving to exit
				if (cellActor == '.' || (cellActor == 'E' && this.getObject() == 'K'))
					return true;
				
				// hero can get key
				else if (cellActor == 'K')
				{
					this.pickUpObject(cell.getActor());
					return true;
				}
				
				// hero can get energy drink
				else if (cellActor == 'e')
				{
					setHasEnergy(true);
					return true;
				}
			}

			else if (actor == 'D')
			{
				// dragon can step on the key
				if (cellActor == '.' || cellActor == 'H' || cellActor == 'K')
				{
					if (cellActor == 'K')
						this.pickUpObject(cell.getActor());
					
					return true;
				}
			}
//		}

		return false;
	}





}
