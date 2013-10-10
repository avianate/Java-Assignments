Nate Graham	A00305171

README.TXT

This DragonMaze program has the following features:

The hero must get a key before he can exit.
There is one energy drink in the game which will allow the hero to move twice per time step for the next 10 time steps.

The recursive function is found in the World.java file inside of the nextMove() method. The recursion is used when the hero has the energy drink and can move twice per time step.

This program uses a 2D GridCell array which holds each cell of the map.
Since a GridCell is a cell of the grid with a location, the Actor class inherits from the GridCell class. In essence an Actor is a GridCell with a location

All of the files utilize a Row, Column coordinate system as opposed to using variables for X, Y coordinates.

The World class maintains a copy of the Hero, Dragon, and Exit for quick access to their respective locations in the Grid.

The 2 maps, about.txt file and a help.txt file were placed inside the binaries folder while the .java class files were placed inside the src folder. Therefore the zipped file will contain a "bin" folder with the package binary and .txt files and another "src" folder with the package contents containing the .java class files.