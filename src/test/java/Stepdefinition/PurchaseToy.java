package Stepdefinition;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
public class PurchaseToy {

	WebDriver driver=null;
	@Before()
	public void chrome() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}



	@Given("^I open guru99 website$")
	public void go_To_guru99() throws Throwable {
		driver.navigate().to("http://demo.guru99.com/payment-gateway/purchasetoy.php");
		TakesScreenshot ts1 =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file

		File SrcFile=ts1.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination
		File DestFile=new File("./target/Screenshots/NavigatedtowebsitePage.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);



	}
	@When("^user enters valid data details on the page$")
	public void enter_Data(DataTable table) throws Throwable{
		List<List<String>> data = table.raw();
		driver.findElement(By.xpath("//body/section[@id='three']/div[1]/form[1]/div[1]/div[4]/select[1]")).sendKeys(data.get(1).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/section[@id='three']/div[1]/form[1]/div[1]/div[8]/ul[1]/li[1]/input[1]")).click();
		driver.findElement(By.id("card_nmuber")).sendKeys(data.get(2).get(1));
		Thread.sleep(2000);
		Select drpmonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		drpmonth.selectByVisibleText(data.get(3).get(1));
		Thread.sleep(2000);
		Select drpyear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		drpyear.selectByVisibleText(data.get(4).get(1));
		Thread.sleep(2000);
		driver.findElement(By.id("cvv_code")).sendKeys(data.get(5).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/section[@id='three']/div[1]/form[1]/div[2]/div[1]/ul[1]/li[1]/input[1]")).click();
		Thread.sleep(2000);

	}


	@Then("^payment should be done$")
	public void payment_Successful() throws Throwable{
		boolean purchase ;
		if(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/h2[1]")).isDisplayed())
		{
			purchase = true;
		}
		else {
			purchase = false;
		}
		if(purchase) {
			System.out.println();
			System.out.println("Payment successfull");
			TakesScreenshot ts =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file

			File SrcFile=ts.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File("./target/Screenshots/PaymentSuccessfulPage.png");
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);


		}
		else {
			System.out.println("Payment unsuccessful");
		}


	}


	@After
	public void afterClosing() throws Throwable {
		driver.close();
		System.out.println("**************Ended***************");

	}



}