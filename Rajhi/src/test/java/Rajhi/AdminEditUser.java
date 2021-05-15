package Rajhi;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminEditUser {
	//private static final WebElement String = null;
	//ChromeDriver driver ;
	FirefoxDriver driver;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/login");
	String URL1=("https://rajhisteelweb.azurewebsites.net/#/user");
	String TxtSearch=("User100"); //doaaa.nassar@hotmail.com

	@BeforeTest
	public void OpenURL() throws InterruptedException
	{

		//String chromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe"  ;
		//System.setProperty("webdriver.chrome.driver",chromePath );
		//driver=new ChromeDriver();
		
		
		String firefoxPath = System.getProperty("user.dir") + "\\Resources\\geckodriver.exe"  ;
		System.setProperty("webdriver.gecko.driver",firefoxPath );
		
		driver =new FirefoxDriver(); 
		
		
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement txtUsername= driver.findElement(By.id("txtUserName"));
		txtUsername.clear();
		txtUsername.sendKeys("admindoaa");

		WebElement txtpassword=driver.findElement(By.id("txtPassword")); 
		txtpassword.clear(); 
		txtpassword.sendKeys("Test_1234");
		txtpassword.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnLogout =driver.findElement(By.id("btnLogout"));
		Assert.assertEquals(btnLogout.getAriaRole(), "Ignored");
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Home"));

		////////////////////////////Navigate to edit after search//////////////////////////////////
		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		WebElement txtSearch =driver.findElement(By.id("txtSearch"));
		//txtSearch.clear();
		txtSearch.sendKeys(TxtSearch);
		txtSearch.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement SelectorName =driver.findElement(By.cssSelector("span.font-primary.first_name_0"));
		Thread.sleep(1000);

		

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("span.font-primary.first_name_0"),TxtSearch));
		
		
		System.out.println("SelectorName  "+SelectorName.getText());
		Assert.assertTrue(SelectorName.getText().contains(TxtSearch));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnEdit =driver.findElement(By.id("btnEdit"));
		btnEdit.click();


	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test(priority = 1 ,enabled = false)

	public void EditSuccessRequired() throws InterruptedException
	{			


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); 
		txtPhone.clear();
		txtPhone.sendKeys("");	
		txtPhone.sendKeys(Keys.TAB);


		WebElement txtExt=driver.findElement(By.id("txtExt"));
		txtExt.clear();
		txtExt.sendKeys("");
		txtExt.sendKeys(Keys.TAB);

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear();
		txtMobile.sendKeys("");
		//txtMobile.sendKeys(Keys.TAB);

		
		//WebElement optionBranchlist = driver.findElement(By.xpath("	//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[1]/div/ng-select/div/div/div[3]/input"));
		//optionBranchlist.sendKeys("Head Quarter");
		//optionBranchlist.sendKeys(Keys.TAB);


		//WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[2]/div/ng-select/div/div/div[3]/input"));
		//optionDepartmentlist.sendKeys("IT");
		//optionDepartmentlist.sendKeys(Keys.TAB);

		//WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[1]/div/ng-select/div/div/div[3]/input"));
		//optionTitlelist.sendKeys("Web Portal Admin");
		//optionTitlelist.sendKeys(Keys.TAB);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[2]/div/ng-select/div/div/div[3]/input"));
		//optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.TAB);


		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.

	}


	@Test(priority = 2 ,enabled = false)
	public void EditUserSuccessFName() 
	{			

		String FirstName=("Dodo");

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); 
		txtFirstName.sendKeys(FirstName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.

	}
	
	
	
	
	@Test(priority = 3 ,enabled = false)
	public void EditUserSuccessLName() 
	{			

		String LastName=("Dodo");

		WebElement txtLastName= driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); 
		txtLastName.sendKeys(LastName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.

	}
	
	@Test(priority = 4 ,enabled = false)
	public void EditSuccessBranch() 
	{			

		WebElement optionBranchlist = driver.findElement(By.xpath("	//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[1]/div/ng-select/div/div/div[3]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		//optionBranchlist.sendKeys("");
		optionBranchlist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.
		
	}
	
	
	@Test(priority = 5 ,enabled = false)
	public void EditSuccessDepartment() 
	{			
		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[2]/div/ng-select/div/div/div[3]/input"));
		optionDepartmentlist.sendKeys("IT");
		//optionDepartmentlist.sendKeys("");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.

	}
	
	
	@Test(priority = 6 ,enabled = false)
	public void EditSuccessPosition() 
	{			
		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[2]/div/ng-select/div/div/div[3]/input"));
		optionPositionlist.sendKeys("IT Manager");
		//optionPositionlist.sendKeys("");
		optionPositionlist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.

	}
	
	@Test(priority = 7 ,enabled = false)
	public void EditSuccessTitle() 
	{			
		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[1]/div/ng-select/div/div/div[3]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		//optionTitlelist.sendKeys("");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		//btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("EditSuccessRequired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("Your changes have been saved successfully.")); 
		//Operation done successfully", "Your changes have been saved successfully.
	}
	
	

	@Test(priority =8 ,enabled = true)

	public void EditSuccessEmail()
	{					

		String email=("doaa.rf@gmaiTest.com");

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtEmail.sendKeys(Keys.ENTER);
		
		


		
		WebElement alert2 = driver.findElement(By.cssSelector("div.swal2-popup.swal2-modal.swal2-show"));
		System.out.println(alert2.getText());
		 WebElement Ok =driver.findElement(By.cssSelector("button.swal2-confirm.swal2-styled"));
		Ok.sendKeys(Keys.ENTER);
		  
		  //WebElement alertCancel = driver.findElement(By.cssSelector("button.swal2-cancel.swal2-styled"));
		 
		
		//btnSubmit.sendKeys(Keys.ENTER);
		//swal2-content   // button.swal2-confirm.swal2-styled  OK//button.swal2-cancel.swal2-styled   Cancel
		
		
		//Alert alert =driver.switchTo().alert();
		//alert.accept();

		/*
		 * WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		 * btnSubmit.sendKeys(Keys.ENTER); //btnSubmit.click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		 * WebElement Notification =driver.findElement(By.id("toast-container"));
		 * System.out.println("EditSuccessRequired  "+Notification.getText());
		 * Assert.assertTrue(Notification.getText().
		 * contains("Operation done successfully"));
		 * Assert.assertTrue(Notification.getText().
		 * contains("Your changes have been saved successfully.")); //Operation done
		 * successfully", "Your changes have been saved successfully.
		 * 
		 * //swal2-content // button.swal2-confirm.swal2-styled
		 * OK//button.swal2-cancel.swal2-styled Cancel
		 */
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test(priority = 10 ,enabled = false)
	public void EditFailsFnameNotEnglish() 
	{			
		String FirstName=("محمد");

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); 
		txtFirstName.sendKeys(FirstName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailsFnameNotEnglish  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Sorry, the name must by alphabetical character (a-z)."));

	}

	@Test(priority = 11 ,enabled = false)
	public void EditFailsFnameBlank() 
	{			
		String FirstName=("");

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); 
		txtFirstName.sendKeys(FirstName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailsFnameBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter first name."));

	}
	
	

	@Test(priority = 12 ,enabled = false)
	public void EditFailsLnameNotEnglish() 
	{			
		String LastName=("محمد");

		WebElement txtLastName= driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); 
		txtLastName.sendKeys(LastName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailsLnameNotEnglish  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Sorry, the name must by alphabetical character (a-z)."));

	}
	
	@Test(priority = 13 ,enabled = false)
	public void EditFailsLnameBlank() 
	{			
		String LastName=("");

		WebElement txtLastName= driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); 
		txtLastName.sendKeys(LastName);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailsLnameBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter first name."));

	}
	
	

	
	
	@Test(priority = 14 ,enabled = false)
	public void EditFailBranchBlank() 
	{			

		WebElement optionBranchlist = driver.findElement(By.xpath("	//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[1]/div/ng-select/div/div/div[3]/input"));
		//optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys("");
		optionBranchlist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailBranchBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please select branch."));
	}
	
	


	@Test(priority = 15 ,enabled = false)
	public void EditFailDepartmentBlank() 
	{			
		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[4]/div[2]/div/ng-select/div/div/div[3]/input"));
		//optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys("");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsDepartmentBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please select department."));



	}

	@Test(priority = 16 ,enabled = false)
	public void EditFailpositionBlank() 
	{			
		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[2]/div/ng-select/div/div/div[3]/input"));
		//optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys("");
		optionPositionlist.sendKeys(Keys.ENTER);
		

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailpositionBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please select position."));
		
		

	}

	@Test(priority = 17 ,enabled = false)
	public void EditFailTitleBlank() 
	{			
		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"canvas-bookmark\"]/div/div[2]/main/app-user-edit-components/div/div/div/div/div[2]/form/div[5]/div[1]/div/ng-select/div/div/div[3]/input"));
		//optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys("");
		optionTitlelist.sendKeys(Keys.ENTER);
		

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailTitleBlank "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please select job title."));
		

	}
	

	@Test(priority = 18 ,enabled = false)
	public void EditFailPhone() 
	{			
		String Phone=("+96600");

		WebElement txtPhone= driver.findElement(By.id("txtPhone"));
		txtPhone.clear(); 
		txtPhone.sendKeys(Phone);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailPhone  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter a valid phone number with the format as +XXXXXXXXXXXXX."));

	}
	
	@Test(priority = 19 ,enabled = false)
	public void EditExtPhone() 
	{			
		String Ext=("1");

		WebElement txtExt= driver.findElement(By.id("txtExt"));
		txtExt.clear(); 
		txtExt.sendKeys(Ext);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailExt  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter a valid Ext number with the format as XXXXXX."));

	}
	
	
	@Test(priority = 20 ,enabled = false)
	public void EditFailMobile() 
	{			
		String Mobile=("+99");

		WebElement txtMobile= driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); 
		txtMobile.sendKeys(Mobile);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailPhone  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter a valid mobile number with the format as XXXXXXXXXXXXX."));
	}
	

	@Test(priority =21 ,enabled = false)

	public void EditFailsEmailBlank()
	{					

		String email=("");

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("EditFailsEmailBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter email."));
	}


	
	

	@Test(priority =22 ,enabled = false)

	public void EditFailsEmailNotUnique()
	{					

		String email=("doaa.rf@gmail.com");

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);
		

		Alert alert =driver.switchTo().alert();
		alert.accept();

		
		WebElement msgEmailValid =driver.findElement(By.cssSelector("span.text-success.ng-star-inserted"));
		System.out.println("msgEmailValid  "+msgEmailValid.getText());
		Assert.assertTrue(msgEmailValid.getText().contains("That email is valid."));
		
		

		WebElement btnSubmit = driver.findElement(By.id("btnSumbit"));
		btnSubmit.sendKeys(Keys.ENTER);
		
		WebElement Toaster =driver.findElement(By.id("toast-container"));
		System.out.println("EditFailsEmailNotUnique  "+Toaster.getText());
		Assert.assertTrue(Toaster.getText().contains("Operation error"));
		Assert.assertTrue(Toaster.getText().contains("Email already taken, Try another."));
		
		
		//swal2-content   // button.swal2-confirm.swal2-styled  OK//button.swal2-cancel.swal2-styled   Cancel

	}
	
	
	@Test(priority =22 ,enabled = false)

	public void EditFailsEmailcancel()
	{					

		String OldEmail ;
		String NewEmail=("doaa.rf@gmail.com");
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		OldEmail=txtEmail.getText();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		txtEmail.clear();
		txtEmail.sendKeys(NewEmail);
		

		Alert alert =driver.switchTo().alert();
		alert.dismiss();
		System.out.println("EditFailsEmailcancel  "+txtEmail.getText());
		Assert.assertTrue(txtEmail.getText().contains(OldEmail));


	}
	


	@AfterTest
	public void Closedriver()
	{
		driver.quit();
	}


}
