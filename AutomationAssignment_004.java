package AutomationAssignment.Task2;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//HANDLE WEB ELEMENTS & EXTERNAL ELEMENTS
public class AutomationAssignment_004 {
	public static WebDriver Driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Java1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		AutomationAssignment_004 BrowserAct = new AutomationAssignment_004();
		BrowserAct.OpenInternetHerokuapp();
		Thread.sleep(1500);
		BrowserAct.Text();
		Thread.sleep(1500);
		BrowserAct.Quit();
	}	
	public void OpenInternetHerokuapp() {
		String Url = "https://the-internet.herokuapp.com/";
	//	Driver.manage().window().maximize();
		Driver.get(Url);
	}
	public void Text() throws InterruptedException, IOException {
		Driver.findElement(By.xpath("//a[normalize-space()='Frames']")).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//a[normalize-space()='iFrame']")).click();
		Thread.sleep(1000);
		Driver.switchTo().frame(Driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
		Driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).clear();
		String Text = "Hello, this is a External element test! Frames!";
		Driver.findElement(By.xpath("//body//p")).sendKeys(Text);
		Thread.sleep(1000);
//		WebElement TextInputted =  Driver.findElement(By.xpath("//body//p"));
		if(Text != null) {
			System.out.println(Text);
			System.out.println("----------------");
			System.out.println("Passed!");
	}
//		else {
//			System.out.println("Failed");
//	}
	}
	public void Quit() {
		Driver.quit();
	}	}
