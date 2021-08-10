package automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriverException;

public class LaunchBrowser {

	
		public static WebDriver driver;

		public static void StartBrowser(String browserName)  {
			try {
				if(browserName.equalsIgnoreCase("Chrome")){
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Jar files\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				
				else if(browserName.equalsIgnoreCase("Firefox")){
					System.setProperty("webdriver.gecko.driver", "G:\\All\\geckodriver-v0.26.0-win64\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				
				else if(browserName.equalsIgnoreCase("IE")){
					System.setProperty("webdriver.ie.driver", "G:\\S\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
			} 
			
			catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	

