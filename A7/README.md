# CS 312 - Assignment 7 - The Great American Sortfight
Due: 11/29

## Goals
In this assignment you will practice
1. Sorts
2. Big-O

## Problem Statement
It's the moment you have been waiting for since Lab 11: The **Great American Sortfight** has arrived. Preparations have been prepared, generators have been generated, arrays have been arrayed. It's time for you to crown a champion. Here are the contestants:

Scricciolo Smith with his *selection sort*,  
Marveldio Young with his *merge sort*,  
Isabella Bell with her *insertion sort*,  
Quattropani Perfect with his *quick sort*,   
Hilario Woop with his *heap sort*,  
and  
poor, slow Beppe Lento with his *bubble sort.*

## Analysis
Building off of lab 11, you should be prepared to put each contestant's code to the test using a random number generator.
* The generator reads no input but does take two command-line arguments: a `seed` and a `count`. It initializes the random-number generator with `seed` and then uses it to generate `count` random integers printing them (one per line) to standard out.
* Each sort should read in a list of numbers from standard in, sort them, and then output the sorted list (one per line) to standard out.
* You will be checking for both **correctness** and **timing**. 
    * For correctness you must verify that each contestant's output is sorted using the Linux command `sort`. 
    * For the timing use the program `usr/bin/time` to output the time taken by each sort.

## Design
You should write the following classes:
* `SelectionSort` performs selection sort
* `MergeSort` performs merge sort
* `InsertionSort` performs insertion sort
* `QuickSort` performs quick sort
* `HeapSort` performs the heap sort from Lab 9
* `BubbleSort` performs bubble sort

Each class should extend `Sort` from Lab 11, but each sort should have it's own `main` method.

All sorts must be verified correct.
Correctness is checked using the Linux command `sort\` as follows:
```bash
java Generator 42 100 | tail -n +2 | sort -n > oracle.out
java Generator 42 100 | java BubbleSort > bubble.out
diff -s oracle.out bubble.out
```

To collect the timing data, use `/usr/bin/time`. For instance: `java Generator 42 100 | /usr/bin/time java BubbleSort > bubble.out`.

## The Competition

First, find a `count` (the number of random values) that causes Beppe's bubble sort to take approximately
ten seconds.  Call this `C`. Then for the `C`, `2C`, `4C`, `8C`, and `16C` run each sort and record, in separate tables, the `user` and `elapsed` time for each run as output by `usr/bin/time`. In addition, record the times obtained using the Linux `sort` command. These data should be stored in `user.txt` and `elapsed.txt`. 

**Note:** `user` time is the time taken to run the program, while `elapsed` time includes time to run the program, and IO time, system kernel, waiting time to be scheduled etc.

Finally, you should perform some data analysis, including graph generation for `user` time and `elapsed` time for each sort. Some sample questions you may consider answering are: Who won? How can you tell? Why? What do the graphs show you? You may generate your graphs either using gnuplot (as in lab 4) and Markdown (`empirical.md`) or in Excel and Word (print to a pdf called `empirical.pdf`), or using python matplotlib (if you know how to use it). 

## How To Test
You may find that you wish to test your code. The easiest way to do this would be to create a file that matches what comes out of Generator and then `cat` and pipe that file.

For example, a file named `test.dat` containing
```
4
697
476
9753
12
```
can be sorted as `cat test.dat | java BubbleSort`.

## Notes
0. You may find the `screen` command helpful.
1. Although I recommend you try to code some of these yourself for practice, you will not be penalized for looking up the code to the sorts. If you do, ensure that you include a citation to where you got the code from.
2. Each source code file must start with (replace the bits in < >):  
    ```java
    /**
    * This is my code! Its goal is to <give purpose of file here>
    * CS 312 - Assignment 7
    * @author <Your Name>
    * @version <a version number followed by a date>
    */
    ```
3. Use clear documentation and careful formatting. Be consistent in indentation and alignment of braces.
4. Every method must have a header comment of the form (replace the bits in < > and only use the number of `@param` that are needed for your method):  
    ```java
    /**
    * <A one sentence description of the method, ending with a period.>
    * <Optional longer description if desired>
    *
    * @param  <first parameter name>  <purpose of the parameter>
    * @param  <second parameter name>  <purpose of the second parameter>
    * @return      <what is returned>
    */
    ```
5. Your code must compile with no warnings using ``javac -encoding UTF-8 -source 8.``
6. Avoid wildcards in imports such as import ``java.util.*``
7. Be mindful of line breaks in your code. To see how your code will look to me, run:
    ```bash
    a2ps -T 4 -q -Avirtual -2 -o mycode.ps *.java
    ps2pdf mycode.ps
    xpdf mycode.pdf
    ```
8. Do *not* commit derivable files such as `.class` files.

## Submission
Your submission to GitHub should include:
1. All of the source code needed for your project (including the sorts from previous labs and assignments).
2. `empirical.md` ***or*** `empirical.pdf` with graphs and analysis.
    * If using `empirical.md` don't forget to add your .png files from gnuplot.
3. `user.txt` **and** `elapsed.txt`.
4. A reflection containing:
    * Your thoughts on the relationship between the run times and the relative challenge (e.g., the number of bugs, time taken to code, code length, etc.) 
of coding the different sorts.
    * How this assignment compared to others in terms of difficulty, interest level, etc.
    * Whether you made any predictions about who would win and if you were correct
