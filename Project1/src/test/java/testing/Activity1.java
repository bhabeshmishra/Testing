package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	WebDriver delegate;
	SelfHealingDriver driver;
//	@FindBy(xpath = "//*[contains(text(),'Gmail')]")
//	WebElement gmailButton;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		delegate = new ChromeDriver();
		driver = SelfHealingDriver.create(delegate);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[contains(text(),'Gmail')]")).click();
//		gmailButton.click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void exit() {
		driver.quit();
	}

}
