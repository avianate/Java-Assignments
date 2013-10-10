// Nate Graham	A00305171


package cs5060.project.dragonmaze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;



public class DragonMaze {

	public DragonMaze() 
	{
		// default constructor
	}


	public static void main(String[] args) 
	{
		// set up scanner for getting keyboard input
		Scanner input = new Scanner(System.in);
		
		int option = 0;

		while (option != 5)
		{
			System.out.println("\n1. Load a maze");
			System.out.println("2. Generate a random maze");
			System.out.println("3. Instructions on how to play");
			System.out.println("4. About");
			System.out.println("5. Exit");
			System.out.print("\n\nSelect an option above: ");

			// try/catch block will keep prompting user until a correct number is entered
			try
			{
				option = input.nextInt();
			}
			catch (InputMismatchException e)
			{
				input.next();
				option = 0;
			}

			switch (option)
			{
			case 1:
				loadMap();
				break;

			case 2:
				generateMap();
				break;

			case 3:
				help();
				break;

			case 4:
				about();
				break;

			case 5:
				// exit (after break statement below)

			default:
				break;
			}

		}

	}
	
	
	
	
	
	
	

	private static void about() 
	{
		loadFile("about.txt");
	}
	
	
	
	
	
	

	private static void help() 
	{
		loadFile("help.txt");
	}
	
	
	
	

	private static void generateMap() 
	{
		// unimplemented
	}
	
	
	
	

	private static void loadMap() {

		// create new world, load map and play game
		World world = new World();
		world.loadMap();

		// game loop
		while (world.getGameInProgress())
		{
			world.nextMove();
			world.updateMap();

		}

		// game over
		//	world.updateMap();

		// return to menu

	}
	
	
	
	
	
	
	private static void loadFile(String file)
	{
		String fileName = "bin/cs5060/project/dragonmaze/files/" + file;
		
		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}




}
