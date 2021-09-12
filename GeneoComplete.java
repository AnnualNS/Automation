package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GeneoComplete extends LaunchBrowser {

	
	@Test(priority=1)
	public void NoCredLogin() {
		
		//Login with blank fields
		
		StartBrowser("Chrome");
		driver.manage().window().maximize();
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		        
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		WebElement error = driver.findElement(By.xpath("//p[contains(text(),'Please enter Username and Password.')]"));
		if(error.isDisplayed()) {
			System.out.println("Login with empty fields. Error popup is displayed.");
		}
		
		driver.findElement(By.xpath("(//button[contains(@class,'profile_btn')])[1]")).click();
	}
	
	@Test(priority=2)
	public void IncorrectLogin() {

		//Login with incorrect email and password
						
			driver.findElement(By.id("login_input_Uname")).sendKeys("saikrishna0225@gmail.com");
			driver.findElement(By.id("login_input_Pwd")).sendKeys("99850");
			driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
			
			for (String winhandle: driver.getWindowHandles()) {
			    driver.switchTo().window(winhandle);
			        
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			WebElement warning = driver.findElement(By.xpath("//p[contains(text(),'Please enter valid Username and OTP/Password.')]"));
			if(warning.isDisplayed()) {
				System.out.println("Login with incorrect Email and password tested. Warning popup is displayed.");
			}
			
			driver.findElement(By.xpath("(//button[contains(@class,'profile_btn')])[1]")).click();
	}
	
	@Test(priority=3)
	public void CorrectLogin() {
	
		//Login with correct email and password
		
		driver.findElement(By.id("login_input_Uname")).clear();
		driver.findElement(By.id("login_input_Uname")).sendKeys("saikrishna0225@gmail.com");
		driver.findElement(By.id("login_input_Pwd")).clear();
		driver.findElement(By.id("login_input_Pwd")).sendKeys("9985041616");
		driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("GENEO: Product"));
			System.out.println("Login with Email and password successfully.");
		
	}
	
	@Test(priority=4)
	public void PhoneLogin() {
		
		//Login using phone number and password
		
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		driver.findElement(By.id("login_input_Uname")).sendKeys("9886768158");
		driver.findElement(By.id("login_input_Pwd")).sendKeys("123456");
		driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("GENEO: Product"));
			System.out.println("Login with Phone number and password successfully.");
			
	}
	
	@Test(priority=5)
	public void LoginWithGoogle() {
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gmailbutton']")).click();
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("annual.mahato@nextsteps.ai");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='password']//input")).sendKeys("a8883dde008abc");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Geneo Live"));
		System.out.println("Login with Google successfully.");
	}
	
	@Test(priority=6)
	public void ForgetPassword() {
		
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='forgotpwd']")).click();
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Forgot Your Password?"));
		System.out.println("Redirected to the forgot password page successfully.");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[contains(@class,'loginRedirection')])[1]")).click();
		
		
		if (title.equalsIgnoreCase("Geneo Login"));
		System.out.println("Back to login page from forget your password redirected successfully.");
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='forgotpwd']")).click(); 
		
		if (title.equalsIgnoreCase("Forgot Your Password?"));
		
		driver.findElement(By.xpath("//input[@id='btnSend']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		           
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		WebElement forgetpasswordwarningmsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter verified phone number or email-ID')]"));				
		if(forgetpasswordwarningmsg.isDisplayed())
		driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
		
		System.out.println("when student enters no details and clicks on Send, warning popup is displayed tested.");
		
		//with incorrect email		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txt_UserName']")).sendKeys("annual@annual.com");
		driver.findElement(By.xpath("//input[@id='btnSend']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		           
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		WebElement incorrectemailerror = driver.findElement(By.xpath("//p[contains(text(),'Email ID entered is incorrect. Please try again with your registered email ID.')]"));				
		if(incorrectemailerror.isDisplayed()) {			
		System.out.println("when student enters incorrect email, error popup displays tested.");
		}
		
		driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
		
		//with incorrect phone number		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txt_UserName']")).sendKeys("00000");
		driver.findElement(By.xpath("//input[@id='btnSend']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		           
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		WebElement incorrectphoneerror = driver.findElement(By.xpath("//p[contains(text(),'Mobile number is not recognised. Please enter your registered number')]"));				
		if(incorrectphoneerror.isDisplayed()) {					
		System.out.println("when student enters incorrect phone, error popup displays tested.");
		}
		driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
		
		//With verified email 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txt_UserName']")).sendKeys("annual.mahato@nextsteps.ai");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='btnSend']")).click();
		
		System.out.println("Please check your email, you will find the reset password link.");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//I didn't receive the email
		driver.findElement(By.xpath("//a[@class='lgbtn3']")).click();	
		
		System.out.println("Please check your email, you will find more than one reset password mails.");
		System.out.println("I didnt receive the email tested.");
		
		//Click here to login
		driver.findElement(By.xpath("(//a[contains(@class,'loginRedirection')])[2]")).click();
		if (title.equalsIgnoreCase("Geneo Login"));
		System.out.println("Back to login page from forget your password redirected successfully.");
		System.out.println("Forget Password with verified email tested.");
		
		//With verified phone number
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='forgotpwd']")).click();
		
		if (title.equalsIgnoreCase("Forgot Your Password?"));
		
		driver.findElement(By.xpath("//input[@id='txt_UserName']")).sendKeys("9959807741");
		driver.findElement(By.xpath("//input[@id='btnSend']")).click();
		
		WebElement ResetPasswordPage = driver.findElement(By.xpath("//div[@class='resend_OTP']"));
		if(ResetPasswordPage.isDisplayed())
			
		System.out.println("Please check your phone number for the OTP and reset your password manually.");
		
		//Resend OTP
		driver.findElement(By.xpath("//a[@id='requeOtp']")).click();
		System.out.println("Please check your phone, you will find more than one OTP via SMS.");
		
		//Click here to login
		driver.findElement(By.xpath("(//a[contains(@class,'loginRedirection')])[last()]")).click();
		if (title.equalsIgnoreCase("Geneo Login"));
		System.out.println("Back to login page from forget your password redirected successfully.");
		System.out.println("Forget Password with verified phone tested");
	}
	
	@Test(priority=7)
	public void ResumePreviousSession() {
		
		//Resume previous session flow
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='login_input_Uname']")).sendKeys("saikrishna0225@gmail.com");
		driver.findElement(By.xpath("//input[@id='login_input_Pwd']")).sendKeys("9985041616");
		driver.findElement(By.xpath("//input[contains(@class,'btn_stud_login')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@class,'btn_new_session')]")));
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("GENEO: Product"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement StartNewSession = driver.findElement(By.xpath("//a[contains(@class,'btn_new_session')]"));
		WebElement ResumePreviousSession = driver.findElement(By.xpath("//button[contains(@class,'btn_resume_session')]"));
		
		if(StartNewSession.isDisplayed() && ResumePreviousSession.isDisplayed());
		System.out.println("The user has landed on resume previous session successfully.");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement Hamburger, GeneoLive, Support;
		Hamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
		GeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		Support = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
		
		if(Hamburger.isDisplayed() && GeneoLive.isDisplayed() && Support.isDisplayed()) {
		System.out.println("All elements of Resume previous sessions are displayed on landing page.");
		}
		else {
			System.out.println("Error: Resume previous sessions all elements not displayed on landing page.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ResumePreviousSession.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement ResumeFlow = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
		if(ResumeFlow.isDisplayed()) {				
		System.out.println("Resume previous session button flow tested successfully.");
		}
		else {
			System.out.println("Error: Resume previous session button flow test failed.");
		}
		
	}
	
	@Test(priority=8)
	public void StartNewSession() {
		
		//Start New Session
		
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'btn_new_session')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
				
		
		//Class selection page
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='classSpecific']")));
		driver.findElement(By.xpath("//a[@id='classSpecific']")).click();
		
		
		WebElement Classes, CHamburger, CGeneoLive, CSupport;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='classtemplate']")));
		Classes = driver.findElement(By.xpath("//div[@id='classtemplate']"));
		CHamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
		CGeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		CSupport = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
		
		if(Classes.isDisplayed() && CHamburger.isDisplayed() && CGeneoLive.isDisplayed() && CSupport.isDisplayed()) {
			System.out.println("Start New session - class selection all elements displayed.");
		}
		else {
			System.out.println("Error: Start New session - class selection all elements not displayed.");
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'classX')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Subject selection page
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'seleSubj')]")));
		
		WebElement Subjects, Hamburger1, GeneoLive1, Support1, CareerPath, RememberMe;
		Subjects = driver.findElement(By.xpath("//div[contains(@class,'seleSubj')]"));
		Hamburger1 = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
		GeneoLive1 = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		Support1 = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));				
		CareerPath = driver.findElement(By.xpath("//a[@class='btnCareerPath']"));
		RememberMe = driver.findElement(By.id("remember_land"));
		
		if(Subjects.isDisplayed() && Hamburger1.isDisplayed() && GeneoLive1.isDisplayed() && Support1.isDisplayed() && CareerPath.isDisplayed() && RememberMe.isDisplayed()) {
			System.out.println("Start New session - Subject selection all elements displayed.");
		}
		else {
			System.out.println("Error: Start New session - Subject selection all elements not displayed..");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='liScience']//span")).click();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RememberMe.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step2']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
				
		//Chapter index page	
		
		WebElement Chapters = driver.findElement(By.xpath("//ul[contains(@class,'chapterlist')]"));
		
		WebElement Hamburger2, GeneoLive2, Support2;
		Hamburger2 = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
		GeneoLive2 = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		Support2 = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
		
		if(Hamburger2.isDisplayed() && GeneoLive2.isDisplayed() && Support2.isDisplayed() && Chapters.isDisplayed()) {
			System.out.println("Start New session - Chapter index all elements displayed.");
		}
		else {
			System.out.println("Error: Start New session - Chapter index all elements not displayed.");
		}
		
		//Hamburger Menu
		
		driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img")).click();
		
		WebElement EditProfile, MySubscription, ReferandEarn, Supp, SignOut;
		EditProfile = driver.findElement(By.xpath("//a[@id='aStudentProfile']"));
		MySubscription = driver.findElement(By.xpath("//a[@id='aStudentAccount']"));
		ReferandEarn = driver.findElement(By.xpath("//a[contains(@class,'ReferPage')]"));
		Supp = driver.findElement(By.xpath("//li[@id='lisupport']"));
		SignOut = driver.findElement(By.xpath("//a[@data-trn-key='Sign Out']"));
		
		if(EditProfile.isDisplayed() && MySubscription.isDisplayed() && ReferandEarn.isDisplayed() && Supp.isDisplayed() && SignOut.isDisplayed())
			System.out.println("All elements on Hamburger menu are displayed successfully.");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(@class,'is-close')]")).click();
	
		//The complete flow check till chat screen
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@class='pb-4'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement FlowEnd = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
		
		if(FlowEnd.isDisplayed()) {
			System.out.println("Landing Page - Start New Session Complete flow tested.");
		}
		else {
			System.out.println("Error: Landing Page - Start New Session test failed.");
		}
		
	}

	@Test(priority=9)
	public void FirstTimeLogin() {
		
	//first time login when settings are not saved
	
	driver.get("https://test1.geneo.in/geneo_live/student_landing.aspx");
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='classtemplate']")));
		
	WebElement Class, Hamburger, GeneoLive, Support;
	
	Class = driver.findElement(By.xpath("//div[@id='classtemplate']"));
	Hamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
	GeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
	Support = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
	
	if(Class.isDisplayed() && Hamburger.isDisplayed() && GeneoLive.isDisplayed() && Support.isDisplayed()) {
	System.out.println("Student landed on class selection page. Student login for the first time flow tested.");
	}
	else {
		System.out.println("Error: Student login for the first time flow test failed.");
	}
	
	//reset the settings
	
	driver.findElement(By.xpath("//a[contains(@class,'classX')]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='step1']")));
	driver.findElement(By.xpath("//a[@id='step1']")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='liScience']//span")));
	driver.findElement(By.xpath("//a[@id='liScience']//span")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='remember_land']")));
	driver.findElement(By.xpath("//input[@id='remember_land']")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='step2']")));
	driver.findElement(By.xpath("//a[@id='step2']")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='pb-4'])[1]")));
	driver.findElement(By.xpath("(//li[@class='pb-4'])[1]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test(priority=10)
	public void ChatScreen() {
		
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button/img)[1]")));
		WebElement Hamburger = driver.findElement(By.xpath("(//button/img)[1]"));
		if(Hamburger.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger menu is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger menu unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'redirect_landing')]//img)[1]")));
		WebElement GeneoLogo = driver.findElement(By.xpath("(//a[contains(@class,'redirect_landing')]//img)[1]"));
		if(GeneoLogo.isDisplayed()) {
			System.out.println("Student Chat Screen - Geneo logo is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Geneo logo unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='query_text_input_1']")));
		WebElement Search = driver.findElement(By.xpath("//input[@id='query_text_input_1']"));
		if(Search.isDisplayed()) {
			System.out.println("Student Chat Screen - Search is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Search unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='exploreMore']")));
		WebElement ExploreMore = driver.findElement(By.xpath("//button[@id='exploreMore']"));
		if(ExploreMore.isDisplayed()) {
			System.out.println("Student Chat Screen - Explore More is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Explore More unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='aStudentLiveClass']")));
		WebElement GeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		if(GeneoLive.isDisplayed()) {
			System.out.println("Student Chat Screen - Geneo Live is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Geneo Live unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'userSelStandard')]")));
		WebElement ClassSelected = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
		if(ClassSelected.isDisplayed()) {
			System.out.println("Student Chat Screen - Class Selected is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Class Selected unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='selectd-subject']")));
		WebElement Subject = driver.findElement(By.xpath("//span[@id='selectd-subject']"));
		if(Subject.isDisplayed()) {
			System.out.println("Student Chat Screen - Subject is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Subject unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='selectd-subject']")));
		WebElement Chapter = driver.findElement(By.xpath("//h1[@id='chapter_title']"));
		if(Chapter.isDisplayed()) {
			System.out.println("Student Chat Screen - Chapter is available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Chapter unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Bookmarkid']")));
		WebElement Bookmarks = driver.findElement(By.xpath("//span[@id='Bookmarkid']"));
		if(Bookmarks.isDisplayed()) {
			System.out.println("Student Chat Screen - Bookmarks available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Bookmarks unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Highlightid']")));
		WebElement Highlight = driver.findElement(By.xpath("//span[@id='Highlightid']"));
		if(Highlight.isDisplayed()) {
			System.out.println("Student Chat Screen - Highlight available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Highlight unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Underlineid']")));
		WebElement Underline = driver.findElement(By.xpath("//span[@id='Underlineid']"));
		if(Underline.isDisplayed()) {
			System.out.println("Student Chat Screen - Underline available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Underline unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Noteid']")));
		WebElement Note = driver.findElement(By.xpath("//span[@id='Noteid']"));
		if(Note.isDisplayed()) {
			System.out.println("Student Chat Screen - Note available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Note unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Eraserid']")));
		WebElement Eraser = driver.findElement(By.xpath("//span[@id='Eraserid']"));
		if(Eraser.isDisplayed()) {
			System.out.println("Student Chat Screen - Eraser available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Eraser unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='addfeedbackButtoonId']")));
		WebElement ReportanError = driver.findElement(By.xpath("//a[@id='addfeedbackButtoonId']"));
		if(ReportanError.isDisplayed()) {
			System.out.println("Student Chat Screen - Report an error available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Report an error unavailable.");
		}
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mCSB_7_container_wrapper']")));
		WebElement PDF = driver.findElement(By.xpath("//div[@id='mCSB_7_container_wrapper']"));
		if(PDF.isDisplayed()) {
			System.out.println("Student Chat Screen - PDF available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - PDF unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='pagetooltipid']")));
		WebElement Pager = driver.findElement(By.xpath("//div[@id='pagetooltipid']"));
		if(Pager.isDisplayed()) {
			System.out.println("Student Chat Screen - Pager available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Pager unavailable.");
		}
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btnBluePrevi trn']")));
		WebElement PreviousButton = driver.findElement(By.xpath("//a[@class='btnBluePrevi trn']"));
		if(PreviousButton.isDisplayed()) {
			System.out.println("Student Chat Screen - Previous Button available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Previous Button unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=' btnBlueNext trn']")));
		WebElement NextButton = driver.findElement(By.xpath("//a[@class=' btnBlueNext trn']"));
		if(NextButton.isDisplayed()) {
			System.out.println("Student Chat Screen - Next Button available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Next Button unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='laraSessionToolTip']")));
		WebElement LARA = driver.findElement(By.xpath("//div[@id='laraSessionToolTip']"));
		if(LARA.isDisplayed()) {
			System.out.println("Student Chat Screen - LARA available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - LARA unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='progressside']")));
		WebElement Progress = driver.findElement(By.xpath("//a[@id='progressside']"));
		if(Progress.isDisplayed()) {
			System.out.println("Student Chat Screen - Progress available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Progress unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='askquest']")));
		WebElement AskaQuestion = driver.findElement(By.xpath("//a[@id='askquest']"));
		if(AskaQuestion.isDisplayed()) {
			System.out.println("Student Chat Screen - Ask a question available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Ask a question unavailable.");
		}
		
	}
	
	@Test(priority=11)
	public void chatscreen2() {

		driver.navigate().refresh();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("(//button//img)[1]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'redirect_editProfile')]")));
		WebElement EditProfile = driver.findElement(By.xpath("//a[contains(@class,'redirect_editProfile')]"));
		if(EditProfile.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Edit Profile available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Edit Profile unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='aStudentAccount']")));
		WebElement MySubscription = driver.findElement(By.xpath("//a[@id='aStudentAccount']"));
		if(MySubscription.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - My Subscription available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - My Subscription unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='takeTour']")));
		WebElement TakeaTour = driver.findElement(By.xpath("//li[@class='takeTour']"));
		if(TakeaTour.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Take a tour available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Take a tour unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='referEarn']")));
		WebElement ReferandEarn = driver.findElement(By.xpath("//li[@class='referEarn']"));
		if(ReferandEarn.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Refer and Earn available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Refer and Earn unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='lisupport']")));
		WebElement Support = driver.findElement(By.xpath("//li[@id='lisupport']"));
		if(Support.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Support available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Support unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'is-close')])[2]")));
		WebElement Signout = driver.findElement(By.xpath("(//a[contains(@class,'is-close')])[2]"));
		if(Signout.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Sign out available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Sign out unavailable.");
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='careerPath']")));
		WebElement CareerPath = driver.findElement(By.xpath("//a[@class='careerPath']"));
		if(CareerPath.isDisplayed()) {
			System.out.println("Student Chat Screen - Hamburger Menu - Career Path available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Hamburger Menu - Career Path unavailable.");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@class,'is-close')])[1]")));
		driver.findElement(By.xpath("(//a[contains(@class,'is-close')])[1]")).click();
	}
	
	@Test(priority=12)
	public void chatscreen3() {
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@id='exploreMore']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='careerPath']")));
		if(driver.findElement(By.xpath("//a[@class='careerPath']")).isDisplayed()) {
			System.out.println("Student Chat Screen - Explore More - Career Path available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Explore More - Career Path unavailable.");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='questionPaper']")));
		if(driver.findElement(By.xpath("//li[@id='questionPaper']")).isDisplayed()) {
			System.out.println("Student Chat Screen - Explore More - Question Paper available.");
		}
		else {
			System.out.println("Error: Student Chat Screen - Explore More - Question Paper unavailable.");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='exploreMore']")));
		driver.findElement(By.xpath("//button[@id='exploreMore']")).click();
	}
	
	@Test(priority=13)
	public void TakeATour() {
	
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		WebElement Hamburger = driver.findElement(By.xpath("//div[@class='west-top']//button"));
		WebElement TAT = driver.findElement(By.xpath("//li[@class='takeTour']"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hamburger.click();
		wait.until(ExpectedConditions.elementToBeClickable(TAT));
		if(TAT.isDisplayed()) {
			TAT.click();
			System.out.println("Take a tour available on hamburger menu of student chat screen.");
			}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement SearchTooltip = driver.findElement(By.xpath("//div[contains(text(),'Use this search box to find topics and learning content')]"));
		
		if(SearchTooltip.isDisplayed()) {
			System.out.println("Take a tour is highlighting Search box.");
		}
		
		
		//Click next
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'introjs-nextbutton')]")));
		WebElement Next = driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]"));		
		Next.click();
				
		WebElement GeneoLiveTooltip = driver.findElement(By.xpath("//div[contains(text(),'Launch Geneo Live classes from here. You can access subject wise classes and register')]"));
		wait.until(ExpectedConditions.elementToBeClickable(GeneoLiveTooltip));
		if(GeneoLiveTooltip.isDisplayed()) {
			System.out.println("Next button on tour highlight is working.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click Previous
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'introjs-prevbutton')]")));
		WebElement Previous = driver.findElement(By.xpath("//a[contains(@class,'introjs-prevbutton')]"));		
		Previous.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchTooltip));
		if(SearchTooltip.isDisplayed()) {
			System.out.println("Previous button on tour highlight is working.");
		}
		
		//Click Skip
		WebElement Skip = driver.findElement(By.xpath("//a[contains(@class,'introjs-skipbutton')]"));
		wait.until(ExpectedConditions.elementToBeClickable(Skip));
		Skip.click();
		System.out.println("Skip button on tour highlight is working.");
		
		
		//Next button highlight sequence
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='west-top']//button")));
		driver.findElement(By.xpath("//div[@class='west-top']//button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='takeTour']")));
		driver.findElement(By.xpath("//li[@class='takeTour']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Use this search box to find topics and learning content')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Use this search box to find topics and learning content')]")).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'introjs-nextbutton')]")));
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Launch Geneo Live classes from here. You can access subject wise classes and register')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Switch between the subjects from here')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Switch between the chapters from here')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'This is your learning journey.')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'There are a variety of tools')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'We are here to help!')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'You can toggle between pages')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Access the menu')]")).isDisplayed();
		
		WebElement Done = driver.findElement(By.xpath("//a[contains(@class,'introjs-donebutton')]"));
		if(Done.isDisplayed()) {
			System.out.println("Next button sequence is working.");
		}
		Done.click();
		System.out.println("Done button closes the take a tour action.");
		
	}
	
	@Test(priority=14)
	public void PDF() {
		
		WebElement pdf = driver.findElement(By.xpath("//div[@id='reader']"));
		if(pdf.isDisplayed()) {
			System.out.println("Student can view the PDF");
		}
		
		else {
			System.out.println("Error: Student cannot view the PDF");
		}
	}
	
	
	@Test(priority=15)
	public void Pager() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Pagination = driver.findElement(By.xpath("//div[@id='pagetooltipid']"));
		WebElement Previous = driver.findElement(By.xpath("//span[contains(@class,'cls_previous')]//a"));
		WebElement Next = driver.findElement(By.xpath("//span[contains(@class,'cls_nextPag')]//a"));
		
		if(Pagination.isDisplayed()) {
			System.out.println("Pager displayed to the student.");
		}
		
		else {
			System.out.println("Error: Pager unavailable to the student.");
		}
		
		if(Previous.isDisplayed() && Next.isDisplayed()) {
			System.out.println("Previous and Next buttons are displayed to the student on pagination.");
		}
		
		else {
			System.out.println("Error: Previous and Next buttons are unavailable.");
		}
	}
	
	@Test(priority=16)
	public void GeneoLive() {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		WebElement Live = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Live.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Geneo Live")) {
			System.out.println("Landed on Geneo Live successfully.");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@id,'hiraku-offcanvas')]//img")));
			WebElement Hamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku-offcanvas')]//img"));
			if(Hamburger.isDisplayed()) {
				System.out.println("Geneo Live - Hamburger Menu displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Hamburger Menu not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'maxLog')]")));
			WebElement GeneoLogo = driver.findElement(By.xpath("//div[contains(@class,'maxLog')]"));
			if(GeneoLogo.isDisplayed()) {
				System.out.println("Geneo Live - Logo displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Logo not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'backbutton')]")));
			WebElement Back = driver.findElement(By.xpath("//div[contains(@class,'backbutton')]"));
			if(Back.isDisplayed()) {
				System.out.println("Geneo Live - Back button displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Back button not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btnPDF']//label")));
			WebElement Instructions = driver.findElement(By.xpath("//a[@id='btnPDF']//label"));
			if(Instructions.isDisplayed()) {
				System.out.println("Geneo Live - Instructions displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Instructions not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tblLiveClass_length']//select")));
			WebElement Entries = driver.findElement(By.xpath("//div[@id='tblLiveClass_length']//select"));
			if(Entries.isDisplayed()) {
				System.out.println("Geneo Live - Entries per page displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Entries per page not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tblLiveClass_filter']//input")));
			WebElement Search = driver.findElement(By.xpath("//div[@id='tblLiveClass_filter']//input"));
			if(Search.isDisplayed()) {
				System.out.println("Geneo Live - Search displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Search not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'clickMenu')]")));
			WebElement Report = driver.findElement(By.xpath("//a[contains(@class,'clickMenu')]"));
			if(Report.isDisplayed()) {
				System.out.println("Geneo Live - Report an error displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Report an error not displayed.");
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='tblLiveClass']")));
			WebElement Classes = driver.findElement(By.xpath("//table[@id='tblLiveClass']"));
			if(Classes.isDisplayed()) {
				System.out.println("Geneo Live - Classes displayed.");
			}
			else {
				System.out.println("Error: Geneo Live - Classes not displayed.");
			}
		}
		else {
			System.out.println("Error: Didnot land on Geneo Live.");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).click();
	}
	
	@Test(priority=17)
	public void SubjectSelection() {
				
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Subject = driver.findElement(By.xpath("//a[@id='changeSubjectToolTipId']"));
		Actions action = new Actions(driver);
		action.moveToElement(Subject).perform();
		action.pause(5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu2']")));
		
		if(driver.findElement(By.xpath("//ul[@class='dropdown-menu2']")).isDisplayed()) {
			System.out.println("Student can see the subject dropdown list on mouse hover.");
			
			driver.findElement(By.xpath("//label[contains(text(),'Geography')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='selectd-subject']")));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String subjectname = "Geography";
			if(driver.findElement(By.xpath("//span[@id='selectd-subject']")).getText() == subjectname) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Selected subject from dropdown is displayed.");
			}
			else {
			System.out.println("Error: Selected subject from dropdown list is not displayed.");
			}
		}
		
		else {
			System.out.println("Error: Student cannot see the subject dropdown list on mouse hover.");
		}
		
		
	}
	
	@Test(priority=18)
	public void ChapterSelection() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
	
		WebElement Chapter = driver.findElement(By.xpath("//a[@id='chapterListToolTipId']"));
		Actions action = new Actions(driver);
		action.moveToElement(Chapter).perform();
		action.pause(5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ChapterList']")));
		
		if(driver.findElement(By.xpath("//ul[@id='ChapterList']")).isDisplayed()) {
			System.out.println("Student can see the chapter dropdown list on mouse hover.");
			
			Select chapter = new Select(driver.findElement(By.xpath("//ul[@id='ChapterList']")));
			chapter.selectByIndex(3);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='chapter_title']//h1[contains(text(),'3')]")));
			if(driver.findElement(By.xpath("//h1[@id='chapter_title']//h1[contains(text(),'3')]")).isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Selected chapter from dropdown is displayed.");
			}
			else {
				System.out.println("Error: Selected chapter from dropdown is not displayed.");
			}
		}
		else {
			System.out.println("Error: Student cannot see the chapter dropdown list on mouse hover.");
		}
		
		
	}
		
	@Test(priority=19)
	public void ReferandEarn() {
		
		WebElement ChatScreen = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
		WebElement Hamburger = driver.findElement(By.xpath("//div[@class='west-top']//button[contains(@class,'button')]"));
		WebElement RAE = driver.findElement(By.xpath("//li[@id='referFriendhide']"));
		
		if(ChatScreen.isDisplayed()) {
			
			Hamburger.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(RAE.isDisplayed()) {
				System.out.print("Refer and earn is displayed to the student on hamburger menu.");					
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				RAE.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				if(driver.findElement(By.xpath("//h1[contains(text(),'Refer a Friend')]")).isDisplayed()) {
					System.out.println("Student got redirected to the refer and earn page successfully.");
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//button[contains(@class,'gotIt')]")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(driver.findElement(By.xpath("//button[contains(@class,'gotItShow')]")).isDisplayed()) {
						System.out.println("When student clicks on Got it button, the message gets hidden.");
					}
					else {
						System.out.println("Error: Got it button click is not working.");
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//button[contains(@class,'gotItShow')]")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(driver.findElement(By.xpath("//button[contains(@class,'gotIt')]")).isDisplayed()) {
						System.out.println("When student clicks on Show button, the message is displayed.");
					}
					else {
						System.out.println("Error: Show button click is not working.");
					}
					
					
					
					driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
					driver.findElement(By.xpath("//button[contains(@class,'gotItShow')]")).click();
					driver.switchTo().alert().accept();
					if(driver.switchTo().alert().getText() == "Mobile number can't be less then 10 digits.") {
						System.out.println("When student clicks on Submit without entering details, error popup is displayed.");
						driver.switchTo().alert().accept();
						driver.findElement(By.xpath("//button[contains(@class,'gotItShow')]")).click();
					}
					else {
						System.out.println("Error: popup not displayed.");
					}
					
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					WebElement Name = driver.findElement(By.xpath("//input[@id='Name1']"));
					WebElement Email = driver.findElement(By.xpath("//input[@id='Email1']"));
					WebElement Phone = driver.findElement(By.xpath("//input[@id='Mobile1']"));
					
					Name.sendKeys("Automation");
					Email.sendKeys("auto.mation@testing.com");
					Phone.sendKeys("1231231231");
					driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
					driver.switchTo().alert().accept();
					
					for (String winhandle: driver.getWindowHandles()) {
					    driver.switchTo().window(winhandle);
					           
					    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}
					WebElement confirm = driver.findElement(By.xpath("//p[contains(text(),'You have successfully referred your friend(s).')]"));
					if(confirm.isDisplayed()) {
						driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
						System.out.print("Student referred to a user successfully.");
						System.out.print("Please check your email for referral sent to user confirmation mail.");
						System.out.print("Please check your phone, you might have received a confirmation sms.");
						System.out.print("Please ask friend to check email and phone for the referral mail and referral sms.");
					}
					else {
						System.out.print("Error: Refer unsuccessful.");
					}
					
					//------						
				}
				
				else {
					System.out.println("Student didnt get redirected to refer and earn page.");
				}
			}
			else {
				System.out.print("Error: Refer and earn unavailable.");
			}
		}
		
	}
	
	@Test(priority=20)
	public void QuestionPaper() {
		
		WebElement ExploreMore = driver.findElement(By.xpath("//button[@id='exploreMore']"));
		if(ExploreMore.isDisplayed()) {
			System.out.println("Explore More is available.");
			
			ExploreMore.click();
			
			WebElement QuestionPapers = driver.findElement(By.xpath("//li[@id='questionPaper']"));
			if(QuestionPapers.isDisplayed()) {
				System.out.println("Question Paper is available in Explore More.");
				
				QuestionPapers.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					
					System.out.println("The user is redirected to question paper page.");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//Hamburger menu
					driver.findElement(By.xpath("//button[contains(@id,'hiraku')]")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					WebElement EditProfile, MySubscription, ReferaFriend, Support, Logout;
					EditProfile = driver.findElement(By.xpath("//a[@id='aStudentProfile']"));
					MySubscription = driver.findElement(By.xpath("//a[@id='aStudentAccount']"));
					ReferaFriend = driver.findElement(By.xpath("//li[@id='hidereferFriend']"));
					Support = driver.findElement(By.xpath("//a[contains(@class,'redirect_help')]"));
					Logout = driver.findElement(By.xpath("//a[@data-value='Logout']"));
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(EditProfile.isDisplayed() && MySubscription.isDisplayed() && ReferaFriend.isDisplayed() && Support.isDisplayed() && Logout.isDisplayed()) {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						System.out.println("All elements of hamburger menu are displayed.");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.xpath("//a[contains(@class,'is-close')]")).click();
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
						if(driver.findElement(By.xpath("//div[@class='d-i-block']//p[contains(text(),'No question paper selected')]")).isDisplayed()) {
							System.out.println("when no selection made no question paper selected is displayed.");
							
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							WebElement QuestionPaper, Subject, Year;
							
							QuestionPaper = driver.findElement(By.xpath("//select[@id='qb_type']"));
							Subject = driver.findElement(By.xpath("//select[@id='qb_subject']"));
							Year = driver.findElement(By.xpath("//select[@id='qb_year']"));
							
							QuestionPaper.click();
							driver.findElement(By.xpath("(//option[@class='trn'])[2]")).click();
							Subject.click();
							driver.findElement(By.xpath("//select[@id='qb_subject']//option[@value='Mathematics']")).click();
							Year.click();
							driver.findElement(By.xpath("//select[@id='qb_year']//option[1]")).click();
							driver.findElement(By.xpath("(//li[@class='bindpaper'])[1]")).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							if(driver.findElement(By.xpath("//div[@id='pdf_questionPaper']")).isDisplayed()) {
								System.out.println("Question paper is displayed to the user.");
								
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
								if(driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).isDisplayed()) {
									System.out.println("Close button available.");
									
									driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).click();
									//Back to chatscreen.
								}
								else {
									System.out.println("Error: Close button unavailable.");
								}
							}
							else {
								System.out.println("Error: Question paper unavailable.");
							}
							
						}
						else {
							System.out.println("Error: no question paper selected message not displayed.");
						}
						
					}
					else {
						System.out.println("Error: All elements of hamburger menu are not displayed.");
					}
					
				}
				else {
					System.out.println("Error: Question Paper is unavailable in Explore More.");
				}
			}
			
			else {
				System.out.println("Error: Explore More unavailable on chat screen.");
			}
	}
	
	
@Test(priority=21)
	
	public void Search() {
		WebElement Search = driver.findElement(By.xpath("//input[@id='query_text_input_1']"));
		if(Search.isDisplayed());
			
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("electric");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement Suggestions = driver.findElement(By.xpath("//ul[@id='suggestionsResultsList1']"));
		if(Suggestions.isDisplayed()) {
			System.out.println("Search suggestions displayed to the student.");
		}
		else {
			System.out.println("Error: Search suggestions not displayed to the student.");
		}
		
		driver.findElement(By.xpath("(//a[@class='searchResults'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement Results = driver.findElement(By.xpath("//h3[@id='SearchResultText']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(Results.isDisplayed()) {
			System.out.println("Search results are displayed from suggestions.");
		}
		else {
			System.out.println("Error: Search results from suggestions not displayed.");
		}
		
		
		driver.findElement(By.xpath("(//a[contains(@class,'downTimer')])[last()]")).click();
		
		
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("magnetic");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(Results.isDisplayed())
			System.out.println("Search results are displayed using magnifying glass.");
		
		driver.findElement(By.xpath("(//a[contains(@class,'downTimer')])[last()]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("jsjsjsjsjsjs");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement NoResults = driver.findElement(By.xpath("//h3[contains(text(),'Sorry')]"));
		if(NoResults.isDisplayed())
			System.out.println("Sorry displayed when no search results.");
		
		driver.findElement(By.xpath("(//a[contains(@class,'downTimer')])[last()]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).clear();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("chemical");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement PDF, VideoSearch;
		PDF = driver.findElement(By.xpath("//div[@id='content_search_data']//div[contains(@class,'searchLink')]//a"));
		VideoSearch = driver.findElement(By.xpath("//div[contains(@class,'vedioSection')]"));
		
		if(PDF.isDisplayed() && VideoSearch.isDisplayed())
			System.out.println("PDF and Videos displayed as search result.");
		
		//open PDF content-
		driver.findElement(By.xpath("(//div[@id='content_search_data']//div[contains(@class,'searchLink')]//a)[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("chemical");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open video content-
		driver.findElement(By.xpath("(//div[contains(@class,'vedioSection')]//img)[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		        
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Video = driver.findElement(By.xpath("//div[@id='vid']"));
		if(Video.isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='vjs-big-play-button']")).click();
		System.out.println("Student can open both PDF and video from search result.");
		}
		driver.findElement(By.xpath("//button[@class='close_video trn']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
					
				
		
		WebElement Subject = driver.findElement(By.xpath("//span[@id='selectd-subject']//text()"));
					
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("chemical");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement SubjectDropdown = driver.findElement(By.xpath("//div[contains(@class,'anChanSubj')]//select[text()]"));
		if(SubjectDropdown.equals(Subject))
			System.out.println("The subject on search page is the selected subject on the Student chat screen.");
		
		
					
					
		WebElement Close = driver.findElement(By.xpath("//div[contains(@class,'anChanLeft')]//a[contains(@class,'downTimer')]"));
		if(Close.isDisplayed())
			driver.findElement(By.xpath("//div[contains(@class,'anChanLeft')]//a[contains(@class,'downTimer')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement chatscreen = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
		if(chatscreen.isDisplayed())
			System.out.println("The Close button on the search page redirected the student back to the chat screen.");
		
	
			
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("chemical");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement GeneoHome = driver.findElement(By.xpath("(//a[contains(@class,'redirect_landing')])[last()]"));
		if(GeneoHome.isDisplayed())
			driver.findElement(By.xpath("(//a[contains(@class,'redirect_landing')])[last()]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("GENEO: Product"))
			System.out.println("Student gets redirected to landing page when they click on Geneo from search.");		
			
		//reset
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step2']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@class='pb-4'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
		driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("chemical");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='hidesearch']//span[@class='btn-search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			WebElement Reportanerror = driver.findElement(By.xpath("//a[@id='addfeedbackButtoonId']"));
		
				if(Reportanerror.isDisplayed())
			
					Reportanerror.click();
				
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				        
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				System.out.println("Report an error popup is displayed to the student.");
				
				driver.findElement(By.xpath("//button[contains(@class,'error-btn-outline-primary')]")).click();
				System.out.println("Close button closes the report an error popup.");
				
				Reportanerror.click();
				driver.findElement(By.xpath("//a[@id='submitErroReport']")).click();
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				           
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

				WebElement Sendwithouttext = driver.findElement(By.xpath("(//p[contains(text(),'Please enter your comments ')])[1]"));
				if(Sendwithouttext.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[4]")).click();
					System.out.println("when Student clicks on Send without entering details, warning popup displayed Please enter your comments.");
					
				}
			
				driver.findElement(By.xpath("//textarea[@id='errorComment']")).click();
				driver.findElement(By.xpath("//textarea[@id='errorComment']")).sendKeys("Error message");
				driver.findElement(By.xpath("//a[@id='submitErroReport']")).click();
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				           
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

				WebElement Sendwithtext = driver.findElement(By.xpath("//p[contains(text(),'Thank You! The issue has been reported successfully.')]"));
				if(Sendwithtext.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[4]")).click();
					System.out.println("When Student clicks on Send after entering details, confirmation popup displayed Thank You! The issue has been reported successfully.");
					
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Search functionality tested completely.");
				Close.click();
	}
	
	
	
	
	
	@Test(priority=100)
	public void quit() {
	driver.quit();
	}

}
