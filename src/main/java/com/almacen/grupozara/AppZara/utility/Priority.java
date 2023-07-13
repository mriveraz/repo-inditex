package com.almacen.grupozara.AppZara.utility;

import java.util.HashMap;
import java.util.Map;

import com.almacen.grupozara.AppZara.models.Price;

@SuppressWarnings("unchecked")
public enum Priority {
	
	
	PRIORITY_HIGH(1),
	PRIORITY_LOW(0);
	

    private final int value;
    private final static Map<Integer, String> priority = new HashMap<>();
    

	Priority(int value) {
		
		this.value= value;
	}
	
	static {
		
		priority.put(0, "PRIORITY_LOW"); 
		priority.put(1, "PRIORITY_HIGH");
        for (Priority priority : Priority.values()) {
        	if (priority.equals(PRIORITY_HIGH)) {
        		
        	Price prices = new Price();
        	
        	prices.setPriority(PRIORITY_HIGH);
               		
       }else {
    	   
    	    Price prices = new Price();
       	
       	    prices.setPriority(PRIORITY_LOW);
    	   
       }	
       
    }
  }
	
	
	public static Priority valueOf(Priority priorityType) {
		
		return priorityType.get(priorityType);
	}
	
	Priority get(Priority priorityType) {
		// TODO Auto-generated method stub
		return priorityType;
	}

	public int getValue() {
        return value;
    }

}
