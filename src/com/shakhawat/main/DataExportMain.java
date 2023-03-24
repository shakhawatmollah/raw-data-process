package com.shakhawat.main;

import com.shakhawat.service.CustomerService;

public class DataExportMain implements Runnable {
	
	public void run() {
		
		long start = System.currentTimeMillis();
		CustomerService.chunkValidCustomerExport();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("The valid customer export process (batch) took "+timeElapsed/1000+" seconds to execute");
		
		try {
			long startValidCust = System.currentTimeMillis();
			CustomerService.exportDataFromDatabase("SELECT * FROM CUSTOMER_VALID;", "valid-customers");
			long finishValidCust = System.currentTimeMillis();
			long timeElapsedValidCust = finishValidCust - startValidCust;
			System.out.println("The valid customer export process took "+timeElapsedValidCust/1000+" seconds to execute");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			long startInvalidCust = System.currentTimeMillis();
			CustomerService.exportDataFromDatabase("SELECT * FROM CUSTOMER_INVALID;", "invalid-customers");
			long finishInvalidCust = System.currentTimeMillis();
			long timeElapsedInvalidCust = finishInvalidCust - startInvalidCust;
			System.out.println("The invalid customer export process took "+timeElapsedInvalidCust/1000+" seconds to execute");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DataExportMain dataExportMain = new DataExportMain();
		Thread thread = new Thread(dataExportMain);
		thread.start();
	}

}
