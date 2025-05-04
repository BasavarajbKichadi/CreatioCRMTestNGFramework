package com.creatio.crm.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 2;

	@Override
	public boolean retry(ITestResult result) {

		if (!result.isSuccess()) { // verify whether test case is failed
			if (count < retryCount) { // verify count value is less than max retry count
				count++; // increase count by 1 every time
				return true; // retry test case
			}
		}

		return false; // no need to retry as test is successful
	}

}
