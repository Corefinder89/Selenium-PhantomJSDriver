package Scenarios;

class Sleep
{
	public void WaitForElement(int time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}