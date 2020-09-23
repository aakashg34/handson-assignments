package com.hsbc.collection;

import java.util.Comparator;

public class ItemSort {

	public class SortItemsById implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
		return 	o2.getItemId() - o1.getItemId();
		}
	}

	public  class SortItemsByName implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o2.getName().compareTo(o1.getName());
		}
		
	}
	
	public class SortItemsByPrice implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			if(o2.getPrice()-o1.getPrice()>0)
			{
				return 1;
				
			}
			else 
				return -1;
		}
		
	}
	
	public class SortItemsId implements Comparator<Item>
	{

	
		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o1.getItemId()-o2.getItemId();
		}
		
	}
	public  class SortItemsName implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o2.getName().compareTo(o1.getName());
		}

		
		
	}

}
