package com.demo1.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListImpl implements IRetryAnalyzer{
	int count=0;
	int limit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
	if(count<limit)
	{
		count++;
		return true;
	
	}
		return false;
	}

}
