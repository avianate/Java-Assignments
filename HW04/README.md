Homework4 
ASCIIimage 

CS5060 IntensiveProgramming,Fall2012 
57points 
Due: 3:59pmOctober 5,2012 

Mainprogram. 

Create aprogram Ppm2Ascii that reads appmimageand outputstheimageusing ASCII characters.The output image should be written to the standard output stream. 
Create an Image class and an AsciiImage class. Make sure your Ppm2Ascii program has a method to load the ppm Image, and also method to convert the ppm Image to an AsciiImage. Use a display method in the AsciiImage class todisplay your result. 
Usage: 

java Ppm2Ascii input_file_name [options] 

Options: 

input �le name: Input �lename.Theinput �lemustbeappmimage. 
-t threshold: Convertimagetobinary using athreshold value(convert everypixel underthethreshold to black, and every otherpixel towhite). 
Examples: 

java Ppm2Ascii usu.ppm 

Convert usu.ppm to ASCII and display it. 
java Ppm2Ascii usu.ppm -t 128 

Convert usu.ppm to ASCII and display the binary image 

obtained using the threshold. 


PPMimages. 
The�rstlineisalways �P3�whichindicatesthepixel values areinASCIIformat(instead ofbinary).After that there can be an optional comment line, which must start with a �#�. Next are three numbers: width, height, and maximumintensity value.Afterthat aretheRGB valuesforeachpixel. 


1 

SeeNetpbm1formatforadescription of thePPMimageformat. 
Example: 
P3 
# created by jpg2ppm 
2 2 255 
255 0 0 
0 255 0 
0 0 255 
255 255 0 

Thisisa2 x2imagewith thefollowing colors: 

Figure 1: A2 x2image withfourdifferent colors. 
JPG toPPM conversion tool. 
You can use the jpg2ppm Javaprogram to convert JPGimages toPPMformat. 
Usage: 
java jpg2ppm input_file_name [output_file_name] [options] 

Options: 
input �le name: Input �lename. Theinput �lemustbeajpg orppmimage. If nooutput �leisspeci�ed thentheinput �leisdisplayed. 
output �le name: Optional output �le. The output �le is a ppm image. If no output �le is speci�ed then theinput �leisdisplayed. 
-g: Convertimagetogray-scalebefore saving ordisplaying. 
1http://en.wikipedia.org/wiki/Netpbm_format 





2 

Examples: 
java jpg2ppm usu.jpg 
Displays usu.jpg image. 
java jpg2ppm usu.ppm -g 
Displays usu.ppm image in gray-scale. 
java jpg2ppm usu.jpg usu.ppm 
Convert usu.jpg to ppm and save it as usu.ppm. 
java jpg2ppm usu.jpg usu.ppm -g 
Convert usu.jpg to ppm and save it in gray-scale as usu.ppm. 

Grading: 
� 
Image class: 5points. 

� 
AsciiImage class:10points(5pointsfordisplay method). 

� 
Ppm2Ascii program: 50points. 

� 
Readingprogram options:5points. 

� 
Loadingppmimage: 10points. 

� 
Converting to ASCIIimage: 20points. 

� 
Thresholding image: 5points. 



� 
Sample test image: 2points. 



Submission. 
Submit a zip �le with the following �les: 
1. Code �les Image.java, AsciiImage.java and Ppm2Ascii.java. 
2. Atleast onesampleimagethatyouused totestyourprogram. 
IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw04 
firstName 
lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw04 
John 
Smith.zip. 
3 


