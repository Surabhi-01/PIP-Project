package stepDefination;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Maps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")

public class DealsMapStepDefination {

	 WebDriver driver;

	@Given("^user is already on Login page$")
	public void user_is_already_on_Login_Page() {		
		WebDriverManager.chromedriver().version("83.0.4103.39").setup();
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^Title of login page is Cogmento CRM$")
	public void title_of_login_page_is_Cogmento_CRM() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title);
	Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
	}

	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		}

	@Then("^User clicks on Login button$")
	public void user_clicks_on_Login_button() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//WebElement loginBtn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", loginBtn);
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

	}

	@Then("^User is on HomePage$")
	public void user_is_on_HomePage() {
		String title = driver.getTitle();
		
		Assert.assertEquals("Cogmento CRM", title);	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deal_page() throws Throwable {
		
		driver.findElement(By.xpath("//span[contains(text(),'Deals')]")).click(); 	
		
		/*WebElement DealBtn = driver.findElement(By.xpath("//span[contains(text(),'Deals')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", DealBtn);*/
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		//driver.findElement(By.xpath("//button[contains(text(),'New')]")).click(); 
		
		WebElement newBtn = driver.findElement(By.xpath("//button[contains(text(),'New')]"));
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click();", newBtn);
				
		
		
		
	}
	   
	@Then("^user enters deal details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_deal_details_and_and_and(String title,String amount, 
			String probability, String commission) throws Exception {
	   
		driver.findElement(By.name("title")).sendKeys(title);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("amount")).sendKeys(amount);	
		
		driver.findElement(By.name("probability")).sendKeys(probability);
		
		driver.findElement(By.name("commission")).sendKeys(commission);	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
			
		
		//move to new deals page
		driver.findElement(By.xpath("//a[contains(@href,'/deals')]")).click(); 	
	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		//driver.findElement(By.xpath("//button[contains(text(),'New')]")).click(); 
		
		WebElement newBtn1 = driver.findElement(By.xpath("//button[contains(text(),'New')]"));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", newBtn1);
		
	
			
	}

	//Closing the browser 
	@Then("^Close the browser$")
	public void close_the_browser()  {
		
		driver.findElement(By.xpath("//*[@role='listbox']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		driver.quit();	
   //Test Case Completed
}
}