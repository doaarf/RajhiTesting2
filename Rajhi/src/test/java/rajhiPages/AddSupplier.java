package rajhiPages;

//import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSupplier {

	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/supplier/sign-up");

	@BeforeTest
	public void OpenURL()
	{
		String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe"  ;
		System.setProperty("webdriver.chrome.driver",chromePath );
		driver=new ChromeDriver();
	}


	@Test(priority = 1 ,enabled = true)
	public void AddnewSupplierSuccess() throws InterruptedException
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear();
		txtFirstName.sendKeys("Doaa");



		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear();
		txtLastName.sendKeys("Supplier");


		WebElement txtUserName=driver.findElement(By.id("txtUserName"));
		txtUserName.clear(); 
		txtUserName.sendKeys("doaa.sup2");


		WebElement  txtEmail=driver.findElement(By.id("txtEmail"));  
		txtEmail.clear(); 
		txtEmail.sendKeys("doaaa.rf@gmail.com");

		WebElement txtPhone=driver.findElement(By.id("txtPhone"));
		txtPhone.clear(); 
		txtPhone.sendKeys("+9668989898989");

		Thread.sleep(300);


		WebElement txtPassword=driver.findElement(By.id("txtPassword")); 
		txtPassword.clear(); 
		txtPassword.sendKeys("Test_1234");



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_1234");


		/*
		 * WebElement Cboxrecaptcha=driver.findElement(By.xpath(
		 * "//*[@id=\"recaptcha-anchor\"]/div[1]")); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();", Cboxrecaptcha);
		 * 
		 * Cboxrecaptcha.isSelected(); Cboxrecaptcha.sendKeys(Keys.ENTER);
		 * //Cboxrecaptcha.click();
		 */
		WebElement chkAgreement=driver.findElement(By.id("chkAgreement"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkAgreement);

		chkAgreement.isSelected();
		chkAgreement.sendKeys(Keys.ENTER);

Thread.sleep(400);

		/*
		 * WebElement labelAgreement=driver.findElement(By.id("labelAgreement"));
		 * ////*[@id="labelAgreement"] //chkAgreement.sendKeys(Keys.ENTER);
		 * labelAgreement.click(); if (!labelAgreement.isSelected()) {
		 * labelAgreement.click(); }
		 */



		/*


		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 * //WebElement btnLogout =driver.findElement(By.id("btnLogout"));
		 * //Assert.assertEquals(btnLogout.getAriaRole(), "Ignored");

		 * //assertTrue(driver.getTitle().startsWith("RajhiSteel/Home"));
		 * //System.out.println(driver.getTitle());

		 * //WebElement successNotification =driver.findElement(By.id("flash"));
		 * //Assert.assertTrue(successNotification.getText().
		 * contains("You logged into a secure area!"));
		 * //Assert.assertEquals(Iconlog.getText(), (" Secure Area"));
		 * //Assert.assertTrue(Iconlog.getText().contains(" Secure Area"));
		 * //System.out.println(btnLogout.getText());
		 */	}



	@AfterTest
	public void Closedriver()
	{
		//driver.quit();
	}

}
