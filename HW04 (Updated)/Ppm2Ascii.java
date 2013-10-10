// Nate Graham	A00305171



import java.io.*;

public class Ppm2Ascii extends AsciiImage {

	static String inputFile = null, threshold = null;
	String[] headerInfo = null;
	static int width, height, widthIndex = 0, heightIndex = 0;


	private static void printHelpAndExit() 
	{
		System.out.println("\nparameters:\n" + "\t input_file_name [option] [threshold value]");
		System.out.println("options: \n" + "\t -t\t threshold value");

		System.exit(1);
	}



	//************************************************************************************
	//				MAIN PROGRAM
	//************************************************************************************	


	public static void main(String[] args) throws IOException {

		Image myImage = new Image();
		AsciiImage myAsciiImage = new AsciiImage();

		// get args
		try
		{
			int i = 0;

			// get input file name
			if (i < args.length)
			{
				inputFile = args[i];
				i++;
			}
			// check for -t option
			if (i < args.length && args[i].equals("-t"))
			{
				i++;
				threshold = args[i++];
			}
			else if (i < args.length)
			{
				printHelpAndExit();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}


		// load file then get ppm header info then convert
		if (inputFile != null)
		{
			if (myImage.loadFile(inputFile))
			{
				myAsciiImage.load(myImage, threshold);
				myAsciiImage.display();
			}
			else
				System.out.println("Error reading file. Check file type is \"P3\"");
				
		}
		else
			printHelpAndExit();

	}
}