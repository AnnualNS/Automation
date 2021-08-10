package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class StudentChatScreen extends LaunchBrowser {
	
	public static void Search() {
		
		WebElement Search = driver.findElement(By.xpath("//input[@id='query_text_input_1']"));
			if(Search.isDisplayed());
				
			driver.findElement(By.xpath("//input[@id='query_text_input_1']")).click();
			driver.findElement(By.xpath("//input[@id='query_text_input_1']")).sendKeys("electric");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement Suggestions = driver.findElement(By.xpath("//ul[@id='suggestionsResultsList1']"));
			if(Suggestions.isDisplayed())
				System.out.println("Search suggestions displayed to the student.");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//a[@class='searchResults'])[1]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement Results = driver.findElement(By.xpath("//h3[@id='SearchResultText']"));
			if(Results.isDisplayed()) {
				System.out.println("Search results are displayed from suggestions.");
			}
			else {
				System.out.println("Error: Search results not displayed.");
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//a[contains(@class,'downTimer')])[last()]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
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
			if(Video.isDisplayed())
				driver.findElement(By.xpath("//button[@class='vjs-big-play-button']")).click();
			System.out.println("Student can open both PDF and video from search result.");
	
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

	public static void SubjectSelection() {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement Subject = driver.findElement(By.xpath("//a[@id='changeSubjectToolTipId']"));
			Actions action = new Actions(driver);
			action.moveToElement(Subject).perform();
			action.pause(3);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(driver.findElement(By.xpath("//ul[@class='dropdown-menu2']")).isDisplayed()) {
				System.out.println("Student can see the subject dropdown list on mouse hover.");
			}
			
			else {
				System.out.println("Error: Student cannot see the subject dropdown list on mouse hover.");
			}
			
			driver.findElement(By.xpath("//label[contains(text(),'Geography')]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//span[@id='selectd-subject']")).getText() == "Geography") {
				System.out.println("Selected subject from dropdown is displayed.");
			}
			else {
			System.out.println("Error: Selected subject from dropdown list is not displayed.");
			}
			
		}
		
	public static void ChapterSelection() {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement Chapter = driver.findElement(By.xpath("//a[@id='chapterListToolTipId']"));
			Actions action = new Actions(driver);
			action.moveToElement(Chapter).perform();
			action.pause(3);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(driver.findElement(By.xpath("//ul[@id='ChapterList']")).isDisplayed()) {
				System.out.println("When student hovers over the subject change, the subject dropdown list is displayed.");
			}
			else {
				System.out.println("Error: On hover, the dropdown is not displayed.");
			}
			
			Select chapter = new Select(driver.findElement(By.xpath("//ul[@id='ChapterList']")));
			chapter.selectByIndex(3);
								
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//h1[@id='chapter_title']//h1[contains(text(),'3')]")).isDisplayed()) {
				System.out.println("Selected chapter is displayed.");
			}
			else {
				System.out.println("Error: Selected chapter is not displayed.");
			}
			
		}
		
	public static void PDF() {
			
			WebElement pdf = driver.findElement(By.xpath("//div[@id='reader']"));
			if(pdf.isDisplayed()) {
				System.out.println("Student can view the PDF");
			}
			
			else {
				System.out.println("Error: Student cannot view the PDF");
			}
				
		}
		
	public static void Pager() {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement Pagination = driver.findElement(By.xpath("//div[@id='pagetooltipid']"));
			WebElement Previous = driver.findElement(By.xpath("//span[contains(@class,'cls_previous')]//a"));
			WebElement Next = driver.findElement(By.xpath("//span[contains(@class,'cls_nextPag')]//a"));
			
			if(Pagination.isDisplayed()) {
				System.out.print("Pager displayed to the student.");
			}
			
			else {
				System.out.print("Error: Pager unavailable to the student.");
			}
			
			if(Previous.isDisplayed() && Next.isDisplayed()) {
				System.out.print("Previous and Next buttons are displayed to the student on pagination.");
			}
			
			else {
				System.out.print("Error: Previous and Next buttons are unavailable.");
			}
		}
		
	public static void ReferAndEarn() {
			
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
	
	public static void TakeaTour() {
		
		WebElement Hamburger = driver.findElement(By.xpath("//div[@class='west-top']//button"));
		WebElement TAT = driver.findElement(By.xpath("//li[@class='takeTour']"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hamburger.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(TAT.isDisplayed()) {
			System.out.println("Take a tour available on hamburger menu of student chat screen.");
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TAT.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement SearchTooltip = driver.findElement(By.xpath("//div[contains(text(),'Use this search box to find topics and learning content')]"));
		
		if(SearchTooltip.isDisplayed()) {
			System.out.println("Take a tour is highlighting Search box.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click next
		WebElement Next = driver.findElement(By.xpath("//a[contains(@class,'introjs-nextbutton')]"));
		Next.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement GeneoLiveTooltip = driver.findElement(By.xpath("//div[contains(text(),'Launch Geneo Live classes from here. You can access subject wise classes and register')]"));
		
		if(GeneoLiveTooltip.isDisplayed()) {
			System.out.println("Next button on tour highlight is working.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click Previous
		WebElement Previous = driver.findElement(By.xpath("//a[contains(@class,'introjs-prevbutton')]"));
		Previous.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(SearchTooltip.isDisplayed()) {
			System.out.println("Previous button on tour highlight is working.");
		}
		
		//Click Skip
		WebElement Skip = driver.findElement(By.xpath("//a[contains(@class,'introjs-skipbutton')]"));
		Skip.click();
		System.out.println("Skip button on tour highlight is working.");
		
		
		//Next button highlight sequence
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='west-top']//button")).click();
		driver.findElement(By.xpath("//li[@class='takeTour']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Use this search box to find topics and learning content')]")).isDisplayed();
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
	
	public static void QuestionPaper() {
		
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
		
	public static void CareerPath() {
		
		//Class 8-
		driver.findElement(By.xpath("(//img[@class='logo figure-img img-fluid'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='classSpecific']")).click();
		driver.findElement(By.xpath("//a[@data-classname='Standard VIII']")).click();
		driver.findElement(By.xpath("//a[@id='step1']")).click();
		
		//subject page career path-
		driver.findElement(By.xpath("//button[contains(@class,'hiraku-offcanvas')]")).click();
		if(driver.findElement(By.xpath("//a[@class='careerPath']")).isDisplayed()) {
			System.out.println("Career path available on hamburger menu of subject selection page.");
		}
		else {
			System.out.println("Error: Career path unavailable on hamburger menu of subject selection page.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'is-close')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//a[@class='btnCareerPath']")).isDisplayed()) {
			System.out.println("Career path available on subject selection page.");
		}
		else {
			System.out.println("Error: Career path unavailable on subject selection page.");
		}
		driver.findElement(By.xpath("//a[contains(@class,'is-close')]")).click();
		
		//chapter index page career path-
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='liScience']//span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='step2']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button//img")).click();
		if(driver.findElement(By.xpath("//a[@class='careerPath']")).isDisplayed()) {
			System.out.println("Career path available on hamburger menu of chapter index page.");
		}
		else {
			System.out.println("Error: Career path unavailable on hamburger menu of chapter index page.");
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'is-close')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//li[@class='pb-4'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class,'js-hiraku')]")).click();
		
		if(driver.findElement(By.xpath("//a[@class='careerPath']")).isDisplayed()) {
			System.out.println("Career path available on hamburger menu of student chat screen.");
		}
		else {
			System.out.println("Error: Career path unavailable on hamburger menu of student chat screen.");
		}
		
		driver.findElement(By.xpath("(//a[contains(@class,'is-close')])[1]")).click();
		
		//Class 9-
		
	}

	
	public static void GeneoLive() {
		
		//in house user-
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='aStudentLiveClass']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//button[contains(@class,'js-hiraku')]")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'redirect_landing')]")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='btnPDF']//label")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='tblLiveClass_filter']//label")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'toltip')]")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul[@class='pagination']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("All elements of geneo live displayed.");
		
		driver.findElement(By.xpath("//button//img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-value='Logout']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		           
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		driver.findElement(By.xpath("//button[contains(@class,'logout')]")).click(); 
		
		System.out.println("Geneo Live tested for inhouse/paid user.");
		
		//trial expired user-
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login_input_Uname")).sendKeys("trialcbseautomation@geneo.in");
		driver.findElement(By.id("login_input_Pwd")).sendKeys("Geneo@123");
		driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("GENEO: Product"));{
			System.out.println("Trial expired user login with Email and password successfully.");
		}
		driver.findElement(By.xpath("//a[@id='aProceed']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(@class,'classX')]")).click();
		driver.findElement(By.xpath("//a[@id='step1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='aStudentLiveClass']")).click();
		
		for (String winhandle: driver.getWindowHandles()) {
		    driver.switchTo().window(winhandle);
		           
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		driver.findElement(By.xpath("(//p[contains(text(),'Please subscribe')])[1]")).click(); 
		driver.findElement(By.xpath("(//button[@class='update-profile profile_btn'])[1]")).click();
		
		System.out.println("Expired user cannot access Geneo Live tested.");
		
		
		
	}
	
	public static void HamburgerMenu() {
		
		driver.findElement(By.xpath("//button[contains(@id,'hiraku')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'editProfile')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(@class,'Subscription')]")).isDisplayed();
		driver.findElement(By.xpath("//li[@class='takeTour']//a")).isDisplayed();
		driver.findElement(By.xpath("//li[@id='referFriendhide']//a")).isDisplayed();
		driver.findElement(By.xpath("//li[@id='lisupport']//a")).isDisplayed();
		driver.findElement(By.xpath("//a[@class='careerPath']")).isDisplayed();
		
		System.out.println("Edit Profile, Subscription, Take a tour, Refer a friend, Support and Career path are available on the hamburger menu.");
		
		driver.findElement(By.xpath("//a[contains(@class,'editProfile')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//h1[contains(text(),'Customer Information')]")).isDisplayed()) {
			System.out.println("The student is redirected to Edit Profile Page");
		}
		else {
			System.out.println("Error: Not redirected to Edit Profile Page");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).click();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Redirected back to chat screen.");
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@id,'hiraku')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(@class,'Subscription')]")).click();
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).isDisplayed()) {
			System.out.println("The student is redirected to Subscription Page");
		}
		else {
			System.out.println("Error: Not redirected to Subscription Page");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).click();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Redirected back to chat screen.");
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@id,'hiraku')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//li[@id='lisupport']//a")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'Need Help')]")).isDisplayed()) {
			System.out.println("The student is redirected to Support Page");
		}
		else {
			System.out.println("Error: Not redirected to Support Page");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'backbutton')]")).click();
		System.out.println("Redirected back to chat screen.");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@id,'hiraku')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//li[@id='referFriendhide']//a")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//h1[contains(text(),'Refer a Friend')]")).isDisplayed()) {
			System.out.println("The student is redirected to Refer a friend Page");
		}
		else {
			System.out.println("Error: Not redirected to  Refer a friend.");
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'downTimer')]")).click();
		System.out.println("Redirected back to chat screen.");
	}
	
	public static void main(String[] args) {
		
		StartBrowser("Chrome");
		driver.manage().window().maximize();
		
		driver.get("https://test1.geneo.in/geneo_live/student_login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login_input_Uname")).sendKeys("saikrishna0225@gmail.com");
		driver.findElement(By.id("login_input_Pwd")).sendKeys("9985041616");
		driver.findElement(By.xpath("//input[contains(@class,\"btn_stud_login\")]")).click();
		
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("GENEO: Product"));
			System.out.println("Login with Email and password successfully.");
			
			WebElement ResumePreviousSession = driver.findElement(By.xpath("//button[contains(@class,'btn_resume_session')]"));
			ResumePreviousSession.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			WebElement ResumeFlow = driver.findElement(By.xpath("//span[contains(@class,'userSelStandard')]"));
			if(ResumeFlow.isDisplayed())				
			System.out.println("The user has landed on student chat screen.");
			
			
			//Search();
			//SubjectSelection();
			//ChapterSelection();
			//PDF();
			//QuestionPaper();
			//TakeaTour();
			//CareerPath();
			//GeneoLive();
			HamburgerMenu();

	}

}
