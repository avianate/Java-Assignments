// Nate Graham	A00305171


package cs5060.project.dragonmaze;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;




public class Grid 
{

	private GridCell[][] gridCellArray;

	private int numRows, numCols;
	private int timeLimit = 0;
	private boolean secondMove;
	private boolean gameOver;



	public Grid ()
	{
		// default constructor
	}



	public Grid(FileReader fileReader, Actor hero, Actor dragon, Actor exit) throws IOException
	{

		// loads the map file which was passed in from the World's load method
		BufferedReader reader = new BufferedReader(fileReader);

		// scanner is used to read the file header info
		Scanner input = new Scanner(reader.readLine());

		numRows = input.nextInt();
		numCols = input.nextInt();
		timeLimit = input.nextInt();
		
		// create the grid from contents of file
		gridCellArray = new GridCell[numRows][numCols];

		String line = null;
		int row = 0;

		while ((line = reader.readLine()) != null)
		{
			// create Actor from each char in line and set the Actor's location variables
			for (int column = 0; column < numCols; column++)
			{
				Actor actor = new Actor(line.charAt(column));
				actor.setLocation(row, column);

				// load actor into gridCellArray
				gridCellArray[row][column] = actor;

				switch (actor.getActor())
				{
				case 'H':
					World.setHero(actor);		// maintain a copy of the hero in World for quick access to hero's location
					break;
				case 'D':
					World.setDragon(actor);		// maintain a copy of the dragon in World for quick access to Dragon's location
					break;
				case 'E':
					World.setExit(actor);		// maintain a copy of the exit in World for quick access to Exit location

				default:
					break;
				}
			}

			row++;
		}
		
		// no status update to display after time limit and time step
		World.setProgressStatus(null);
		this.setGameOver(false);
	}






	public void moveLeft(Actor actor)
	{
		int row = actor.getRow();
		int column = actor.getColumn();
		char cellChar = '.';

		// if dragon stepped on key during previous move make dragon drop key where he found it
		if (actor.getActor() == 'D' && actor.getObject() == 'K')
		{
			cellChar = 'K';
			actor.setHasObject(false);
		}

		// check if actor can step on cell to the left
		if (actor.canStepOn(left(actor)))
		{
			// set the current position in grid to an empty space (or the key if Dragon stepped on it)
			gridCellArray[row][column] = new Actor(cellChar, row, column);

			// move actor location
			actor.setColumn(actor.getColumn() - 1);

			// move actor in grid
			gridCellArray[actor.getRow()][actor.getColumn()] = actor;

			// check if actor found the exit or dragon ate the hero
			gameOver(actor);
			
		}

		return;
	}






	public void moveRight(Actor actor)
	{
		int row = actor.getRow();
		int column = actor.getColumn();
		char cellChar = '.';


		// if dragon stepped on key during previous move make dragon drop key where he found it
		if (actor.getActor() == 'D' && actor.getObject() == 'K')
		{
			cellChar = 'K';
			actor.setHasObject(false);
		}

		// check if actor can step on cell to the left
		if (actor.canStepOn(right(actor)))
		{		
			// set the current position in grid to an empty space (or the key if Dragon stepped on it)
			gridCellArray[row][column] = new Actor(cellChar, row, column);

			// move actor location
			actor.setColumn(actor.getColumn() + 1);

			// move actor in grid
			gridCellArray[actor.getRow()][actor.getColumn()] = actor;

			// check if actor found the exit or dragon ate the hero
			gameOver(actor);
		}
	}






	public void moveUp(Actor actor)
	{
		int row = actor.getRow();
		int column = actor.getColumn();
		char cellChar = '.';

		// if dragon stepped on key during previous move make dragon drop key where he found it
		if (actor.getActor() == 'D' && actor.getObject() == 'K')
		{
			cellChar = 'K';
			actor.setHasObject(false);
		}

		// check if actor can step on cell to the left
		if (actor.canStepOn(up(actor)))
		{
			// set the current position in grid to an empty space (or the key if Dragon stepped on it)
			gridCellArray[row][column] = new Actor(cellChar, row, column);

			// move actor location
			actor.setRow(actor.getRow() - 1);

			// move actor in grid
			gridCellArray[actor.getRow()][actor.getColumn()] = actor;

			// check if actor found the exit or dragon ate the hero
			gameOver(actor);
		}
	}






	public void moveDown(Actor actor)
	{
		int row = actor.getRow();
		int column = actor.getColumn();
		char cellChar = '.';

		// if dragon stepped on key during previous move make dragon drop key where he found it
		if (actor.getActor() == 'D' && actor.getObject() == 'K')
		{
			cellChar = 'K';
			actor.setHasObject(false);
		}

		// check if actor can step on cell to the left
		if (actor.canStepOn(down(actor)))
		{
			// set the current position in grid to an empty space (or the key if Dragon stepped on it)
			gridCellArray[row][column] = new Actor(cellChar, row, column);

			// move actor location
			actor.setRow(actor.getRow() + 1);

			// move actor in grid
			gridCellArray[actor.getRow()][actor.getColumn()] = actor;

			// check if actor found the exit or dragon ate the hero
			gameOver(actor);
		}
	}






	public void skipTurn()
	{
		World.setProgressStatus("The Hero waits...");
	}






	public void moveDragon(Actor dragon)
	{
		findPath(dragon);

		// shortest path is found by backtracking from Hero to Dragon
		// create a stack for storing steps back to Dragon
		Stack<GridCell> path = new Stack<GridCell>();

		// start at Hero location and follow path back to dragon
		GridCell start = gridCellArray[World.getHero().getRow()][World.getHero().getColumn()];

		while (((Actor) start).getActor() != 'D')
		{
			path.push(start);

			int row = start.getPathRow();
			int column = start.getPathColumn();

			start = gridCellArray[row][column];
		}

		// get dragon's next step towards hero
		GridCell nextStep = path.pop();

		int nextRow = nextStep.getRow();
		int nextColumn = nextStep.getColumn();

		if (nextRow > dragon.getRow())
			moveDown((Actor) dragon);
		else if (nextRow < dragon.getRow())
			moveUp((Actor) dragon);
		else if (nextColumn > dragon.getColumn())
			moveRight((Actor) dragon);
		else if (nextColumn < dragon.getColumn())
			moveLeft((Actor) dragon);
		else
			return;
	}


	private void findPath(GridCell dragon)
	{
		// reset "known" flag on each cell so findPath will update when hero moves
		resetPath();

		// create a queue for shortest-path algorithm
		Queue<GridCell> q = new LinkedList<GridCell>();

		// set dragon distance to 0 and add to the queue
		dragon.setDistance(0);		// will be used to keep track of when breaking wall is best option (unimplemented)

		// setting the "known" flag prevents path-search algorithm from including this cell multiple times
		dragon.setKnown(true);		
		dragon.setPathLocation(dragon.getRow(), dragon.getColumn());
		q.add(dragon);

		// algorithm for unweighted shortest-path modified from Mark Allen Weis Data Structures & Algorithm Analysis, page 352, Figure 9.18
		while (!q.isEmpty())
		{
			GridCell testCell = q.remove();

			int row = testCell.getRow();
			int column = testCell.getColumn();

			// for each GridCell adjacent to testCell
			for (int index = 0; index < 4; index++)
			{
				// set adjacent cell
				GridCell adjacentCell;

				if (index == 0 && row > 0)
					adjacentCell = gridCellArray[row - 1][column];
				else if (index == 1 && column < numCols - 1)
					adjacentCell = gridCellArray[row][column + 1];
				else if (index == 2 && row < numRows - 1)
					adjacentCell = gridCellArray[row + 1][column];
				else if (index == 3 && column > 0)
					adjacentCell = gridCellArray[row][column - 1];
				else
					adjacentCell = null;

				if (adjacentCell != null)
				{

					// if adjacentCell has not been checked and is not a wall
					if (!adjacentCell.isKnown() && ((Actor) adjacentCell).getActor() != 'X')
					{
						adjacentCell.setDistance(testCell.getDistance() + 1);
						adjacentCell.setKnown(true);
						adjacentCell.setPathLocation(testCell.getRow(), testCell.getColumn());

						// dragon ate the hero :(
						if (((Actor) adjacentCell).getActor() == 'H')
							break;

						q.add(adjacentCell);
					}
				}
			}
		}
	}






	private void resetPath()
	{
		// must reset the "known" flag for each cell after the findPath() method is run or dragon won't find where the hero moved to
		for (int row = 0; row < numRows; row++)
			for (int column = 0; column < numCols; column++)
				gridCellArray[row][column].setKnown(false);
	}





	private Actor left(Actor actor) 
	{
		// get grid cell to the left
		if (actor.getColumn() > 0)
		{
			return (Actor) gridCellArray[actor.getRow()][actor.getColumn() - 1];
		}

		return null;
	}






	private Actor right(Actor actor)
	{
		// get the grid cell to the right
		if (actor.getColumn() < numCols - 1)
		{
			return (Actor) gridCellArray[actor.getRow()][actor.getColumn() + 1];
		}

		return null;
	}






	private Actor up(Actor actor)
	{
		// get the grid cell up
		if (actor.getRow() > 0)
		{
			return (Actor) gridCellArray[actor.getRow() - 1][actor.getColumn()];
		}

		return null;
	}






	private Actor down(Actor actor)
	{
		// get the grid cell down
		if (actor.getRow() < numRows - 1)
		{
			return (Actor) gridCellArray[actor.getRow() + 1][actor.getColumn()];
		}

		return null;
	}






	private void gameOver(Actor actor)
	{
		// if the HERO WON 
		if (actor.getActor() == 'H')
		{
			if (actor.getRow() == World.getExit().getRow() && actor.getColumn() == World.getExit().getColumn() && actor.getObject() == 'K')
			{
				setGameOver(true);
				
				World.setProgressStatus("The hero managed to escape from the dragon!");
				World.setGameOverStatus("SUCCESS");
			}
		}
		
		// if the DRAGON WON
		else if (actor.getRow() == World.getHero().getRow() && actor.getColumn() == World.getHero().getColumn())
		{
			setGameOver(true);

			World.setProgressStatus("Oh no! The hero was destroyed! All hope is lost...");
			World.setGameOverStatus("FAILURE");
		}
	}
	
	
	
	
	
	public void setSecondMove(boolean bool)
	{
		secondMove = bool;
	}
	
	
	
	
	
	public boolean secondMove()
	{
		return secondMove;
	}






	public void setGameOver(boolean status)
	{
		gameOver = status;
	}






	public boolean isGameOver() 
	{	
		return gameOver;
	}








	public void display() {

		for (int row = 0; row < numRows; row++)
		{	
			for (int column = 0; column < numCols; column++)
			{
				System.out.print(((Actor) gridCellArray[row][column]).getActor());
			}

			System.out.println();
		}

	}







	public int getTimeLimit() {

		return timeLimit;
	}




}
