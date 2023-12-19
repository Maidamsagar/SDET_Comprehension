package PROJECT_SAMPLE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripQ2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(5000);
		//To Click on Flights
		
		driver.findElement(By.className("menu_Flights")).click();
		
		// To select RoundTrip
		
		driver.findElement(By.xpath("//li[@data-cy=\"roundTrip\"]")).click();
		
		//to click on "From"
		
		driver.findElement(By.id("fromCity")).click();
		
		// Taking From Location "HYD"
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("HYD");
		
		driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']")).click();
		
		//to click on "To"
		
		driver.findElement(By.id("toCity")).click();
		
		// Enter To Location "MAA"
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input")).sendKeys("MAA");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label")).click();
		
		// To select DEPARTURE Date(27-09-2023)
		
		driver.findElement(By.xpath("//div[@aria-label=\"Wed Dec 27 2023\"]")).click();
		
		// To select RETURN Date(28-09-2023)
		
		driver.findElement(By.id("return")).click();
		
		driver.findElement(By.xpath("//div[@aria-label=\"Thu Dec 28 2023\"]")).click();
		
		//To click on SEARCH button
		
		driver.findElement(By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"]")).click();
		
		//Verify the Search page is displayed as expected
		String text= driver.findElement(By.xpath("//p[@class=\"font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom\"]")).getText();
		
		
		Assert.assertEquals(text,"Flights from Hyderabad to Chennai, and back");
			
	
		System.out.print("Test Passed");
		
		driver.quit();
		
		
		
	
		

	

	



	}

}
