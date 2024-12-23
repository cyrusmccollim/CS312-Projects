# CS312 - Assignment 5 - Poly want a Nomial?
Due: 11/5

## Goal
This assignment will practice:
1. Object Oriented Analysis and Design (small part)
2. The Comparable Interface
3. The Iterable Interface (optional)
4. Empirical Measurements

## Purpose
Your math teacher (Dr. Math) has discovered that computers are good at math! They need a program to add and multiply polynomials to help with their math lectures.

## Requirements Elicitation
Q: Hey Dr. Math! What is a polynomial?  
A: Polynomial comes from poly- (meaning "many") and -nomial (meaning "term") ... so it's "many terms." 
For this program, a polynomial is a polynomial in x and thus is the sum of powers of the variable x multiplied by constant coefficients. For example:

a<sub>n</sub> x<sup>n</sup> + ... + a<sub>2</sub> x<sup>2</sup> + a<sub>1</sub> x + a<sub>0</sub>

Q: What do you need to do with them?  
A: Three things: add two polynomials, multiple two polynomials, and print out a polynomial.

Q: What does it mean to add two polynomials?  
A: See http://www.purplemath.com/modules/polyadd.htm. Briefly though, adding together each of the terms of the same order (i.e., that have the same exponent) to create a new polynomial. For example:

P1 = 6x<sup>2</sup> + 8x + 5  
P2 = 2x<sup>3</sup> + x<sup>2</sup> + 5

P1 + P2 = 2x<sup>3</sup> + 7x<sup>2</sup> + 8x + 10  
because only P2 has a x<sup>3</sup> term, they both have x<sup>2</sup> terms and only P1 has an x term. They both have constant terms (which you might think of as a x<sup>0</sup> term if it helps.


Q: What does it mean to two multiply polynomials?  
A: See http://www.purplemath.com/modules/polymult.htm. Briefly, you multiply every terms in each polynomial by every term in the other polynomial! When you multiply terms, the constants get multiplied and the powers get added. So, for example:

P1 = 6x<sup>2</sup> + 8x + 5  
P2 = 2x<sup>3</sup> + x<sup>2</sup> + 5

P1(P2) =  6x<sup>2</sup>(2x<sup>3</sup>) + 6x<sup>2</sup>(x<sup>2</sup>) + 6x<sup>2</sup>(5) + 8x(2x<sup>3</sup>) + 8x(x<sup>2</sup>) + 8x(5) + 2x<sup>3</sup>(5) + x<sup>2</sup>(5) + 5(5)  
P1(P2) = 12x<sup>5</sup> + 6x<sup>4</sup> + 30x<sup>2</sup> + 16x<sup>4</sup> + 8x<sup>3</sup> + 40x + 10x<sup>3</sup> + 5x<sup>2</sup> + 25  
P1(P2) = 12x<sup>5</sup> + 22x<sup>4</sup> + 18x<sup>3</sup> + 35x<sup>2</sup> +40x + 25

Q: What kind of interface do you want?
A: None, but I have a tester I need you to use.

## Design
You should have (at least) the following classes:
1. `Term`
    * Represents a terms in the polynomial (remember the coefficient can be negative).
    * Implements the `Comparable<...>` interface to compare two terms by exponent.

      ```
      public class Term implements Comparable <Term>{

      }
      ```
      and you will need to implement `compareTo()` method.

      More information https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
      
2. `Polynomial`
    * Represents a complete polynomial as a `List` of `Term`s.
    * The list should be ordered according to the value of the exponent of the term from highest in position 0 to lowest.
    * Services must include:
        * `degree()` which return the degree of the polynomial (i.e., the highest exponent).
        * `add(Polynomial toAdd)` which adds this polynomial and toAdd and returns the new Polynomial.
        * `insert(Term newTerm)` which adds newTerm to the polynomial, either updating (via addition) the existing term at that exponent or adding a new Term.
        * `multiply(Polynomial toMult)` which multiplies this polynomial and toMult and returns the new Polynomial.
        * `multiply(Term toMult)` which multiplies this polynomial and toMult and returns the new Polynomial.
    * Traversing the polynomial *must* be done with **iterators**. 

## Empirical Analysis
You also must perform empirical analysis on the code efficiency. To that end, you must write an `ArrayList` version *and* a `LinkedList` version. The tester code provides three tests for this:
```java
for(int i=0; i<K1; i++)
poly = poly + poly;

for(int i=0; i<K2; i++)
poly = poly * term;

for(int i=0; i<K3; i++)
poly = poly * poly;
```
In `EFFICIENCY.md` record the values of K that take about 5 seconds for the `ArrayList` version of the code along with the actual time taken and the time that the `LinkedList` version takes for the same values of K. In a sentence or two, try to explain any differences between the times for `ArrayList` and `LinkedList`.

## Hints
1. A hint on performing the addition:
    One approach is to traverse both lists and examine the two terms at the current iterator position. If the
exponent of one is smaller than the exponent of the other, then insert a copy of the larger into the result
then advance that list’s iterator. If the exponents are equal, then create a new term with that exponent
and the sum of the coefficients, then advance both iterators.
2. A hint on performing the multiplication: 
    One approach is to iterate through the terms of the first polynomial multiplying the second polynomial
by each term, and then adding up all the products. You can leverage your method that multiplies polynomials by terms.
3. A `Term` method that adds two terms with the same exponent to create a new term might be a useful thing. 
4. Be careful that you are not modifying the current polynomial and that you are creating a new one instead. Testing P + P + P can help make sure you are okay.

## Bonus
If your `Polynomial` class implements `Iterable` interface and use it for traversing the `Polynomial` (instead of using Java Iterator), you will earn some extra points.

```
public class Polynomial implements Iterable <Term>{

}
```

More information https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html


## Stylistic requirements.
In any company, you will be required to adhere to particular stylistic conventions. Such is true here too. Please ensure that your code adheres to the following.
1. Use protected for all attributes. Make sure to only refer to attributes in their declaring class and its subclasses.
1. Each source code file must start with (replace the bits in < >):  
    ```java
    /**
    * This is my code! Its goal is to <give purpose of file here>
    * CS 312 - Assignment xxx
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
     * whatever additional tests you ran
     * if you did OOA and OOD before diving in (include your OOA and OOD iterations here) **to get some extra points**
     * a reflection on how doing or not doing each of the above affected the process as a whole
     * a general reflection about the project and what you learned
