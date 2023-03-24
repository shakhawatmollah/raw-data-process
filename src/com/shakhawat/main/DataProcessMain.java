package com.shakhawat.main;

import java.io.IOException;

import com.shakhawat.service.CustomerService;

public class DataProcessMain implements Runnable {
	
	public void run() {
		
		String FILE_NAME = "resources/files/customers.txt";
		
		long start = System.currentTimeMillis();
		
		try {
			CustomerService.readFileAndProcessCustomers(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		
		System.out.println("The store process took "+timeElapsed/1000+" seconds to execute");
	}

	public static void main(String[] args) {
		DataProcessMain dataProcessMain = new DataProcessMain();
		Thread thread = new Thread(dataProcessMain);
		thread.start();
	}

}
