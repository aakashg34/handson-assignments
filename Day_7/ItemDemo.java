package com.hsbc.collection;

import java.util.*;



public class ItemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		List<Item> list = new ArrayList<Item>();
		list.add( new Item(101,"COD",499.0,4.4));
		
		list.add(new Item(103,"PUBG",699.0,4.6));
		list.add (new Item(102,"BATTLEFIELD 1",499.0,4.5));
		list.add (new Item(104,"FORTNITE",449.0,4.5));
		
		System.out.println(list.size());
		
		
		ItemSort test = new ItemSort();
		
		Collections.sort(list,test.new SortItemsById());	
		Iterator<Item> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Item i = iterator.next();
			System.out.println("Items : "+i);
		}
		//Collections.sort(list,test.new SortItemsByName());
		
		//Collections.sort(list,test.new SortItemsByPrice());
		Collections.sort(list, test.new SortItemsId());
		Collections.sort(list, test.new SortItemsName());
		
	}

}
