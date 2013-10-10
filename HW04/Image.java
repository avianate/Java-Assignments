// Nate Graham	A00305171


import java.io.*;

public class Image {

	public class Pixel
	{
		int r, g ,b;
	}

	File myFile;
	FileReader fileReader;
	BufferedReader reader;
	public Pixel[] rgbPixels;
	int width, height;



	public boolean loadFile(String inputFile) throws IOException 
	{

		myFile = new File(inputFile);
		fileReader = new FileReader (myFile);
		reader = new BufferedReader(fileReader);


		// load header info
		String headerLine = reader.readLine();
		String[] headerInfo = null;

		if (!headerLine.equalsIgnoreCase("P3"))
		{
			return false;
		}

		headerLine = reader.readLine();

		if (headerLine.startsWith("#"))
			// comment line was read. Next line has size, width and max color value
			headerInfo = reader.readLine().split(" ");
		else
			headerInfo = headerLine.split(" ");

		// get width and height (max color value is ignored)		
		width = Integer.parseInt(headerInfo[0]);
		height = Integer.parseInt(headerInfo[1]);
		rgbPixels = new Pixel[width*height];
		
		for (int i = 0; i < rgbPixels.length; i++)
		{
			rgbPixels[i] = new Pixel();
		}

		boolean ret = parse();

		reader.close();
		fileReader.close();

		return ret;
	}






	private boolean parse() throws IOException {

		String ppmLine = reader.readLine();	
		
		int pixelIndex = 0;
				
		while (ppmLine != null)
		{
			// place RBG values into a string array
			String[] rgbValue = ppmLine.split(" ");
			
			// parse the RGB values as integers and store in respective variable
			for (int i = 0; i < rgbValue.length; i+=3)
			{
				rgbPixels[pixelIndex].r = (int) (Integer.parseInt(rgbValue[i]) * .21);
				rgbPixels[pixelIndex].g = (int) (Integer.parseInt(rgbValue[i+1]) * .71);
				rgbPixels[pixelIndex].b = (int) (Integer.parseInt(rgbValue[i+2]) * .08);
				
				pixelIndex++;
			}

			ppmLine = reader.readLine();
		}

		return true;
	}
}