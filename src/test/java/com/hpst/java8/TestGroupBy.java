package com.hpst.java8;

import java.util.List;
import java.util.Map;


import org.junit.Test;
import static java.util.stream.Collectors.*;
import com.hpst.java8.Dish.Type;

import lombok.extern.slf4j.Slf4j;


/***
 * long howManyDishes = menu.stream().collect(Collectors.counting())=long howManyDishes = menu.stream().count();
 * 
 * 
 * @author Usr
 *
 */
@Slf4j
public class TestGroupBy {

	List<Dish> menuList = MenuUtil.getMenuList();

	
	
	@Test
	public void test() {
		
		Map<Type, List<Dish>> dishTypeMap = menuList.stream().collect(groupingBy(Dish::getType));
		log.info(dishTypeMap.toString());
	}

}
