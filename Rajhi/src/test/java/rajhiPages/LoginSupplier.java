package rajhiPages;

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

public class LoginSupplier {
	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/supplier/login");
	String UserName=("doaa.sup2");
	String Password=("Test_1234");

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
		txtUsername.sendKeys(UserName);

		txtpassword.clear();
		txtpassword.sendKeys(Password);
		//btnLogin.click();
		txtpassword.sendKeys(Keys.ENTER);



		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnNext =driver.findElement(By.id("txtSaveDetails"));
		//Assert.assertEquals(btnNext.getText(), " Next ");
		Assert.assertTrue(btnNext.getText().contains("Next"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement CardHeader =driver.findElement(By.cssSelector("div.card-header"));
		//Assert.assertEquals(CardHeader.getText(), "Supplier Registration Form");
		System.out.println("CardHeader   :" +CardHeader.getText());
		Assert.assertTrue(CardHeader.getText().contains("Supplier Registration Form"));
		Assert.assertTrue(CardHeader.getText().contains("Fill out Steps of the form to complete the registration"));

		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Supplier Registration"));




	}

	@Test(priority = 5 ,enabled = true)
	public void LoginFailWrongPW() 
	{ 
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));


		txtUsername.clear(); 
		txtUsername.sendKeys(UserName); 
		txtpassword.clear();
		txtpassword.sendKeys("Test_890"); 


		txtpassword.sendKeys(Keys.ENTER);




		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement failNotification =driver.findElement(By.id("toast-container"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		System.out.println("LoginFailWrongPW "+failNotification.getText());
		Assert.assertTrue(failNotification.getText().contains("Operation error"));
		Assert.assertTrue(failNotification.getText().contains("The username or password is wrong"));

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
		txtpassword.sendKeys(Password); 

		txtpassword.sendKeys(Keys.ENTER);
		//btnLogin.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement failNotification =driver.findElement(By.id("toast-container"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		System.out.println("LoginFailWrongUserName "+failNotification.getText());
		Assert.assertTrue(failNotification.getText().contains("Operation error"));
		Assert.assertTrue(failNotification.getText().contains("The username or password is wrong"));

	}

	@Test(priority = 3 ,enabled = true) 
	public void LoginFailBlankPW() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement txtUsername= driver.findElement(By.id("txtUserName"));;
		WebElement txtpassword=driver.findElement(By.id("txtPassword"));
		WebElement btnLogin=driver.findElement(By.id("btnLogin"));

		txtUsername.clear(); 
		txtUsername.sendKeys(UserName); 
		txtpassword.clear();
		txtpassword.sendKeys("");
		txtpassword.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, ""))).click()
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		//btnLogin.click();


		WebElement msgerror =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
		System.out.println(msgerror.getText());
		Assert.assertTrue(msgerror.getText().contains("Please enter password."));
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
		txtpassword.sendKeys(Password); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, ""))).click()
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		//btnLogin.click();
		txtpassword.sendKeys(Keys.ENTER);


		WebElement msgerror =driver.findElement(By.cssSelector("div.text.text-danger.mt-1"));
		System.out.println(msgerror.getText());
		Assert.assertTrue(msgerror.getText().contains("Please enter username."));
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

			WebElement msgerror1 =driver.findElement(By.xpath("/html/body/app-root/app-supplier-login/div/div/div/div/div/div[2]/form/div[1]/div"));      //(By.cssSelector("div.text.text-danger.mt-1"));
			WebElement msgerror2 =driver.findElement(By.xpath("/html/body/app-root/app-supplier-login/div/div/div/div/div/div[2]/form/div[2]/div[2]"));//(By.cssSelector  ("div.text.text-danger.mt-1"));


			System.out.println(msgerror1.getText());
			Assert.assertTrue(msgerror1.getText().contains("Please enter username." ));


			System.out.println(msgerror2.getText());


			Assert.assertTrue(msgerror2.getText().contains("Please enter password."));

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
