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

public class AddUser {
	ChromeDriver driver ;
	String URL=("https://rajhisteelweb.azurewebsites.net/#/login");
	String URL1=("https://rajhisteelweb.azurewebsites.net/#/user/create");

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
		txtUsername.sendKeys("admindoaa");

		WebElement txtpassword=driver.findElement(By.id("txtPassword")); 
		txtpassword.clear(); 
		txtpassword.sendKeys("Test_1234");
		txtpassword.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebElement btnLogout =driver.findElement(By.id("btnLogout"));
		System.out.println(btnLogout.getText());
		//Assert.assertEquals(btnLogout.getAriaRole(), "Ignored");
		assertTrue(driver.getTitle().startsWith("RajhiSteel/Home"));

	}


	
	@Test(priority = 21 ,enabled = true)

	public void AddUserSuccess() throws InterruptedException
	{			

		String UserName=("User104");
		String email=(UserName+"@test.com");


		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));



		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);


		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Doaa");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Nassar");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("AddAcountSuccess  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("User Account created successfully."));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

	


	}

	
	@Test(priority = 23 ,enabled = true)

	public void AddUserSuccessRequired() throws InterruptedException
	{			

		String UserName=("User105");
		String email=(UserName+"@test.com");


		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));



		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);


		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Mahmoud");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Nassar");




		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement Notification =driver.findElement(By.id("toast-container"));
		System.out.println("AddAcountSuccessReqquired  "+Notification.getText());
		Assert.assertTrue(Notification.getText().contains("Operation done successfully"));
		Assert.assertTrue(Notification.getText().contains("User Account created successfully."));

	}
	@Test(priority = 3 ,enabled = true)

	public void AddUserFailsWithoutUniqueUserName() throws InterruptedException
	{			

		String UserName=("admindoaa");
		String email=(UserName+"11@test.com");


		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));



		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);

		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);


		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Ahmed");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Nassar");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
		WebElement ErrorMessage =driver.findElement(By.cssSelector("span.text-danger.ng-star-inserted"));
		System.out.println("AddUserFailsWithoutUniqueUserName  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("That username is taken. Try another."));


	}

	@Test(priority =4 ,enabled = true)

	public void AddUserFailsWithoutUniqueEmail() throws InterruptedException
	{			

		String UserName=("User1150000000");
		String email=("doaa.rf@gmail.com");

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Doaa");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Nassar");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("span.text-danger.ng-star-inserted"));
		System.out.println("AddUserFailsWithoutUniqueEmail  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("That email is taken. Try another."));
	}
	
	@Test(priority =5 ,enabled = true)

	public void AddUserFailsFnameNotEnglish() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=(UserName+"@test.com");
		String FName= ("على");

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys(FName);


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Nassar");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsFnameNotEnglish  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Sorry, the name must by alphabetical character (a-z)."));
	}
	
	@Test(priority =6 ,enabled = true)

	public void AddUserFailsLastNotEnglish() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=(UserName+"@test.com");
		String LName= ("عامر محمد");

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Doaa");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys(LName);


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsLastNotEnglish  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Sorry, the name must by alphabetical character (a-z)."));
	}
	
	

	@Test(priority =7 ,enabled =true)

	public void AddUserFailsLastLnameBlank() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=(UserName+"@test.com");
		String LName= ("");

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Doaa");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys(LName);


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsLastLnameBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter last name."));
	}
	
	@Test(priority =8 ,enabled = true)

	public void AddUserFailsFnameBlank() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=(UserName+"@test.com");
		String FName= ("");

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys(FName);


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsFnameBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter first name."));
	}
	
	
	@Test(priority =9 ,enabled = true)

	public void AddUserFailsEmailBlank() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=("");
	

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsEmailBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter email."));
	}
	
	
	@Test(priority =10 ,enabled = true)

	public void AddUserFailsUserNameBlank() throws InterruptedException
	{					

		String UserName=("");
		String email=("Email@bbbb.com");
	

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsUserNameBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please enter username."));
	}
	
@Test(priority =11 ,enabled = true)

	public void AddUserFailsBranchBlank() throws InterruptedException
	{					

		String UserName=("User1150");
		String email=(UserName+"@test.com");
	

		driver.navigate().to(URL1); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
		txtUsername1.sendKeys(UserName);
		
		WebElement txtEmail=driver.findElement(By.id("txtEmail"));
		txtEmail.clear();
		txtEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

		WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
		txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


		WebElement txtLastName=driver.findElement(By.id("txtLastName"));
		txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


		WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
		txtPhone.sendKeys("+9661212121212");


		WebElement txtExtension=driver.findElement(By.id("txtExtension"));
		txtExtension.clear(); txtExtension.sendKeys("1234");

		WebElement txtMobile=driver.findElement(By.id("txtMobile"));
		txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


		WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
		//optionBranchlist.sendKeys("Head Quarter");
		optionBranchlist.sendKeys("");
		optionBranchlist.sendKeys(Keys.ENTER);


		WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionDepartmentlist.sendKeys("IT");
		optionDepartmentlist.sendKeys(Keys.ENTER);

		WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
		optionTitlelist.sendKeys("Web Portal Admin");
		optionTitlelist.sendKeys(Keys.ENTER);

		WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
		optionPositionlist.sendKeys("IT Manager");
		optionPositionlist.sendKeys(Keys.ENTER);


		optionPositionlist.sendKeys(Keys.TAB);
		WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
		btnSubmit.sendKeys(Keys.ENTER);

		WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
		System.out.println("AddUserFailsBranchBlank  "+ErrorMessage.getText());
		Assert.assertTrue(ErrorMessage.getText().contains("Please select branch."));
	}


@Test(priority =12 ,enabled = true)

public void AddUserFailsDepartmentBlank() throws InterruptedException
{					

	String UserName=("User1150");
	String email=(UserName+"@test.com");


	driver.navigate().to(URL1); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
	txtUsername1.sendKeys(UserName);
	
	WebElement txtEmail=driver.findElement(By.id("txtEmail"));
	txtEmail.clear();
	txtEmail.sendKeys(email);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

	WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
	txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


	WebElement txtLastName=driver.findElement(By.id("txtLastName"));
	txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


	WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
	txtPhone.sendKeys("+9661212121212");


	WebElement txtExtension=driver.findElement(By.id("txtExtension"));
	txtExtension.clear(); txtExtension.sendKeys("1234");

	WebElement txtMobile=driver.findElement(By.id("txtMobile"));
	txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


	WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
	optionBranchlist.sendKeys("Head Quarter");
	optionBranchlist.sendKeys(Keys.ENTER);


	WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
	//optionDepartmentlist.sendKeys("IT");
	optionDepartmentlist.sendKeys("");
	optionDepartmentlist.sendKeys(Keys.ENTER);

	WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
	optionTitlelist.sendKeys("Web Portal Admin");
	optionTitlelist.sendKeys(Keys.ENTER);

	WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
	optionPositionlist.sendKeys("IT Manager");
	optionPositionlist.sendKeys(Keys.ENTER);


	optionPositionlist.sendKeys(Keys.TAB);
	WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
	btnSubmit.sendKeys(Keys.ENTER);

	WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
	System.out.println("AddUserFailsDepartmentBlank  "+ErrorMessage.getText());
	Assert.assertTrue(ErrorMessage.getText().contains("Please select department."));
}
	


@Test(priority =13 ,enabled = true)

public void AddUserFailsTitleBlank() throws InterruptedException
{					

	String UserName=("User1150");
	String email=(UserName+"@test.com");


	driver.navigate().to(URL1); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
	txtUsername1.sendKeys(UserName);
	
	WebElement txtEmail=driver.findElement(By.id("txtEmail"));
	txtEmail.clear();
	txtEmail.sendKeys(email);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

	WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
	txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


	WebElement txtLastName=driver.findElement(By.id("txtLastName"));
	txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


	WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
	txtPhone.sendKeys("+9661212121212");


	WebElement txtExtension=driver.findElement(By.id("txtExtension"));
	txtExtension.clear(); txtExtension.sendKeys("1234");

	WebElement txtMobile=driver.findElement(By.id("txtMobile"));
	txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


	WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
	optionBranchlist.sendKeys("Head Quarter");
	optionBranchlist.sendKeys(Keys.ENTER);


	WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
	optionDepartmentlist.sendKeys("IT");
	optionDepartmentlist.sendKeys(Keys.ENTER);

	
	
	WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
	//optionTitlelist.sendKeys("Web Portal Admin");
	optionTitlelist.sendKeys("");
	optionTitlelist.sendKeys(Keys.ENTER);

	WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
	optionPositionlist.sendKeys("IT Manager");
	optionPositionlist.sendKeys(Keys.ENTER);


	optionPositionlist.sendKeys(Keys.TAB);
	WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
	btnSubmit.sendKeys(Keys.ENTER);

	WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
	System.out.println("AddUserFailsTitleBlank  "+ErrorMessage.getText());
	Assert.assertTrue(ErrorMessage.getText().contains("Please select job title."));
}

@Test(priority =14 ,enabled = true)

public void AddUserFailsPositionBlank() throws InterruptedException
{					

	String UserName=("User1150");
	String email=(UserName+"@test.com");


	driver.navigate().to(URL1); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

	WebElement txtUsername1= driver.findElement(By.id("txtUserName"));
	txtUsername1.sendKeys(UserName);
	
	WebElement txtEmail=driver.findElement(By.id("txtEmail"));
	txtEmail.clear();
	txtEmail.sendKeys(email);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));

	WebElement txtFirstName= driver.findElement(By.id("txtFirstName"));
	txtFirstName.clear(); txtFirstName.sendKeys("Mohamed");


	WebElement txtLastName=driver.findElement(By.id("txtLastName"));
	txtLastName.clear(); txtLastName.sendKeys("Mahmoud");


	WebElement txtPhone= driver.findElement(By.id("txtPhone")); txtPhone.clear();
	txtPhone.sendKeys("+9661212121212");


	WebElement txtExtension=driver.findElement(By.id("txtExtension"));
	txtExtension.clear(); txtExtension.sendKeys("1234");

	WebElement txtMobile=driver.findElement(By.id("txtMobile"));
	txtMobile.clear(); txtMobile.sendKeys("+9661212121212");


	WebElement optionBranchlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[1]/div/ng-select/div/div/div[2]/input"));
	optionBranchlist.sendKeys("Head Quarter");
	optionBranchlist.sendKeys(Keys.ENTER);


	WebElement optionDepartmentlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[4]/div[2]/div/ng-select/div/div/div[2]/input"));
	optionDepartmentlist.sendKeys("IT");
	optionDepartmentlist.sendKeys(Keys.ENTER);

	
	
	WebElement optionTitlelist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[1]/div/ng-select/div/div/div[2]/input"));
	optionTitlelist.sendKeys("Web Portal Admin");
	optionTitlelist.sendKeys(Keys.ENTER);

	WebElement optionPositionlist = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/div[2]/div/ng-select/div/div/div[2]/input"));
	//optionPositionlist.sendKeys("IT Manager");
	optionPositionlist.sendKeys("");
	optionPositionlist.sendKeys(Keys.ENTER);


	optionPositionlist.sendKeys(Keys.TAB);
	WebElement btnSubmit = driver.findElement(By.id("btnSubmit"));
	btnSubmit.sendKeys(Keys.ENTER);

	WebElement ErrorMessage =driver.findElement(By.cssSelector("div.text.text-danger.mt-2.ng-star-inserted"));
	System.out.println("AddUserFailsPositionBlank  "+ErrorMessage.getText());
	Assert.assertTrue(ErrorMessage.getText().contains("Please select position."));
}
@AfterTest
	public void Closedriver()
	{
		driver.quit();
	}


}
