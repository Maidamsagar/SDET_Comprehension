package PROJECT_SAMPLE;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProbQ3 {
	WebDriver driver;
	//intializing driver 
	@BeforeMethod
	void start()
	{
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\HOME\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flights");
	}
	
	//runing test method
	@Test
	void test()
	{
		System.out.print(driver.getTitle());
	}
	
	//closing browser

	@AfterMethod
	void teardown()
	{
		driver.quit();
	}

}
