# Sorting Tool

A program that can sort a set of numbers, words, or lines and count the number of times each element occurs.

Prerequisites
-------------

This program requires at least Java 10 to compile and run properly.

Installation
------------

1. Download this repository and unzip the .zip file in your desired location.
2. Using the command line, navigate to \Sorting-Tool-master\src\sorter.
3. Compile the program using the command `javac Main.java`.

Usage
-----

Once Sorting Tool has been compiled, it can be run from the command line by navigating to \Sorting-Tool-master\src and using the command `java sorter.Main` along with any of the following optional arguments: `-dataType`, `-sortingType`, `-inputFile`, and `-outputFile`.

**Arguments:**

`-dataType` should be followed by one of the accepted data types: `line`, `word`, or `long` (for numbers). If Sorting Tool is run without the `-dataType` argument, it will default to sorting words.

`-sortingType` should be followed by either `natural` or `byCount`. This determines whether the Sorting Tool will sort the input data by their natural numerical or alphabetical order (natural sorting) or by the number of times each element occurs (by count sorting). If Sorting Tool is run without the `-sortingType` argument, it will default to natural sorting.

`-inputFile` should be followed by the file path and name of the file for the program to read data from. If Sorting Tool is run without the `-inputFile` argument, the program will read any data input the user enters to the console once the program starts. To end data input, the user should type `Ctrl+D` (or the appropriate [end of file character](https://en.wikipedia.org/wiki/End-of-file) for your operating system).

`-outputFile` should be followed by the file path and name of the file for the program to write its results to. This should be a .txt file. If the specified file does not already exist, it will be created; otherwise, the existing file will be overwritten. If Sorting Tool if run without the `-outputFile` argument, the program will instead print its results to the console.

Credits
-------

**Author:** Kate Jordan - [sinnenicht](https://github.com/sinnenicht)

This program is based on the Sorting Tool project on [Jet Brains Academy](https://hyperskill.org/projects/45?goal=7).

License
-------

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](https://github.com/sinnenicht/Sorting-Tool/blob/master/LICENSE) for details.
