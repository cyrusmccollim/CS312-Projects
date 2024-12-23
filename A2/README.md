# CS312 Assignment 2 - Meet the band 

**This assignment is worth 100 points: Initial Design (30 points), Updated Design and Implementation (70 points).**

## Due 
- Design: Thursday, 26th September
- Final: Thursday, 3rd October

## Problem
A client has requested that you come up with a program to store and retrieve information about your favorite musical act.

## Goals
In this assignment, you will practice
1. Proper design (i.e., who does what task)
2. Java Collection Framework
3. Manipulating Command Line Interfaces


## Analysis
Your client needs a program that can output information about her
favorite band. The program must be able to:
* take options as *command-line arguments* with other user input
* print the entire band including its name
* find and print a band member with a given name
* find and print a band member that plays a given instrument

If your program is called with no arguments or incorrect arguments, it should print out a usage message as follows: 
```
    Usage: java Driver [-p|-n|-i] <options>
      -p               (print)
      -n "name"        (lookup by member name)
      -i "instrument"  (lookup by instrument)
```

## Design
* Your code should have at least the following classes (each class should be in its own file):
    * `BandMember`  
    * `Band`  
    * `CLI` (i.e., Command Line Interface)
    * `Driver`
        * `main()` should be here
* `main()` should populate the band before creating a `CLI` object to process the
command line arguments.
* Test your program with your favorite band.
    * As an example:  
        ```java
        Band theBeatles = new Band("The Beatles");
        theBeatles.add( new BandMember("John Lennon", "vocals"));
        theBeatles.add( new BandMember("Paul McCartney", "bass"));
        theBeatles.add( new BandMember("Ringo Starr", "drums"));
        theBeatles.add( new BandMember("George Harrison", "guitar"));
        // System.out.println("The Beatles = " + theBeatles);  // for ``testing''
        ```
### Design Submission 
Turn in your Design and Test cases on github which should include:
  1. A class diagram of all your classes (not Driver class) with any relationship between them. Submit a .jpg or .png file to GitHub, make sure the file is not corrupted.
  2. A narration of your classes under *Class Hierarchy* in **DESIGN.md**. This should reflect your class diagram. Each class should have attributes (if any), and methods (including constructor). It is important to give one sentence describing the purpose of the method.
  3. Test cases in **DESIGN.md**: use your favorite band to test out your program.


## Implementation

### Stylistic Requirements and Notes
In any company, you will be required to adhere to particular stylistic conventions. Such is true here to. Please ensure that your code adheres to the following.
1. Seperate jobs meaningfully. For instance, `CLI` should do all output, no other class (with the *possible* exception of `Driver`) should output to the screen.
2. **Bonus 5 additional points**: Make use of JCF `Iterator`.
3. Error checking is required.
4. Each source code file must start with (replace the bits in < >):  
    ```java
    /**
    * This is my code! It's goal is to <give purpose of file here>
    * CS 312 - Assignment 2
    * @author <Your Name>
    * @version <a version number followed by a date>
    */
    ```
5. Use clear documentation and careful formatting. Be consistent in indentation and alignment of braces.
6. Every method must have a header comment of the form (replace the bits in < > and only use the number of `@param` that are needed for your method):  
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
7. Your code must compile with no warnings using ``javac *.java -encoding UTF-8 -source 8 -target 8 -Xbootclasspath/p:/usr/local/java/jre/lib/ .``
8. Avoid wildcards in imports such as import ``java.util.*``
9. Your code can contain no more than one static method.
10. Avoid the use of the ``instanceOf`` keyword. True OO thinking should not require it.
11. Declare attributes private for now, we will do things better later.
12. All concrete classes must include reasonable `toString` methods.
13. Your code should contain ***no*** `get()` or `set()` methods.
14. Be mindful of line breaks in your code. To see how your code will look to me, run:
    ```bash
    a2ps -T 4 -q -Avirtual -2 -o mycode.ps *.java
    ps2pdf mycode.ps
    xpdf mycode.pdf
    ```
15. Do *not* commit derivable files such as `.class` files.

 ***Remember to double check on github.com that your files pushed. If they didn’t, you need to push them. I can only see what is on github.com, not what is only on your computer.***
 
### Final Submission
To GitHub:
1. Your Java Source Code with `main` in `Driver.java`.
2. An updated class diagram.
3. An updated DESIGN.md with a `## Reflection` section containing a general reflection on the project
