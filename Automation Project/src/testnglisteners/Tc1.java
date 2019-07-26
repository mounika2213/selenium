package testnglisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Tc1 implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("tc on finish output is"+" "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext result1) {
		System.out.println("tc on start output is"+" "+result1.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result2) {
		System.out.println("tc on onTestFailedButWithinSuccessPercentage output is"+" "+result2.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result3) {
		System.out.println("tc onTestFailure is"+" "+result3.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result4) {
		System.out.println("tc onTestSkipped is"+" "+result4.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result5) {
		System.out.println("tc onTestStart is"+" "+result5.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result6) {
		System.out.println("tc onTestSuccess is"+" "+result6.getName());
		
	}
	

}