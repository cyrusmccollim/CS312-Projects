# CS312 Assignment 3 - Yes, We Have That OOA
Due: 10/10

## Goals
In this assignment you will practice:
1. Inheritance
2. Object Oriented Analysis

## Problem
Your Client needs help managing the inventory in their store, *New 'n' Used Stuff*.

## Requirements Elicitation
Q: What Stuff?  
A: DVDs, print books, audio books, and CDs.

Q: What data about each item of stuff is needed?  
A: All items have a title, a price, and are either new or used. DVDs and CDs have a release year, while
DVDs have a studio and CDs a band. Furthermore, print books and audio books have an author, while print
books have a genre (sci-fi or other) and audio books have a reader.

Q: What operations exist to maintain the inventory?  
A: I want it to be able to:  
* Add a new item to the inventory.
* Display everything, all items with a given title, or all items having a given author.
* Sell all items matching a given title or a given author, which removes the items from the inventory.
    
## What to Submit to Github

1. Update Analysis.md to contain an OOA of the Requirements elicitated above. 
    * Your OOA should identify
        * classes that you will have (remember to reflect the client’s terminology),
        * for each class, the instance variables that will be used to capture the state of an object of the class,
        * for each class, the methods used to implement the services provided by the objects of the class.
    * You can iterate until you are satisfied that it captures what the problem is at a sufficiently detailed level.
2.  A pdf of a UML class diagram that matches your OOA.
    * NOTE: At this point in the semester, you should feel comfortable to use Drawio to produce your UML diagram. Do not draw by hand. You should follow the formal UML notations and symbols when creating your class diagram. 
