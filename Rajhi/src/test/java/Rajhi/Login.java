package Rajhi;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/login");

	@BeforeTest
	public void OpenURL()
	{
		String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe"  ;
		System.setProperty("webdriver.chrome.driver",chromePath );
		driver=new ChromeDriver();
	}


	@Test(priority = 6 ,enabled = true)
	public void LoginSuccess()
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		//WebElement btnLogin=driver.findElement(By.id("btnLogin"));
		txtUsername.clear();
		txtUsername.sendKeys("admindoaa");

		txtpassword.clear();
		txtpassword.sendKeys("Test_1234");
		//btnLogin.click();
		txtpassword.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnLogout =driver.findElement(By.id("btnLogout"));
		Assert.assertEquals(btnLogout.getAriaRole(), "Ignored");
	
	
		
	
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Home"));
		//System.out.println(driver.getTitle());
		


		//WebElement successNotification =driver.findElement(By.id("flash"));
		//Assert.assertTrue(successNotification.getText().contains("You logged into a secure area!"));
		//Assert.assertEquals(Iconlog.getText(), (" Secure Area"));
		//Assert.assertTrue(Iconlog.getText().contains(" Secure Area"));
		//System.out.println(btnLogout.getText());
	}
	@Test(priority = 7 ,enabled = false)
	public void LoginSuccessFirstTime()
	{	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		//WebElement btnLogin=driver.findElement(By.id("btnLogin"));
		txtUsername.clear();
		txtUsername.sendKeys("admindoaa");

		txtpassword.clear();
		txtpassword.sendKeys("admindoaaAdmin@123");
		//btnLogin.click();
		txtpassword.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnDone =driver.findElement(By.id("btnResetPassword"));
		Assert.assertEquals(btnDone.getText(), "Done");
	
	
		
		//System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Create Password"));
		
		


	}

	@Test(priority = 5 ,enabled = true)
	public void LoginFailWrongPW() 
	{ 
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		//WebElement btnLogin=driver.findElement(By.id("btnLogin"));

		txtUsername.clear(); 
		txtUsername.sendKeys("admindoaa"); 
		
		txtpassword.clear();
		txtpassword.sendKeys("Test_890"); 
		txtpassword.sendKeys(Keys.ENTER);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		WebElement failNotification =driver.findElement(By.id("toast-container"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
		Assert.assertTrue(failNotification.getText().contains("Operation error"));
		Assert.assertTrue(failNotification.getText().contains("The username or password is wrong"));
		//System.out.println("LoginFailWrongPassword "+failNotification.getText());
	}


	@Test(priority = 4 ,enabled = true)    //,enabled = false) 
	public void LoginFailWrongUserName() 
	{
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));

		
		txtUsername.clear(); 
		txtUsername.sendKeys("admindoaa123"); 
		txtpassword.clear();
		txtpassword.sendKeys("Test_1234"); 

		txtpassword.sendKeys(Keys.ENTER);


		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		WebElement failNotification =driver.findElement(By.id("toast-container"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
		Assert.assertTrue(failNotification.getText().contains("Operation error"));
		Assert.assertTrue(failNotification.getText().contains("The username or password is wrong"));
		//System.out.println("LoginFailWrongUserName "+failNotification.getText());

	}

	@Test(priority = 3 ,enabled = true) 
	public void LoginFailBlankPW() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		WebElement btnLogin=driver.findElement(By.id("btnLogin"));

		txtUsername.clear(); 
		txtUsername.sendKeys("admindoaa"); 
		txtpassword.clear();
		txtpassword.sendKeys("");
		txtpassword.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, ""))).click()
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		//btnLogin.click();


		WebElement msgerror =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
		//System.out.println(msgerror.getText());
		Assert.assertTrue(msgerror.getText().contains("Please enter the password"));
		//driver.close();
	}
	@Test(priority = 2 ,enabled = true) 
	public void LoginFailBlankUsername() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		WebElement btnLogin=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));

		txtUsername.clear(); 
		txtUsername.sendKeys(""); 
		txtpassword.clear();
		txtpassword.sendKeys("Test_1234"); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, ""))).click()
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		//btnLogin.click();
		txtpassword.sendKeys(Keys.ENTER);


		WebElement msgerror =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
		//System.out.println(msgerror.getText());
		Assert.assertTrue(msgerror.getText().contains("Please enter the username"));
		//driver.close();
	}

	@Test(priority = 1 ,enabled = true) 
	public void LoginFailBlankUsernameAndPw() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));




		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		WebElement btnLogin=driver.findElement(By.id("btnLogin"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	




		try {
			txtUsername.clear(); 
			txtUsername.sendKeys("");

			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

			txtpassword.clear();
			txtpassword.sendKeys(""); 
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			btnLogin.click();
			//System.out.println(msgerror1.getText());

			WebElement msgerror1 =driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[1]/div"));      //(By.cssSelector("div.text.text-danger.mt-1"));
			WebElement msgerror2 =driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[2]/div[2]"));//(By.cssSelector  ("div.text.text-danger.mt-1"));

			Assert.assertTrue(msgerror1.getText().contains("Please enter the username" ));
			//System.out.println(msgerror1.getText());


			Assert.assertTrue(msgerror2.getText().contains("Please enter the password"));
			//System.out.println(msgerror2.getText());
			//driver.close();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Error   >>>>>" + e);
		}



	}

	@AfterTest
	public void Closedriver()
	{
		driver.quit();
	}






}
