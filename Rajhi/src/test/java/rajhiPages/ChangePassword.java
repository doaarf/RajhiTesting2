package rajhiPages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangePassword {


	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/login");
	String URL1=("https://rajhisteelweb.azurewebsites.net/#/profile/change-password");
	String UserName = ("admindoaa");
	String PW=("Test_1234");
	@BeforeTest
	public void OpenURL()
	{


		String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe"  ;
		System.setProperty("webdriver.chrome.driver",chromePath );
		driver=new ChromeDriver();	
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));


		WebElement txtUsername= driver.findElement(By.id("txtUserName"));
		txtUsername.clear();
		txtUsername.sendKeys(UserName);

		WebElement txtpassword=driver.findElement(By.id("txtPassword")); 
		txtpassword.clear(); 
		txtpassword.sendKeys(PW);
		txtpassword.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnLogout =driver.findElement(By.id("btnLogout"));
		System.out.println(btnLogout.getText());
		//Assert.assertEquals(btnLogout.getAriaRole(), "Ignored");
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Home"));
	}

	@Test(priority = 1 ,enabled = true)
	public void ChangePWFailBlankOPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		//txtOldPassword.clear(); 
		txtOldPassword.sendKeys("");


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test_1234");



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_1234");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
		System.out.println("ChangePWFailBlankOPW  "+ErrorMsg.getText());
		Assert.assertTrue(ErrorMsg.getText().contains("Please enter old password."));

	}


	@Test(priority = 2 ,enabled = true)
	public void ChangePWFailBlankCPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		txtOldPassword.clear(); 
		txtOldPassword.sendKeys("Test_1234");


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test_1234");



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		//txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);


		//Please type your new password. 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
		System.out.println("ChangePWFailBlankCPW  "+ErrorMsg.getText());
		Assert.assertTrue(ErrorMsg.getText().contains("Please retype your new password again."));

	}


	@Test(priority = 3 ,enabled = true)
	public void ChangePWFailBlankNPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		txtOldPassword.clear(); 
		txtOldPassword.sendKeys("Test_1234");


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		//txtNewPassword.clear(); 
		txtNewPassword.sendKeys("");
		txtNewPassword.sendKeys(Keys.TAB);



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_1234");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg1 =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
		System.out.println("ChangePWFailBlankNPW  "+ErrorMsg1.getText());
		Assert.assertTrue(ErrorMsg1.getText().contains("Please type your new password."));



	}



	@Test(priority = 4 ,enabled = true)
	public void ChangePWFailNotMatchNPWCPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		txtOldPassword.clear(); 
		txtOldPassword.sendKeys("Test_1234");


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test_1234");
		txtNewPassword.sendKeys(Keys.TAB);


		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_12345");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);


		//Please type your new password. 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg2 =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
		System.out.println("ChangePWFailNotMatchNPWCPW  "+ErrorMsg2.getText());
		Assert.assertTrue(ErrorMsg2.getText().contains("Those passwords don't match. Try again."));

	}
	
	
	

	@Test(priority = 5 ,enabled = true)
	public void ChangePWFailWrongOPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		//txtOldPassword.clear(); 
		txtOldPassword.sendKeys("Test_12345");


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test_1234");



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_1234");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg =driver.findElement(By.cssSelector("ngb-alert.alert.alert-danger.ng-star-inserted"));
		System.out.println("ChangePWFailWrongOPW  "+ErrorMsg.getText());
		Assert.assertTrue(ErrorMsg.getText().contains("Sorry, wrong password."));

	}
	

	@Test(priority = 6 ,enabled = true)
	public void ChangePWNotMatchCriteriaNPW() throws InterruptedException
	{	


		////////////////////////////////////////////////////////

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		txtOldPassword.clear(); 
		txtOldPassword.sendKeys(PW);


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test1234");
		


		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test1234");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMsg =driver.findElement(By.cssSelector("div.text.text-danger.mt-1.ng-star-inserted"));
		System.out.println("ChangePWNotMatchCriteriaNPW  "+ErrorMsg.getText());
		Assert.assertTrue(ErrorMsg.getText().contains("Please,use 8 or more characters with a mix of letters, numbers & symbols."));



	}
	
	

	////////////////////////////////////////////////////////		////////////////////////////////////////////////////////		////////////////////////////////////////////////////////
	@Test(priority = 8 ,enabled = false)
	public void ChangePWSuccess() throws InterruptedException
	{	

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();

		WebElement txtOldPassword=driver.findElement(By.id("txtOldPassword"));
		txtOldPassword.clear(); 
		txtOldPassword.sendKeys(PW);


		WebElement txtNewPassword=driver.findElement(By.id("txtNewPassword")); 
		txtNewPassword.clear(); 
		txtNewPassword.sendKeys("Test_1234");



		WebElement txtConfirmPassword=driver.findElement(By.id("txtConfirmPassword"));
		txtConfirmPassword.clear(); 
		txtConfirmPassword.sendKeys("Test_1234");


		txtConfirmPassword.sendKeys(Keys.TAB);
		WebElement btnDone=driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
		btnDone.sendKeys(Keys.ENTER);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnLogin =driver.findElement(By.id("btnLogin"));
		Assert.assertEquals(btnLogin.getText(), "Sign in");
		//System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Sign in"));
		//System.out.println(driver.getTitle());


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("ChangePWSuccess  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Please login using your new credential's password."));
	}



	@AfterTest
	public void Closedriver()
	{
		driver.quit();
	}




}
