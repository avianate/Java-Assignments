// Nate Graham	A00305171


package cs5060.project.dragonmaze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class World 
{

	private Grid worldGrid;
	
	private static Actor HERO = new Actor();
	private static Actor EXIT = new Actor();
	private static Actor DRAGON = new Actor();

	private boolean gameInProgress;
	private int currentTime;
	private static int timeLimit;
	private static String progressStatus;
	private static String gameOverStatus;

	Scanner input = new Scanner(System.in);



	public World()
	{
		// default constructor
	}



	public void loadMap()
	{	
		String path = "bin/cs5060/project/dragonmaze/maps";

		boolean done = false;
		
		// loop for correct file name
		while (!done)
		{
			try 
			{	// list the available files to choose from
				System.out.println("\nAvailable maps to choose from: \n");
				
				listFiles(path);
				System.out.print("\nEnter file name of map to load (including the extension .txt): ");

				String fileName = path + "/" + input.nextLine();
				FileReader fileReader = new FileReader(fileName);

				// correct file name entered, create the Grid
				done = true;

				// can throw an IOException to be caught below
				worldGrid = new Grid(fileReader, HERO, DRAGON, EXIT);
				System.out.println();
			}
			catch (FileNotFoundException e) 
			{
				System.out.println("ERROR: File not found!");
			} 
			catch (IOException e) 
			{
				System.out.println("Error loading map");
				e.printStackTrace();
			}

		}	// end while loop
		
		
		// initialize variables
		
		setProgressStatus(null);
		setGameOverStatus(null);
		setGameInProgress(true);
		timeLimit = worldGrid.getTimeLimit();
		currentTime = 0;
		updateMap();

	}






	private void listFiles(String path)
	{
		// open directory
		File dir = new File(path);

		// place directory files in files array
		File[] files = dir.listFiles();

		// print file names in directory for convenience
		if (dir.isDirectory());
		{
			for (int i = 0; i < files.length; i++)
			{
				if (files[i].getName().endsWith(".txt"))
					System.out.println(files[i].getName());
			}
		}
	}







	private void setGameInProgress(boolean bool) 
	{
		this.gameInProgress = bool;
	}







	public boolean getGameInProgress()
	{
		// if game time limit is set to zero game has infinite number of turns
		if (currentTime >= timeLimit && timeLimit != 0)
		{
			setGameOverStatus("FAILURE");
			worldGrid.setGameOver(true);
		}
		
		return this.gameInProgress;
	}







	public void nextMove()
	{
		char option = input.next().charAt(0);

		switch (option)
		{
		case 'l':
		case 'L':
			worldGrid.moveLeft(HERO);
			break;

		case 'r':
		case 'R':
			worldGrid.moveRight(HERO);
			break;

		case 'u':
		case 'U':
			worldGrid.moveUp(HERO);
			break;

		case 'd':
		case 'D':
			worldGrid.moveDown(HERO);
			break;

		case 'w':
		case 'W':
			worldGrid.skipTurn();
			break;

		case 'q':
		case 'Q':
			quit();

		case 'h':
		case 'H':
			
		default:
			this.help();
			return;
		}
		
		
		
		
		// recursive function for moving hero twice per turn for energy drink
		if (HERO.hasEnergy() && !worldGrid.secondMove())
		{
			worldGrid.setSecondMove(true);
			updateMap();
			nextMove();
		}
		
		// hero has no energy drink or has already taken first turn
		else
		{
			worldGrid.setSecondMove(false);
			HERO.setEnergyCount(HERO.getEnergyCount() - 1);
			worldGrid.moveDragon(DRAGON);
			currentTime++;
		}
		
		// if hero found the exit or dragon ate the hero then the game is over
		if (worldGrid.isGameOver())
		{
			setGameInProgress(false);
			return;
		}
	}
	
	
	
	
	
	
	public static void setHero(Actor hero)
	{
		HERO = hero;
	}
	
	
	
	
	
	
	public static Actor getHero()
	{
		return HERO;
	}
	
	
	
	
	
	
	public static void setDragon(Actor dragon)
	{
		DRAGON = dragon;
	}
	
	
	
	
	
	
	public static Actor getDragon()
	{
		return DRAGON;
	}
	
	
	
	
	
	
	public static void setExit(Actor exit)
	{
		EXIT = exit;
	}
	
	
	
	
	
	
	public static Actor getExit()
	{
		return EXIT;
	}
	
	
	
	
	
	
	public static void setProgressStatus(String status)
	{
		progressStatus = status;
	}
	
	
	
	
	
	
	public static void setGameOverStatus(String status)
	{
		gameOverStatus = status;
	}
	
	
	
	
	
	
	public void updateMap() 
	{
		// display the time limit and time step
		System.out.println("\nTime Limit: " + timeLimit);
		System.out.println("Current Time: " + currentTime + "\n");
		
		// don't print status updates if they are null
		if (progressStatus != null)
			System.out.println(progressStatus);
		
		// line for extra space between time/status and the grid
		System.out.println();
		
		// display the current state of the grid
		worldGrid.display();
		
		// line for extra space
		System.out.println();
		
		// if game is over display the status: SUCCESS or FAILURE below the grid
		if (gameOverStatus != null)
			System.out.println(gameOverStatus);
	}







	private void help() 
	{
		// help menu displayed whenever an invalid key is pressed during game play
		
		System.out.println("Use the following commands to move: ");
		System.out.println("\nMove Left:  L");
		System.out.println("Move Right: R");
		System.out.println("Move Up:    U");
		System.out.println("Move Down:  D");
		System.out.println("Skip Turn:  W");
		System.out.println("Quit Game:  Q");
		System.out.println("Help:       H\n");
	}







	private void quit() 
	{	
		setGameInProgress(false);
	}







}
