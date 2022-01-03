package AutomationAssignment.Task2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//GET AND STORE WEBELEMENTS LIST
public class AutomationAssignment_002 {
	public static WebDriver Driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Java1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		AutomationAssignment_002 BrowserAct = new AutomationAssignment_002();
		BrowserAct.OpenInternetHerokuapp();
		Thread.sleep(1500);
		BrowserAct.StoreWebElements();
		Thread.sleep(1500);
		BrowserAct.Quit();
		}
		public void OpenInternetHerokuapp() {
			String Url = "https://the-internet.herokuapp.com/";
//			Driver.manage().window().maximize();
			Driver.get(Url);
		}
		public void StoreWebElements() throws InterruptedException {
			Driver.findElement(By.xpath("//a[normalize-space()='Challenging DOM']")).click();
			Thread.sleep(1500);
			WebElement ListOfItems = Driver.findElement(By.xpath("//div[@class='large-10 columns']//table"));
			List<WebElement> rows = ListOfItems.findElements(By.tagName("tr"));
			List<WebElement> columns; 
			for (WebElement rowEle : rows) {
				columns = rowEle.findElements(By.tagName("td"));
				for(WebElement colEle : columns) {
					System.out.println(colEle.getText());		
		}
				System.out.println("----------------------------------------------------------------------------------------");
		}	}
		public void Quit() {
			Driver.quit();
		}	}
