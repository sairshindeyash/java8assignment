package com.yash.practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);
		
		// collect the result of a Stream into Set
		Set<Integer> setCollector = numbers.stream()
		.collect(Collectors.toSet());
		System.out.println(setCollector);
		
		// collect the result of a Stream into list
		List<Integer> listCollector = numbers.stream()
		.collect(Collectors.toList());
		System.out.println(listCollector);
		
		// create Map from the elements of Stream (first remove the duplicates)
		Map<Integer, Integer> numbersMap = numbers.stream()
		.collect(Collectors.toMap(Integer::intValue, Integer::intValue, (oldval,newval)->oldval));
		System.out.println("numbersMap"+numbersMap);
		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics stat = numbers.stream()
		.collect(Collectors.summarizingInt(number->number));
		System.out.println("stat"+stat);
		
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Object, List<Integer>> evenOdd = numbers.stream()
		.collect(Collectors.groupingBy(number->number%2==0, Collectors.toList()));
		System.out.println(evenOdd);
		
		
		// create comma separated string from numbers
		String commaList = numbers.stream()
		.map(num->num.toString())
		.collect(Collectors.joining(","));
		System.out.println(commaList);
		


	}
}
