package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.reports.Reports;

public class TestListeners extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		startReporting(testMethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		logger.pass("Test Execution is successfully completed for Test Case : " + testMethodName);
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		logger.fail("Test Execution is Failed for Test Case : " + testMethodName);
		logger.fail("Test Execution is Failed due to : " + result.getThrowable().getLocalizedMessage());
		stopReporting();
	}

}
