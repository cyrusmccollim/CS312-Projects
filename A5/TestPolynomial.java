/**
  * This is tester code!  Its goal is to test the polynomial code using JUnit.
  * CS 312 - Assignment 5
  * @author Binkley, Isaacman, Ho
  * @version 1.4  10/27/2024
  */

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class TestPolynomial
{
  public TestPolynomial() {}

  @Test
  public void termTest() // might go on to test a range of powers
  {
    Term t = new Term(2, 1);
    assertEquals("2.0x", t.toString());
  }

  @Test
  public void emptyPolyTest()
  {
    Polynomial poly1 = new Polynomial();
    assertEquals("0", poly1.toString());
  }

  @Test
  public void singleTerm()
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    assertEquals("5.0x^2", poly1.toString());
  }

  @Test  
  public void twoTerms()
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    assertEquals("5.0x^2 + 8.0", poly1.toString());
  }

  @Test  
  public void middleInsertTest()
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    poly1.insert(new Term(3,1));
    assertEquals("5.0x^2 + 3.0x + 8.0", poly1.toString());
  }

  @Test  
  public void addTest()
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    poly1.insert(new Term(3,1));
    poly1 = poly1.add(poly1);
    assertEquals("10.0x^2 + 6.0x + 16.0", poly1.toString());
  }

  @Test  
  public void polyTimesTerm() 
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    Term term = new Term(2, 1);
    // System.out.println("times term " + poly1.multiply(term));
    assertEquals("10.0x^3 + 16.0x", poly1.multiply(term).toString());
  }

  @Test  
  public void squared() // a times test
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    // System.out.println("poly^2 = " + poly1.multiply(poly1));
    assertEquals("25.0x^4 + 80.0x^2 + 64.0", poly1.multiply(poly1).toString());
  }

  @Test  
  public void twoPloyTimesTest() 
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    Polynomial poly2 = new Polynomial();
    poly2.insert(new Term(1,5));
    // System.out.println("add = " + poly1.add(poly2));
    assertEquals("1.0x^5 + 5.0x^2 + 8.0", poly1.add(poly2).toString());
  }

  @Test  
  public void twoPloySymmetryTest() 
  {
    Polynomial poly1 = new Polynomial();
    poly1.insert(new Term(5,2));
    poly1.insert(new Term(8,0));
    Polynomial poly2 = new Polynomial();
    poly2.insert(new Term(1,5));
    // System.out.println("add = " + poly1.add(poly2));
    assertEquals("1.0x^5 + 5.0x^2 + 8.0", poly2.add(poly1).toString());
  }

  public static void main(String[] args) 
  {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new TestListener());
    Result result = runner.run(TestPolynomial.class);
  }
}


class TestListener extends RunListener 
{
  public void testStarted(Description description) {
    //System.out.println("Test started " + description.getMethodName());
  }

  public void testFinished(Description description) 
  {
    // System.out.println("Finished "+ description.getMethodName());
  }

  public void testFailure(Failure failure)
  {
    //System.out.println(failure.getMessage());
    //System.out.println(failure.getTrace());
  }

  public void testRunFinished(Result result) 
  {
    int ran = result.getRunCount();
    int failed = result.getFailureCount();

    System.out.println("Ran " + ran + " passed " + (ran-failed) 
      + (result.wasSuccessful() ? " all passed!" : " ... Failed:"));
   
    for (Failure failure : result.getFailures())
    { 
      System.out.println(failure.toString());
    }
  
  }
}
