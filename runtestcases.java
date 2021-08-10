package automation;

//import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RunTestCases extends LaunchBrowser {

				
		
		public static void Login() {

		//Login with email and password
			
			StartBrowser("Chrome");
			driver.manage().window().maximize();
			driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("login_input_Uname")).sendKeys("srini.adepu@nextsteps.ai");
			driver.findElement(By.id("login_input_Pwd")).sendKeys("Password@123");
			driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
			
			String title = driver.getTitle();
			if (title.equalsIgnoreCase("GENEO: Product"));
				System.out.println("Login with Email and password successfully.");
				
			
		//Login with phone number and password
			driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			
			driver.findElement(By.id("login_input_Uname")).sendKeys("9886768158");
			driver.findElement(By.id("login_input_Pwd")).sendKeys("123456");
			driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
			
			if (title.equalsIgnoreCase("GENEO: Product"));
				System.out.println("Login with Phone number and password successfully.");
				
		//When fields are empty
				driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
				
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				           
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

				WebElement errormsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter Username and Password.')]"));				
				if(errormsg.isDisplayed())
				driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
				
				System.out.println("When username and password fields are not filled, user cannot login and gets error popup tested.");
				
		//When incorrect user name/password		
				driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("login_input_Uname")).sendKeys("asasasa");
				driver.findElement(By.id("login_input_Pwd")).sendKeys("adfdsfdf");
				driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
				
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				           
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

				WebElement warningmsg = driver.findElement(By.xpath("//p[contains(text(),'Please enter valid Username and OTP/Password.')]"));				
				if(warningmsg.isDisplayed())
				driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
				
				System.out.println("When incorrect username/password is given, the user cannot login and gets warning popup tested.");
		
								
			//Login with google #6
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
				
				if (title.equalsIgnoreCase("Geneo Live"));
				System.out.println("Login with Google successfully.");
				
				
			//Forget Password using email
				
				driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@id='forgotpwd']")).click();
				
				if (title.equalsIgnoreCase("Forgot Your Password?"));
				System.out.println("Redirected to the forgot password page successfully.");
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("(//a[contains(@class,'loginRedirection')])[1]")).click();
				
				if (title.equalsIgnoreCase("Geneo Login"));
				System.out.println("Back to login page from forget your password redirected successfully.");
				
		//when no details entered.
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
				if(incorrectemailerror.isDisplayed())
				driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
				
				System.out.println("when student enters incorrect email, error popup displays tested.");
				
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
				if(incorrectphoneerror.isDisplayed())
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("(//button[contains(@class,'update-profile')])[1]")).click();
				
				System.out.println("when student enters incorrect phone, error popup displays tested.");
			
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
				
				driver.findElement(By.xpath("//input[@id='txt_UserName']")).sendKeys("9886768158");
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
		
		public static void LandingPage()	{
				
			//Resume previous session flow
			
				driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
				driver.findElement(By.id("login_input_Uname")).sendKeys("srini.adepu@nextsteps.ai");
				driver.findElement(By.id("login_input_Pwd")).sendKeys("Password@123");
				driver.findElement(By.xpath("//input[contains(@class,'btn_stud_login')]")).click();
				String title = driver.getTitle();
				if (title.equalsIgnoreCase("GENEO: Product"));
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				WebElement StartNewSession = driver.findElement(By.xpath("//a[contains(@class,'btn_new_session')]"));
				WebElement ResumePreviousSession = driver.findElement(By.xpath("//button[contains(@class,'btn_resume_session')]"));
				
				if(StartNewSession.isDisplayed() && ResumePreviousSession.isDisplayed());
				System.out.println("The user has landed on resume previous session successfully.");
				
				WebElement Hamburger, GeneoLive, Support;
				Hamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
				GeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
				Support = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
				
				if(Hamburger.isDisplayed() && GeneoLive.isDisplayed() && Support.isDisplayed())
				System.out.println("All elements of Resume previous sessions are displayed on landing page.");
				
				ResumePreviousSession.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WebElement ResumeFlow = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
				if(ResumeFlow.isDisplayed())				
				System.out.println("Resume previous session button flow tested successfully.");
				
							
			//Start new session flow - from resume previous session	
				
				driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");				
				
				if (title.equalsIgnoreCase("GENEO: Product"));
				
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[contains(@class,'btn_new_session')]")).click();
				
				//Class selection page
				
				driver.findElement(By.id("classSpecific")).click();
				WebElement Classes, CHamburger, CGeneoLive, CSupport;
				Classes = driver.findElement(By.xpath("//div[@id='classtemplate']"));
				CHamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
				CGeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
				CSupport = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
				
				if(Classes.isDisplayed() && CHamburger.isDisplayed() && CGeneoLive.isDisplayed() && CSupport.isDisplayed())
					System.out.println("Start New session - class selection all elements displayed.");
				
				
				//Subject selection page
				driver.findElement(By.xpath("//a[contains(@class,'classX')]")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@id='step1']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				WebElement Subjects, Hamburger1, GeneoLive1, Support1, CareerPath, RememberMe;
				Subjects = driver.findElement(By.xpath("//div[contains(@class,'seleSubj')]"));
				Hamburger1 = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
				GeneoLive1 = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
				Support1 = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));				
				CareerPath = driver.findElement(By.xpath("//a[@class='btnCareerPath']"));
				RememberMe = driver.findElement(By.id("remember_land"));
				
				if(Subjects.isDisplayed() && Hamburger1.isDisplayed() && GeneoLive1.isDisplayed() && Support1.isDisplayed() && CareerPath.isDisplayed() && RememberMe.isDisplayed())
					System.out.println("Start New session - Subject selection all elements displayed.");
				
				driver.findElement(By.xpath("//a[@id='liScience']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				RememberMe.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@id='step2']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
						
			//Chapter index page	
				
				WebElement Chapters = driver.findElement(By.xpath("//ul[contains(@class,'chapterlist')]"));
				
				WebElement Hamburger2, GeneoLive2, Support2;
				Hamburger2 = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
				GeneoLive2 = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
				Support2 = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
				
				if(Hamburger2.isDisplayed() && GeneoLive2.isDisplayed() && Support2.isDisplayed() && Chapters.isDisplayed())
					System.out.println("Start New session - Chapter index all elements displayed.");
				
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
				
				if(FlowEnd.isDisplayed())
					System.out.println("Landing Page - Start New Session Complete flow tested.");
				
				
				
			/*//Upgrade Now
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img")).click();
				driver.findElement(By.xpath("//a[@data-value='Logout']")).click();
								
				for (String winhandle: driver.getWindowHandles()) {
				    driver.switchTo().window(winhandle);
				        
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				
				driver.findElement(By.xpath("//button[contains(@class,'cls_logout')]")).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("login_input_Uname")).sendKeys("ganil.pimplka@cdnlagu.com");
				driver.findElement(By.id("login_input_Pwd")).sendKeys("123456");
				driver.findElement(By.xpath("//input[contains(@class,'btn_stud_login')]")).click();
				
				if (title.equalsIgnoreCase("GENEO: Product"));
				
				driver.findElement(By.xpath("//a[@id='aProceed']")).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				WebElement UpgradeNow = driver.findElement(By.xpath("//a[contains(@class,'butUpgr')]"));
				
				if(UpgradeNow.isDisplayed())
					
					UpgradeNow.click();
				WebElement SubscriptionPage = driver.findElement(By.xpath("//div[@id='mySubscription']"));
				
				if(SubscriptionPage.isDisplayed())
					System.out.println("Landing page - upgrade now and flow is working as expected.");*/
		
		
		//-------------Student Login first time flow - when settings are not saved - student lands on class selection page.
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img")).click();
			driver.findElement(By.xpath("//a[@class='is-close js-hiraku-left-close-btn trn']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		        
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnFeedbackLogout']")).click();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.findElement(By.id("login_input_Uname")).sendKeys("srini.adepu@nextsteps.ai");
		driver.findElement(By.id("login_input_Pwd")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[contains(@class,'btn_stud_login')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (title.equalsIgnoreCase("GENEO: Product"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement NewClasses, NewHamburger, NewGeneoLive, NewSupport;
		
		NewClasses = driver.findElement(By.xpath("//div[@id='classtemplate']"));
		NewHamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku')]//img"));
		NewGeneoLive = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
		NewSupport = driver.findElement(By.xpath("//a[@id='txtSupportSL']"));
		
		if(NewClasses.isDisplayed() && NewHamburger.isDisplayed() && NewGeneoLive.isDisplayed() && NewSupport.isDisplayed())
		System.out.println("Student lands on class selection page. Student login for the first time flow tested.");
		
		//go back and save the settings
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'redirect_landing')]//img")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'classX')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='liScience']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='remember_land']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step2']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@class='pb-4'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
		//Chat Screen
		
			public static void ChatScreen() {
				
				
				WebElement CSHamburger, CSFeedback, CSGeneoHome, CSSearch, CSExploreMore, CSLiveClass, CSSelectedSubject, CSSelectedChapter, CSPDF, CSPagination, CSPreviousPageButton, CSNextPageButton, CSProgress, CSAskAQuestion, CSAssessment;   
				
				CSHamburger = driver.findElement(By.xpath("//button[contains(@id,'hiraku-offcanvas')]"));
				CSFeedback = driver.findElement(By.xpath("//a[@id='addfeedbackButtoonId']"));
				CSGeneoHome = driver.findElement(By.xpath("(//a[contains(@class,'redirect_landing')]//img)[1]"));
				CSSearch = driver.findElement(By.xpath("//input[@id='query_text_input_1']"));
				CSExploreMore = driver.findElement(By.xpath("//button[@id='exploreMore']"));
				CSLiveClass = driver.findElement(By.xpath("//a[@id='aStudentLiveClass']"));
				CSSelectedSubject = driver.findElement(By.xpath("//span[@id='selectd-subject']"));
				CSSelectedChapter = driver.findElement(By.xpath("//h1[@id='chapter_title']"));
				CSPDF = driver.findElement(By.xpath("//div[@id='reader']"));
				CSPagination = driver.findElement(By.xpath("//div[contains(@class,'pgnumbs')]"));
				CSPreviousPageButton = driver.findElement(By.xpath("//span[contains(@class,'cls_previous')]"));
				CSNextPageButton = driver.findElement(By.xpath("//span[contains(@class,'cls_nextPag')]"));
				CSProgress = driver.findElement(By.xpath("//a[@id='progressside']"));
				CSAskAQuestion = driver.findElement(By.xpath("//a[@id='askquest']")); 
				CSAssessment = driver.findElement(By.xpath("//a[@id='assesside']"));
				
				/*java.util.List<WebElement> CStools;
				CStools = driver.findElements(By.xpath("//span[contains(@class,'toltip')]"));
				
				java.util.List<WebElement> LARA;
				LARA = driver.findElements(By.xpath("//li[contains(@class,'dummy212')]"));*/
			
				if(CSHamburger.isDisplayed() && CSFeedback.isDisplayed() && CSGeneoHome.isDisplayed() && CSSearch.isDisplayed() && CSExploreMore.isDisplayed() && CSLiveClass.isDisplayed() && CSSelectedSubject.isDisplayed() && CSSelectedChapter.isDisplayed() && CSPDF.isDisplayed() && CSPagination.isDisplayed() && CSPreviousPageButton.isDisplayed() && CSNextPageButton.isDisplayed() && CSProgress.isDisplayed() && CSAskAQuestion.isDisplayed() && CSAssessment.isDisplayed());
								
				WebElement CSTools, CSClassSelected, CSLearn, CSApply, CSRevise;
				
				CSTools = driver.findElement(By.xpath("//ul[@id='toolTipId']"));
				CSClassSelected = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
				CSLearn = driver.findElement(By.id("//a[@id='playleafrn']"));
				CSApply = driver.findElement(By.id("//a[@id='applyside']"));
				CSRevise = driver.findElement(By.xpath("//a[@id='reviseside']"));
				
				if(CSTools.isDisplayed() && CSClassSelected.isDisplayed() && CSLearn.isDisplayed() && CSApply.isDisplayed() && CSRevise.isDisplayed())
					System.out.println("All elements of student chat screen are displayed.");
				
			
			}	

		
	public static void main(String[]args) {
		
		Login();
		LandingPage();
		ChatScreen();
		driver.quit();
		}
}
	
	
