/**
 * 
 */
package com.hpst.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Usr
 * 
 *  Given two lists of numbers, how would you return all pairs of numbers?
 *   For example, given a list [1, 2, 3] and a list [3, 4] 
 *   you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
 *   For simplicity, you can represent a pair as an array with two elements.
 *
 */
@Slf4j
public class TestFlatMapPair {

	List<Integer> numbers1 = Arrays.asList(1, 2, 3);
	List<Integer> numbers2 = Arrays.asList(3, 4);

	@Test
	public void test() {
//		List<Stream<int[]>> collect = numbers1.stream()
//				.map(i -> numbers2.stream()
//								  .map(j-> new int[] {i,j}))
//				.collect(Collectors.toList());
		List<int[]> results = numbers1.stream()
				.flatMap(i -> numbers2.stream()
								  .map(j-> new int[] {i,j}))
				.collect(Collectors.toList());
		
	}

}
