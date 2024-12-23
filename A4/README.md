# CS312 Assignment 4 - Yes, We Have That Everything
Due: 10/25

## Goals
In this assignment you will practice:
1. OOA -> OOD
2. OOD -> Code
3. Inheritance
4. Generics
5. Command Line Interfaces
6. Input and Output redirection

## Problem
Your Client needs help managing the inventory in their store, *New 'n' Used Stuff*.

## Requirements Elicitation

### Iteration 1, for reference (i.e., A3)
Q: What Stuff?  
A: DVDs, print books, audio books, and CDs.

Q: What data about each item of stuff is needed?  
A: All items have a title, a price, and are either new or used. DVDs and CDs have a release year, while DVDs have a studio and CDs a band. Furthermore, print books and audio books have an author, while print books have a genre (sci-fi or other) and audio books have a reader.

Q: What operations exist to maintain the inventory?  
A: I want it to be able to:

* Add a new item to the inventory.
* Display everything, all items with a given title, or all items having a given author.
* Sell all items matching a given title or a given author, which removes the items from the inventory.

### Iteration 2
Q: What kind of user interface will be used?  
A: User commands will be given via command-line switches.

Q: What switches are used for the various commands?  
A: Here is the usage message I'd like
```
Usage: java Driver [-d|-a|-s] <options>
there are three command line options
(display) -d [(everything by default) | -t "title" | -a "author" ]
(add) -a DVD "title" cost year "studio" [ NEW|USED ]
(add) -a CD "title" cost year "band" [ NEW|USED ]
(add) -a BOOK "title" cost author genre [ NEW|USED ]
(add) -a AUDIOBOOK "title" cost author "reader" [ NEW|USED ]
(sell all) -s [-t title | -a author]
```

Q: What should the outputs for each command be?  
A: Display should display my inventory in a nice, human-readable format. The other commands should output the inventory in a format that can be stored in a datafile. By the way, every command will let you load the inventory from the standard input or a datafile if you use redirection.

Q: How is the inventory stored in a datafile?  
A: In a single text file where each line has the format:
```
<LINE> ::= <TITLE>;<TYPE>;<PRICE>;<PROPERTY1>;<PROPERTY2>;<STATUS>
<TYPE> ::= BOOK | DVD | CD | AUDIOBOOK
<PROPERTY1> ::= <RELEASEYEAR> | <AUTHOR>
<PROPERTY2> ::= <STUDIO> | <BAND> | <GENRE> | <READER>
<GENRE> ::= SCIFI | OTHER
<STATUS> ::= NEW | USED
TITLE, STUDIO, AUTHOR, BAND, and READER are semi-colon-free strings, PRICE is a positive double, and RELEASEYEAR is a positive integer no greater than the current year.
Note that some fields such as the TITLE may include spaces.
```

Q: Oh good heavens, can I see an example of that?  
A: Yes, I have examples here for you (see dataToy.txt or dataLong1.txt).
  
Q: What mechanism is used to read and write the datafile?  
A: Unix IO redirection (see lab 5). For example,
```bash
java Driver -a ... < current-data-file > new-data-file
```
or equivalently
```bash
cat current-data-file | java CLI -a ... > new-data-file
```

Q: Any hints?  
A: To read from the standard input (or the data file if you use redirection), you may want to use the `split` method or a `StringTokenizer`. Also, try writing small pieces of code that do the input and output bit (and lab 5 will help). For standard input, you can send a EOF character to your program using **Ctrl + D**.

## Stylistic Requirements and Notes
In any company, you will be required to adhere to particular stylistic conventions. Such is true here to. Please ensure that your code adheres to the following.
1. ***NEW:*** Use protected for all attributes. Make sure to only refer to attributes in their declaring class and its subclasses.
1. ***NEW:*** You must use a generic from the JCF to store the stuff.
1. Separate jobs meaningfully. For instance, `CLI` should do all output, no other class (with the *possible* exception of `Driver`) should output to the screen.
1. Error checking is required.
1. Each source code file must start with (replace the bits in < >):  
    ```java
    /**
    * This is my code! Its goal is to <give purpose of file here>
    * CS 312 - Assignment 4
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

## Final submission
To GitHub:
1. Your Java Source Code with `main` in `Driver.java`.
2. A file called OOD.md with at least two iterations of design. 
3. A file called Reflections.md with your thoughts on:
    * How developing an OOA and OOD influenced the writting of your code.
    * If you had any sticking points and if so, what they were and how you overcame them. 
    * A general reflection on the project.
