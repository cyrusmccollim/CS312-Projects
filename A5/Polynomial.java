/**
 * This is the Polynomial class. It has a list of Term objects.
 * CS 312 - Assignment 5
 * @author Cyrus McCollim
 * @version 1.0 11/03/2024
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polynomial implements Iterable<Term>{
	protected List<Term> terms;

	public Polynomial(){
		terms = new ArrayList<>();
		//terms = new LinkedList<>(); // For testing.
	}

	/**
	 * Returns the highest exponent of the polynomial as an Integer.
	 *
	 * @return  highest exponent of the polynomial.
	 */
	public Integer degree(){
		if (terms.isEmpty()){
			return 0;
		}

		return terms.getFirst().exponent;
	}

	/**
	 * Returns the lowest exponent of the polynomial as an Integer.
	 *
	 * @return  lowest exponent of the polynomial.
	 */
	public Integer lowestExponent(){
		if (terms.isEmpty()){
			return 0;
		}

		return terms.getLast().exponent;
	}

	/**
	 * Inserts a Term into this Polynomial (in the correct position).
	 *
	 * @param  term  the Term to insert.
	 */
	public void insert(Term term){
		for (int i = 0; i < terms.size(); i++){
			if (term.compareTo(terms.get(i)) > 0){
				terms.add(i, term);
				return;
			}
		}

		terms.add(term);
	}

	/**
	 * Adds a Polynomial to this Polynomial.
	 *
	 * @param  otherPolynomial  the Polynomial to add.
	 * @return  the resulting Polynomial.
	 */
	public Polynomial add(Polynomial otherPolynomial){
		Polynomial finalPolynomial = new Polynomial();

		// Highest and lowest exponent between the two polynomials.
		int highestExponent = Math.max(this.degree(), otherPolynomial.degree());
		int lowestExponent = Math.min(this.lowestExponent(), otherPolynomial.lowestExponent());

		// Traverses both polynomials within a loop that visits each possible exponent.
		// If the exponent of a term is the current exponent being considered, its coefficient is added to the newly created term.
		for (int i = highestExponent; i >= lowestExponent; i--){
			Term newTerm = new Term(0, i);

			Iterator<Term> thisPolynomialIterator = this.iterator();
			while (thisPolynomialIterator.hasNext()){
				Term term = thisPolynomialIterator.next();
				if (term.exponent == i){
					newTerm.coefficient += term.coefficient;
				}
			}

			Iterator<Term> otherPolynomialIterator = otherPolynomial.iterator();
			while (otherPolynomialIterator.hasNext()){
				Term term = otherPolynomialIterator.next();
				if (term.exponent == i){
					newTerm.coefficient += term.coefficient;
				}
			}

			// No need to add the term if it has a coefficient of zero.
			if (newTerm.coefficient != 0) {
				finalPolynomial.insert(newTerm);
			}
		}

		return finalPolynomial;
	}

	/**
	 * Multiplies this Polynomial by another Polynomial.
	 *
	 * @param  otherPolynomial  the Polynomial to multiply by.
	 * @return  the resulting Polynomial.
	 */
	public Polynomial multiply(Polynomial otherPolynomial){
		Polynomial finalPolynomial = new Polynomial();

		// Traverses both polynomials within a nested loop to multiply each in term in one polynomial to each term in the other.
		Iterator<Term> thisPolynomialIterator = this.iterator();
		while (thisPolynomialIterator.hasNext()){
			Term term = thisPolynomialIterator.next();

			Iterator<Term> otherPolynomialIterator = otherPolynomial.iterator();
			while (otherPolynomialIterator.hasNext()){
				Term term2 = otherPolynomialIterator.next();

				finalPolynomial.insert(new Term((term.coefficient * term2.coefficient), (term.exponent + term2.exponent)));
			}
		}

		finalPolynomial = finalPolynomial.add(new Polynomial()); // This ensures that any like terms are added in the end.

		return finalPolynomial;
	}

	/**
	 * Multiplies this Polynomial by a Term.
	 *
	 * @param  multiplyTerm  the Term to multiply by.
	 * @return  the resulting Polynomial.
	 */
	public Polynomial multiply(Term multiplyTerm){
		Polynomial finalPolynomial = new Polynomial();

		// Traverses this polynomial, multiplying each term by the multiplyTerm.
		Iterator<Term> polynomialIterator = this.iterator();
		while (polynomialIterator.hasNext()){
			Term term = polynomialIterator.next();
			finalPolynomial.insert(new Term((term.coefficient * multiplyTerm.coefficient), (term.exponent + multiplyTerm.exponent)));
		}

		return finalPolynomial;
	}

	/**
	 * Returns an iterator object that can be used to traverse through this Polynomial's Terms.
	 *
	 * @return  an iterator object of Terms.
	 */
	@Override
	public Iterator<Term> iterator() {
		return new Iterator<>() {
			private int iteratorPosition = 0;

			@Override
			public boolean hasNext() {
				return iteratorPosition < terms.size();
			}
			
			@Override
			public Term next() {
				try {
					iteratorPosition++;
					return terms.get(iteratorPosition - 1);
				} catch (Exception e){
					return null;
				}
			}
		};
	}

	/**
	 * Returns a String representation of this Polynomial.
	 *
	 * @return  a string representing this Polynomial in a human-readable format.
	 */
	@Override
	public String toString(){
		Iterator<Term> polynomialIterator = this.iterator();

		if (!polynomialIterator.hasNext()){
			return "0";
		}

		String result = "";
		while (polynomialIterator.hasNext()){
			if (result.isEmpty()) {
				result += polynomialIterator.next();
				continue;
			}
			result += " + " + polynomialIterator.next();
		}

		return result;
	}
}
