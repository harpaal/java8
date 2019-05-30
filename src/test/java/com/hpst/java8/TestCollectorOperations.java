package com.hpst.java8;

import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


/***
 * 
 *
 * @author Usr
 *
 */
@Slf4j
public class TestCollectorOperations {

	List<Dish> menuList = MenuUtil.getMenuList();
	
	
	@Test
	public void testMaxBy() {
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish =   menuList.stream().collect(maxBy(dishCaloriesComparator));
		log.info(mostCalorieDish.toString());
	
	}
	
	@Test
	public void testSummuingInt() {
		menuList.stream().collect(Collectors.summingInt(Dish::getCalories));
	
	}
	
	@Test
	public void testJoining() {
		String menuNames = menuList.stream().map(Dish::getName).collect(Collectors.joining("::"));
		log.info(menuNames);
	
	}
	
	@Test
	public void testReducers() {
		//Collectors.reducing( Identity,  BiFunction>
		 Integer totalCalories = menuList.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (dishA,dishB)->dishA+dishB));
		 log.info(""+totalCalories);
	
		 //or  //Collectors.reducing( Identity, Mapper, BiFunction>
		 Integer totalCaloriesA = menuList.stream().collect(Collectors.reducing(0,Dish::getCalories, (dishA,dishB)->dishA+dishB));
		 log.info(""+totalCaloriesA);
	    //or
		  Integer sum = menuList.stream().collect(Collectors.reducing(0, Dish::getCalories ,Integer::sum));
		 log.info(""+sum);
		 
		 
		 //highest Calories
		 //or  //Collectors.reducing( BiFunction)
		  Optional<Dish> highestCalory = menuList.stream().collect(Collectors.reducing((dishA,dishB)-> dishA.getCalories()> dishB.getCalories()?dishA:dishB));
		
	}

}
