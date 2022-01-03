package AutomationAssignment.Task2;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//SCREENSHOT
public class AutomationAssignment_005 {
	public static WebDriver Driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Java1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		AutomationAssignment_005 BrowserAct = new AutomationAssignment_005();
		BrowserAct.OpenInternetHerokuapp();
		Thread.sleep(1500);
		AutomationAssignment_005 ScreenS = new AutomationAssignment_005();
		ScreenS.TakeScreenShot("Main");
		Thread.sleep(1500);
		BrowserAct.Quit();
	}
	public void OpenInternetHerokuapp() {
		String Url = "https://the-internet.herokuapp.com/";
	//	Driver.manage().window().maximize();
		Driver.get(Url);
	}
	public void TakeScreenShot(String FileName) {
		File ScreenS = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenS, new File("C:\\Users\\Admin\\eclipse-workspace\\Java1\\Screenshot\\"+FileName+".png"));
	}
		catch(IOException SShot) {
			SShot.printStackTrace();
	}	}
	public void Quit() {
		Driver.quit();
	}	}
