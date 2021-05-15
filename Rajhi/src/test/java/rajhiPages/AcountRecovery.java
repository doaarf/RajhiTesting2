package rajhiPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AcountRecovery {
	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/forgot-password");

	@BeforeTest
	public void OpenURL()
	{
		String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe"  ;
		System.setProperty("webdriver.chrome.driver",chromePath );
		driver=new ChromeDriver();
	}




	@Test(priority = 3 ,enabled = true)
	public void SendToUserNameNotExist()
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optUserName = driver.findElement(By.id("edo-ani"));     

		//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", optUserName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optUserName);
		optUserName.isSelected();
		optUserName.sendKeys(Keys.ENTER);


		WebElement txtUserName=driver.findElement(By.id("txtUserName"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		//txtUserName.clear();
		txtUserName.sendKeys("admindo_123");
		txtUserName.sendKeys(Keys.ENTER);

		WebElement btnDone =driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.btn-block"));
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		
		//System.out.println("SendToUserNameNotExist Notification1 :  " +btnDone.getText());
		Assert.assertTrue(btnDone.getText().contains("Done"));

		WebElement msgError =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
	

	
		
		System.out.println("SendToUserNameNotExist Notification2 :  " +msgError.getText());
		
		Assert.assertTrue(msgError.getText().contains("This is an unverified username."));
		//Assert.assertTrue(msgError.getText().contains("Please enter valid username."));
		
		//driver.close();

	}



	///////////////////////////////////////////////////////////////////
	@Test(priority = 2 ,enabled = true)
	public void SendToUserNameExist()
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optUserName = driver.findElement(By.id("edo-ani"));     

		//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", optUserName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optUserName);

		optUserName.isSelected();
		optUserName.sendKeys(Keys.ENTER);


		WebElement txtUserName=driver.findElement(By.id("txtUserName"));


		txtUserName.clear();
		txtUserName.sendKeys("admindoaa");
		txtUserName.sendKeys(Keys.ENTER);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));


		WebElement btnLogin =driver.findElement(By.id("btnLogin"));
		Assert.assertTrue(btnLogin.getText().contains("Sign in"));

		WebElement successNotification =driver.findElement(By.id("toast-container"));
		Assert.assertTrue(successNotification.getText().contains("Please check your email for resetting your password."));
		//System.out.println("SendToUserNameExist  " + successNotification.getText());
	

	}

	///////////////////////////////////////////////////////////////////
	@Test(priority = 1 ,enabled = true)
	public void SendToUserNameBlanck()
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optUserName = driver.findElement(By.id("edo-ani"));     

		//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", optUserName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optUserName);

		optUserName.isSelected();


		WebElement txtUserName=driver.findElement(By.id("txtUserName"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		
		
		  txtUserName.clear(); 
		  txtUserName.sendKeys("");
		  txtUserName.sendKeys(Keys.ENTER); 
		  WebElement msgError =driver.findElement(By.cssSelector( "div.text.text-danger.mt-1"));
		  
		  
		  Assert.assertTrue(msgError.getText().contains("Please enter username."));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		 

		
		

	}

	///////////////////////////////////////////////////////////////////


	@Test(priority = 4 ,enabled = true)
	public void SendToEmailExist() throws InterruptedException
	{	
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optEmail = driver.findElement(By.id("edo-ani1"));  
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optEmail);
		Thread.sleep(200);

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));

				Thread.sleep(200);
				txtEmail.sendKeys("doaa.rf@gmail.com");
				txtEmail.sendKeys(Keys.ENTER);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

				Thread.sleep(200);

				WebElement btnLogin =driver.findElement(By.id("btnLogin"));
				Assert.assertTrue(btnLogin.getText().contains("Sign in"));

				WebElement successNotification =driver.findElement(By.id("toast-container"));
				Assert.assertTrue(successNotification.getText().contains("Please check your email for resetting your password."));
				//System.out.println("SendToEmailExist " + successNotification.getText());


	}

	@Test(priority = 5 ,enabled = true)
	public void SendToEmailNotExist() throws InterruptedException
	{	
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optEmail = driver.findElement(By.id("edo-ani1"));  
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optEmail);


		Thread.sleep(200);


		WebElement txtEmail=driver.findElement(By.id("txtEmail"));

				Thread.sleep(200);
				txtEmail.sendKeys("notregister@gmail.com");
				txtEmail.sendKeys(Keys.ENTER);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

				Thread.sleep(200);
				
				WebElement btnDone =driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.btn-block"));
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
				
				//System.out.println("SendToEmailNotExist Notification1 :  " +btnDone.getText());
				Assert.assertTrue(btnDone.getText().contains("Done"));

				WebElement msgError =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
				//System.out.println("SendToEmailNotExist Notification2 :  " +msgError.getText());
				Assert.assertTrue(msgError.getText().contains("This is an unverified email address."));
	}


	@Test(priority = 6 ,enabled = true)
	public void SendToEmailBlank() throws InterruptedException
	{	
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optEmail = driver.findElement(By.id("edo-ani1"));  
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optEmail);


		Thread.sleep(200);


		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		WebElement btnDone =driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.btn-block"));
		

		
		
				Thread.sleep(200);
				txtEmail.sendKeys("  ");
				txtEmail.sendKeys(Keys.TAB);
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnDone);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
				btnDone.sendKeys(Keys.ENTER);
				Thread.sleep(200);
				

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
				
				//System.out.println("SendToUserNameNotExist Notification1 :  " +btnDone.getText());
				Assert.assertTrue(btnDone.getText().contains("Done"));
				
				//btnDone.click();
				WebElement msgError =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
				//System.out.println("SendToEmailBlank Notification2 :  " +msgError.getText());
				Assert.assertTrue(msgError.getText().contains("Please enter email."));
	}
	
	@Test(priority = 7 ,enabled = true)
	public void SendToEmailNotValid() throws InterruptedException
	{	
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement optEmail = driver.findElement(By.id("edo-ani1"));  
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optEmail);


		Thread.sleep(200);


		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		WebElement btnDone =driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.btn-block"));
		

		
		
				Thread.sleep(200);
				txtEmail.sendKeys("NotValidEmailFormat");
				txtEmail.sendKeys(Keys.TAB);
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnDone);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
				btnDone.sendKeys(Keys.ENTER);
				Thread.sleep(200);
				

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
				
				//System.out.println("SendToUserNameNotExist Notification1 :  " +btnDone.getText());
				Assert.assertTrue(btnDone.getText().contains("Done"));
				
				//btnDone.click();
				WebElement msgError =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
				//System.out.println("SendToEmailNotValid Notification2 :  " +msgError.getText());
				Assert.assertTrue(msgError.getText().contains("Please enter valid email."));
	}
	
	
	@AfterTest
	public void Closedriver()
	{
		driver.quit();
	}





}
