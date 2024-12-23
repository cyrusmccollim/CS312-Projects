# CS312 - Assignment 6 - A Tree, Sorta.
Due: 11/19

## Goals
This assignment will practice:
1. Trees
2. Queues
3. Nested classes
4. Generics

## Purpose
You have been asked to sort a list of numbers and, further, to use a tree to do it. You are not supposed to use what is typically thought of as "tree sort" though! You have a specific algorithm to follow.

## Analysis
You need to write a program that will sort a list of numbers and take some command line arguments to do it. The usage message should be:

```bash
java CLI [-t] [-n <number_list> | -r <count>]
      -t is an optional flag that causes the time taken while sorting to be printed
      -n <number_list> sorts the numbers of number_list (example: -n 9 1 20 11 8)
      -r <count> sorts count random numbers
      
      One and only one of -n or -r should be provided. -t, if it exists, will always come first.
```

You must also use a tree to sort and the tree (although sorting only numbers in the CLI) should be able to sort *anything that can be compared.*

Finally, the algorithm **must** be the following:
1. Create a queue, Q, out of the List, L, to be sorted
2. For each number to be sorted:
    1. Create a "Tree" containing only the number
    2. Insert the "Tree" into Q
3. While Q has more than one thing in it:
    1. Take two "Trees" from the queue: T1 and T2
    2. Inspect the root of T1 and T2
    3. Create a new "Tree" (T3) with the following properties:
        1. The root has the value that is the smaller of the value of T1 and T2's root    
            * Whichever tree is used is updated such that the smaller value of the root's children becomes the value of the new root
            * The rest of the tree is shifted in the same way to keep filling holes until reaching a leaf, which is removed
        2. The left child of T3 is T1 (updated if it was the smaller)
        3. The right child of T3 is T2 (updated if it was the smaller)
    4. Put T3 back in into Q
4. While T3 has data in it
    1. Add the value of the root to the List S
    2. Update T3 by making the value of the root the smaller of the value of the root's children
        * The rest of the tree is shifted in the same way to keep filling holes until reaching a leaf, which is removed
5. S now contains the sorted version of L

## Design
NOTE: You should NOT create a binary search tree, nor are you technically creating a heap.

Your design must include:
1. A **nested** Node class.
2. A generic tree, such that any `Comparable` object can be sorted.
3. The following two methods:
    ```java
    /**
    * Construct a tree from a List of values.
    * 
    * @param values the list to make the tree of
    * @return a tree with the smallest value at the node
    */  
    public Tree(List<E> values)
  
    /**
    * Perform a tree sort.
    *
    * @return the sorted list
    */
    public List<E> sort()
    ```

    ***follow steps 1,2 and 3 in the algorithm for the constructor, and steps 4 and 5 for the sort method***
4. Strictly follow object-oriented programming approach, i.e., delegating the work to the object that is responsible for doing it.
5. While we use the term "Tree" in the sorting algorithm described above, remember that a "Tree" is technically just a "Node" that points to the left node (representing the left tree), and the right node (representing the right tree). You might want to review the lecture notes about binary search tree for similar design. 

## Empirical Data Analysis
1. Find N values your program can sort in 3 seconds (using -t -r N). Output the time taken to sort N, 2N, 4N, and 8N numbers. 
2. Record your empirical data in Empirical.md and then add a sentence or two, explaining any patterns.

## Stylistic requirements.
In any company, you will be required to adhere to particular stylistic conventions. Such is true here too. Please ensure that your code adheres to the following.
1. Use protected for all attributes. Make sure to only refer to attributes in their declaring class and its subclasses.
1. Each source code file must start with (replace the bits in < >):  
    ```java
    /**
    * This is my code! It's goal is to <give purpose of file here>
    * CS 312 - Assignment 6
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
7. Avoid the use of the ``instanceof`` keyword. True OO thinking should not require it..
9. All concrete classes must include reasonable `toString` methods.
10. Your code should contain ***no*** `get()` or `set()` methods.
11. Be mindful of line breaks in your code. To see how your code will look to me, run:
    ```bash
    a2ps -T 4 -q -Avirtual -2 -o mycode.ps *.java
    ps2pdf mycode.ps
    xpdf mycode.pdf
    ```
12. Do *not* commit derivable files such as `.class` files.

## Submission
In your GitHub repo you should have:
1. All of the source code needed for your project.
2. `Empirical.md` with a table and an explanation.
3. `Process.md` with
     * whatever milestones you created for yourself
     * whatever tests you ran
     * if you did OOA and OOD before diving in
     * a reflection one how doing or not doing each of the above affected the process as a whole

