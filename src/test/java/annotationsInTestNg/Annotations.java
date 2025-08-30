package annotationsInTestNg;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Annotations {

	@Test(priority =1)
	public void test1()
	{
		System.out.println("@Test 1");
	}
	
	@Test(priority=2)
	public void test2()
	{
		System.out.println("@Test 2");
	}
	
	//suit
	@BeforeSuite
	public void BeforeSuit()
	{
		System.out.println("BeforeSuit");
	}
	
	@AfterSuite
	public void AfterSuit()
	{
		System.out.println("AfterSuit");
	}
	
	//class
	
	    @BeforeClass
		public void BeforeClass()
		{
			System.out.println("BeforeClass");
		}
		
		@AfterClass
		public void AfterClass()
		{
			System.out.println("AfterClass");
		}
		   
		  //method
		  @BeforeMethod
			public void BeforeMethod()
			{
				System.out.println("BeforeMethod");
			}
			
			@AfterMethod
			public void AfterMethod()
			{
				System.out.println("AfterMethod");
			}
			
			//test
			 @BeforeTest
				public void BeforeTest()
				{
					System.out.println("BeforeTest");
				}
				
				@AfterTest
				public void AfterTest()
				{
					System.out.println("AfterTest");
				}
			
			
	
}
