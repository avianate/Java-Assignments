// Nate Graham	A00305171


package cs5060.project.dragonmaze;


public class GridCell {

	private int row, column;
	private int pathRow, pathColumn;
	private int distance;				// used for finding the distance of cells during shortest-path algorithm
	private boolean known;				// flag used for shortest-path algorithm
	
	
	
	
	
	public GridCell() 
	{
		// init variables
		setLocation(-1, -1);
		setPathLocation(-1, -1);
		setKnown(false);
		setDistance(0);
	}
	
	
	
	
	
	public void setLocation(int row, int column)
	{
		this.setRow(row);
		this.setColumn(column);
	}
	
	
	
	
	

	public void setRow(int row)
	{
		this.row = row;
	}
	
	
	
	
	
	
	public void setColumn(int column)
	{
		this.column = column;
	}
	
	
	
	
	
	
	public int getRow()
	{
		return this.row;
	}
	
	
	
	
	
	
	public int getColumn()
	{
		return this.column;
	}
	
	
	
	
	
	
	public void setDistance(int pathDistance)
	{
		this.distance = pathDistance;
	}
	
	
	
	
	
	
	public int getDistance()
	{
		return this.distance;
	}
	
	
	
	
	
	
	public void setKnown(boolean bool)
	{
		this.known = bool;
	}
	
	
	
	
	
	
	public boolean isKnown()
	{
		return this.known;
	}
	
	
	
	
	
	
	public void setPathLocation(int row, int column)
	{
		this.pathRow = row;
		this.pathColumn = column;
	}
	
	
	
	
	
	
	public void setPathRow(int row)
	{
		this.pathRow = row;
	}
	
	
	
	
	
	
	public void setPathColumn(int column)
	{
		this.pathColumn = column;
	}
	
	
	
	
	
	
	public int getPathRow()
	{
		return this.pathRow;
	}
	
	
	
	
	
	
	public int getPathColumn()
	{
		return this.pathColumn;
	}
	
	
	
	
	
	
	
}
