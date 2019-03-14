package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testAutomation.TestAutomation.base;

public class listener implements ITestListener
{
	base b = new base();

	@Override
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		try
		{
			b.takeScreenshot(result.getName());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

}
