/**
 * This is tester code!  Its goal is to test the polynomial code using JUnit.
 * CS 312 - Assignment 5
 * @author Binkley, Isaacman, Ho
 * @version 1.7 10/27/2024
 */

class Tester
{
  public static void main(String[] args)
  {
    Polynomial poly1 = new Polynomial();
    System.out.println("poly = " + poly1);

    poly1.insert(new Term(5,2));
    System.out.println("poly = " + poly1);

    poly1.insert(new Term(8,0));
    System.out.println("poly = " + poly1);

    System.out.println("poly^2 = " + poly1.multiply(poly1));

    poly1.insert(new Term(3,1));
    System.out.println("poly = poly + 3x = " + poly1);

    Polynomial p = poly1.add(poly1);
    System.out.println("p = poly + poly = " + p);

    Polynomial p2 = new Polynomial();
    p2.insert(new Term(1,5));
    System.out.println("p2 = " + p2);
    System.out.println("p + p2 = " + p.add(p2));
    System.out.println("p2 + p = " + p2.add(p)); 

    Term t = new Term(2, 1);
    System.out.println("t = " + t);
    Polynomial pp = p.multiply(t);
    System.out.println("p*t = " + p + " * " + t + " = " + pp);

    long startTime, time, memoryUsed;

    startTime = System.currentTimeMillis();
    time = startTime;
    memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println("\nstart stress test starts at " + startTime + "ms, using " + memoryUsed/(1024*1024) + "Mb");

    // stress test!
    int K1 = 75000000;
    int K2 = 175000000;
    int K3 = 6;

    // at this point you will get better data if you only perform one of 
    // the following stress tests at a time!

    for(int i = 0; i < K1; i++) {
      pp = pp.add(pp);
    }

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println("post add test took " + (time - startTime) + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree() );

    startTime = time;
    pp = p.multiply(t);
    for(int i = 0; i < K2; i++) {
      pp = pp.multiply(t);
    }

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println("post multiply term test took " + (time - startTime) + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree());

    startTime = time;
    pp = p.multiply(t);
    for(int i = 0; i < K3; i++) {
      pp = pp.multiply(pp);
    }

    time = System.currentTimeMillis();
    memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

    System.out.println("post multiply poly test took " + (time - startTime) + "ms, using " + memoryUsed/(1024*1024) + "Mb");
    System.out.println("pp.degree = " + pp.degree() );
  }
}

