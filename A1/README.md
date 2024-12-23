# CS312 Assignment 1: What's the Point?

**This assignment is worth 100 points: Initial Design (30 points), Update Design and Implementation (70 points).**



## Problem
Implement code to manipulate Polar and Cartesian points. 

## Goals
1. Java coding refresher.
2. Introduction to Interfaces, Abstract Classes, and Inheritance.
3. Practice "Think then Code"

## Analysis
The first stage in your programming assignment is the requirements analysis stage. You need to make sure you understand the below requirements for what your program needs to do. In the real world, this will likely come in the form of a Q & A with your client. For now, I will provide you with the analysis but see ANALYSIS.md for a Q&A that should hopefully lead you the same place.

1. The client needs two concrete classes `PolarPoint` and `CartesianPoint`.
    * A polar point maintains an angle *θ* and a radius *ρ*.
    * A Cartesian point maintains *x* and *y* coordinates.
    * Both inherit from a common abstract class.
2. The program needs to include **two separate interfaces** for *translating* and *rotating* points.
    * Translating a CartesianPoint by the amount *(by_x, by_y)* adds *by_x* to the point's *x* value and *by_y* to its *y* value. 
    * Rotating a CartesianPoint by *θ* updates *x* to be *x × cos(θ ) − y × sin(θ )* and *y* to be *y = x × sin(θ ) + y × cos(θ )*.
    * Translating a polar point by the amount *(by_x, by_y)* can be accomplished by converting the point to a Cartesian point, doing the translation, and then converting it
back.
    * Rotating a PolarPoint by *θ* degrees adds *θ* to the point's angle.  
3. There is no user interface.
4. You must include a hard-coded test driver, `Tester.java` to test your code.

## Design
The design comes down to the use of abstract classes, interfaces, and concrete classes. To that end, you must produce a list of milestones and a test plan to accomplish your task.

#### Milestone List
The list of milestones should be a concrete list of tasks that you will accomplish. For instance:

1. Declare class PolarPoint
2. Add theta and rho attributes to PolarPoint
3. Add toString method to PolarPoint

#### Test Plan
In this course we will be doing Unit Testing and Test Driven Development. To that end, you must produce at least four tests for each kind of point. Tests should include the procedure including **specific** input, expected output, and rationale. For instance:

1. create a PolarPoint and print it out  
    input: 45, 2   output: 45, 2  rationale: ensure that the PolarPoint prints as created
2. create a PolarPoint, rotate it, and print it out  
    input: 45, 2 - rotate 90 output: 135, 2 rationale: ensure that PolarPoints rotate correctly
    
#### Optional: Merge your Tests with Milestones
If you wish, you may merge the Milestone List and Test Plan such that each test ensures that you have accomplished your milestone.

For Example:

1. Declare class PolarPoint
    * create a PolarPoint  
        input: None output: None rationale: can create a point without producing program error
3. Add theta and rho attributes to PolarPoint
    * create a PolarPoint with theta and rho declared  
        input: 45, 2 output: None rationale: can create a point with theta and rho without producing program error
4. Add toString method to PolarPoint
    * create a PolarPoint and print it out  
        input: 45, 2   output: 45, 2  rationale: ensure that the PolarPoint prints as created
        
#### Submit your Initial Design 

1. Submit a drawing of your classes/interfaces diagram similar to the one we did in class. (by hand or use [Drawio](https://www.drawio.com)) 
2. Submit a completed DESIGN.md with milestones and test plan to GitHub.


***Remember to double check on github.com that your files pushed. If they didn’t, you need to push them. I can only see what is on github.com, not what is only on your computer.***

## Implementation
*Note: the requirements below are for implementation phase.* 

#### Stylistic Requirements and Notes
In any company, you will be required to adhere to particular stylistic conventions. Such is true here to. Please ensure that your code adheres to the following.

1. Classes and Interfaces should have their own files.
1. Each source code file must start with (replace the bits in < >):  

```java
/**
* This is my code! It's goal is to <give purpose of file here>
* CS 312 - Assignment 1
* @author <Your Name>
* @version <a version number followed by a date>
*/
```
2. Use clear documentation and careful formatting. Be consistent in indentation and alignment of braces.
3. Every method must have a header comment of the form (replace the bits in < > and only use the number of `@param` that are needed for your method):  

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
4. Your code must compile with no warnings using ``javac -encoding UTF-8 -source 8.``
5. Avoid wildcards in imports such as import ``java.util.*``
6. Your code can contain no more than one static method.
7. Avoid the use of the ``instanceof`` keyword. True OO thinking should not require it.
8. Declare attributes private for now, we will do things better later.
9. All concrete classes must include reasonable `toString` methods.
10. Your code should contain ***no*** `get()` or `set()` methods.
11. Be mindful of line breaks in your code. To see how your code will look to me, run:

```bash
a2ps -T 4 -q -Avirtual -2 -o mycode.ps *.java
ps2pdf mycode.ps
xpdf mycode.pdf
```
11. Do *not* commit derivable files such as `.class` files.

#### Final Submission

To GitHub:

1. All your Java Source Code with `main` in `Tester.java`.
2. An updated DESIGN.md with a `## Reflection` section containing:
    * How you used an *abstract class*
    * How you used a *concrete class*
    * How you used *inheritance*
    * How you used an *interface*
    * How well you were able to follow your milestones and whether you had to make changes
    * A general reflection on the project
