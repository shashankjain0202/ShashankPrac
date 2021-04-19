package com.prac.utils.Listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.naming.Context;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.prac.base.baseClass;
import com.prac.utils.OtherUtils;

public class TestNGListener extends baseClass implements ITestListener {
	
	Logger _log;
	
	public  TestNGListener() {
		_log =  Logger.getLogger(TestNGListener.class);
		 
	}

	@Override
	public void onTestStart(ITestResult result) {
		_log.info("********************************************Started test case:"+ result.getName()+"***********************************************");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String destFilePath = System.getProperty("user.dir")+ "/failure_screenshots/"+ "/"+formater.format(calendar.getTime())+ "/"+result.getName()+".png";
		File destFile = new File(destFilePath);
		OtherUtils.takeScreenshot(destFile, driver);
		System.out.println("Taking screenshots for failure of test case:"+result.getName());
		
		
		
		
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
