### ArrayList:
(Values of K that take about 5 seconds for ArrayList.)

| K (Algo) - Iterations | Time (ms) |
|-----------------------|-----------|
| K1 - 75,000,000       | T = 5,003 |
| K2 - 175,000,000      | T = 4,990 |
| K3 - 8                | T = 1,688 |
| K3 (#2) = 6           | T = 30    |

***

### LinkedList:
(Resulting time with same K values from before.)

| K (Algo) - Iterations | Time (ms)                      |
|-----------------------|--------------------------------|
| K1 - 75,000,000       | T = 4,811                      |
| K2 - 175,000,000      | T = 5,233                      |
| K3 - 8                | T = 900,000+ (never completed) |
| K3 (#2) = 6           | T = 11074                      |

***

*Differences between the times for ArrayList and LinkedList?*

For the tests K1 (where a polynomial is added to itself 75M times) and K2 (where a polynomial is multiplied by the same term 175M times), there is no significant difference between the run times.
This makes sense when we consider that traversing an ArrayList and LinkedList are both performed in linear time. 
The `add(Polynomial other)` method traverses both polynomials for each integer between the highest and lowest exponent. O(n^2) at worst-case, but when adding a polynomial to itself, the difference between the exponents never changes and remains insignificant.
The `multiply(Term term)` method traverses the polynomial once. O(n) at worst-case.

For the test K3 (where a polynomial is multiplied by itself several times) there is actually a crazy difference in run times between the ArrayList and LinkedList versions. During my testing, a K3 value of 8 had the ArrayList version completing in ~2 seconds. On the other hand, the LinkedList version was still computing after being left alone for 15 minutes.
This also makes sense though, given that there are several aspects of the `multiply(Polynomial other)` method that drive up its time complexity. There is a nested loop that walks through each term of both polynomials. Inside this inner loop, a term multiplication happens with insertion into the result polynomial. With ArrayList, accessing the terms is constant time. It really only gets complex because of the multiplication and insertion steps, leading to O(n^2). But LinkedLists access terms linearly so each access of a term adds time cost, pushing up the overall complexity to what I think is at least O(n^3).