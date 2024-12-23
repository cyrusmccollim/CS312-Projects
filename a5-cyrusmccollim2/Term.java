/**
 * This is the Term class. It holds a coefficient and exponent for an algebraic term of variable x.
 * CS 312 - Assignment 5
 * @author Cyrus McCollim
 * @version 1.0 11/03/2024
 */

public class Term implements Comparable<Term> {
	protected double coefficient;
	protected int exponent;

	public Term(double coefficient, int exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	/**
	 * Returns the difference between exponents of this Term and another Term.
	 *
	 * @param  otherTerm  the other term to compare against.
	 * @return  the difference between exponents of the two terms.
	 */
	public int compareTo(Term otherTerm){
		return this.exponent - otherTerm.exponent;
	}

	/**
	 * Returns a String representation of this Term.
	 *
	 * @return  a string representing this Term in a human-readable format.
	 */
	@Override
	public String toString(){
		if (exponent == 0){
			return "" + coefficient;
		}

		if (exponent == 1){
			return coefficient + "x";
		}

		return coefficient + "x^" + exponent;
	}
}
