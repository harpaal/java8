package com.hpst.java8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TestDishStream {
	
	List<Dish> menuList = MenuUtil.getMenuList();

	@Test
	public void test() {
		
		List<String> dishNameList = menuList.stream().map(Dish::getName).collect(Collectors.toList());
		log.info(dishNameList.toString());
		assertEquals(menuList.size(), dishNameList.size());
	}

	

	@Test
	public void testGetOnlyMeatDishe() {
		List<Dish> dishList = menuList.stream()
											.filter(dish -> dish.getType()== Dish.Type.MEAT)
											.limit(2)
											.collect(Collectors.toList());
		dishList.stream().forEach(dish->log.info(dish.getType() + "::"+ dish.getName()));
		assertEquals(2, dishList.size());
	}
	
	@Test
	public void testMap() {
		List<Integer> distNameWordCountList= menuList.stream()
											.map(Dish::getName)
											.map(String::length)
											.collect(Collectors.toList());
		log.info(""+distNameWordCountList);
	}

}
