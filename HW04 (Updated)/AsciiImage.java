// Nate Graham	A00305171

// parts of this code are based on ideas from the following source: 
// http://help.adobe.com/en_US/as3/dev/WS5b3ccc516d4fbf351e63e3d118a9b90204-7eee.html




import java.io.IOException;


public class AsciiImage extends Image {
	
	public static String asciiPalette = "@#$%&8BMW*mwqpdbkhaoQ0OZXYUJCLtfjzxnuvcr[]{}1()|/?Il!i><+_~-;,. ";
	
	char asciiData[];
	int width, height, length;

	// load file from Image class and manipulate for AsciiImage
	public void load(Image src, String threshold) throws IOException {

		length = src.width * src.height;
		int r, g, b, rgbAverage;
		char asciiCharacter = 0;
		asciiData = new char[length];
		
		width = src.width;
		height = src.height;
		
				// parse the RGB values as integers and store in respective variable
				for (int i = 0; i < length; i++)
				{
					r = src.rgbPixels[i].r;
					g = src.rgbPixels[i].g;
					b = src.rgbPixels[i].b;

					rgbAverage = (r + g + b);

					if (threshold == null)
					{
						// convert the rbgAverage into one of 64 "shades" of ascii characters
						int charIndex = (int) Math.floor(rgbAverage / 4);
						asciiCharacter = asciiPalette.charAt(charIndex);
					}
					else
					{
						// insert threshold conversion
						if (rgbAverage > (Integer.parseInt(threshold)))
							asciiCharacter = ' ';
						else
							asciiCharacter = '@';
					}
					// store ascii "pixel" in asciiData array
					asciiData[i] = asciiCharacter;	
				}
			
	}

	
	
	public void display()
	{
		for (int i = 0, widthIndex = 1; i < length; i++, widthIndex++)
		{
			if (widthIndex < width)
			{
				System.out.print(asciiData[i]);
			}
			else
			{
				// end of line has been reached.
				// start printing on new line and reset widthIndex
				System.out.print("\n" + asciiData[i]);
				widthIndex = 0;
			}
		}
	}
}
