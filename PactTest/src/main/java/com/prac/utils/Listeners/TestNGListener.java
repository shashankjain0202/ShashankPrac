package com.prac.utils.Listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.prac.base.baseClass;
import com.prac.utils.OtherUtils;

public class TestNGListener extends baseClass implements ITestListener{
	
	Logger _log;
	
	public  TestNGListener() {
		_log =  Logger.getLogger(TestNGListener.class);		 
	}

	@Override
	public void onTestStart(ITestResult result) {
		_log.info("***************************************Started test case:"+ result.getName()+"***********************************************");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		_log.info("***************************************Great: Test case passed:"+ result.getName()+"***********************************************");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		_log.info("***************************************Alert: Test case Failed:"+ result.getName()+"***********************************************");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
