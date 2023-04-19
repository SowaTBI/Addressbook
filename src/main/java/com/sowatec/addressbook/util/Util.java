package com.sowatec.addressbook.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Util {
	
	public static <T>List<T>iterableToList(Iterable<T>iterable) {
		
		List<T> list = new ArrayList<>();
		
		Iterator<T> iterator = iterable.iterator();
		
		while(iterator.hasNext()) {
			
			list.add(iterator.next());
		}
		
		return list;
	}
	
	private Util () {
		
		
	}
}
