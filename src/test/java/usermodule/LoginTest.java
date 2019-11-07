package usermodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {
	
@Test	
public void ValidateLoginWithoutCredentials() {
	
	String filepath=System.getProperty("user.dir");
	
	String driverPath="\\src\\test\\resources\\drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver",filepath+ driverPath);
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.linkedin.com/");
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver,60);
	ExpectedConditions.elementToBeClickable(By.cssSelector(".sign-in-form__submit-btn"));

	WebElement loginButton=driver.findElement(By.cssSelector(".sign-in-form__submit-btn"));
	loginButton.click();
	
	WebElement alertMessage=driver.findElement(By.cssSelector(".input__message"));
	
	String alertMessageText=alertMessage.getText();
	Reporter.log("Login Button Warning message for not entering Username and Password");
	Assert.assertEquals(true, alertMessage.isDisplayed());
	driver.close();
}


@Test	
public void ValidateForgetPassword() {
	
	String filepath=System.getProperty("user.dir");
	
	String driverPath="\\src\\test\\resources\\drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver",filepath+ driverPath);
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.linkedin.com/");
	driver.manage().window().maximize();
	
	WebDriverWait wait= new WebDriverWait(driver,60);
	ExpectedConditions.elementToBeClickable(By.partialLinkText("Forgot password"));

	WebElement loginButton=driver.findElement(By.partialLinkText("Forgot password"));
	loginButton.click();
	
	String navigatedLink=driver.getCurrentUrl();
	
	
	Reporter.log("Forget Password navigating to request password page");
	Assert.assertEquals(true,navigatedLink.contains("request-password"));
	driver.close();
}

}
