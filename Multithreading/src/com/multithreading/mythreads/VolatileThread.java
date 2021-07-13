package com.multithreading.mythreads;

public class VolatileThread extends Thread {
	private final VolatileData volatileData;   
	
	public VolatileThread(VolatileData volatileData) {
		// TODO Auto-generated constructor stub
		this.volatileData=volatileData;
		
	}
	@Override  
	public void run()  
	{  
	int oldValue = volatileData.getCounter();  
	System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);  
	volatileData.increaseCounter();  
	int newValue = volatileData.getCounter();  
	System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);  
	}  

}
