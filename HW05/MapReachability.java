// Nate Graham	A00305171



import java.util.Scanner;


public class MapReachability {

	private static final char GOAL = 'G';
	private static final char WALL = 'X';
	private static final char FOOTPRINT = 'F';


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numberOfTestCases = input.nextInt();

		for (int testCase = 0; testCase < numberOfTestCases; testCase++)
		{

			int rows = input.nextInt();
			int columns = input.nextInt();

			input.nextLine();

			int startX = 0, startY = 0;

			char map[][] = new char[rows][columns];

			for (int r = 0; r < rows; r++)
			{
				String nextRow = input.nextLine();

				for (int c = 0; c < columns; c++)
				{

					map[r][c] = nextRow.charAt(c);

					if (nextRow.charAt(c) == 'S' || nextRow.charAt(c) == 's')
					{
						startX = r;
						startY = c;
					}
				}
			}


			if (solveMap(map, rows, columns, startX, startY))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}



	static boolean solveMap(char map[][], int rows, int cols, int x, int y)
	{
		boolean found;
		
		if (x < 0 || x >= rows || y < 0 || y >= cols)
			return false;

		if (map[x][y] == GOAL) 
		{
			found = true;
		}

		else if (map[x][y] == WALL)
			found = false;
		else if (map[x][y] == FOOTPRINT)
			found = false;
		else 
		{
			map[x][y] = FOOTPRINT;
			found = solveMap(map, rows, cols, x-1, y) || solveMap(map, rows, cols, x+1, y) || solveMap(map, rows, cols, x, y-1) || solveMap(map, rows, cols, x, y+1);
		}

		return found;
	}
}


