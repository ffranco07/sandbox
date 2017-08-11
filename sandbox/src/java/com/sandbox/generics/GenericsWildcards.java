package com.sandbox.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Francisco Franco
 *
 * Generic wildcard type passed as parameter to method
 *
 */
public class GenericsWildcards {

	public static double sum(List<? extends Number> list){
		double sum = 0;
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}

	// Main method to execute functions above
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(3); ints.add(5); ints.add(10);
		double sum = sum(ints);
		System.out.println("Sum of ints="+sum);
	}
}
