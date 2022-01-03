package AutomationAssignment.Task2;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//UPLOAD FILE WITH AUTOIT
public class AutomationAssignment_003 {
		public static WebDriver Driver;
		public static void main(String[] args) throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Java1\\Drivers\\chromedriver.exe");
			Driver = new ChromeDriver();
			AutomationAssignment_003 BrowserAct = new AutomationAssignment_003();
			BrowserAct.OpenInternetHerokuapp();
			Thread.sleep(1500);
			BrowserAct.FileUpload();
			Thread.sleep(1500);
			BrowserAct.Quit();
			}
			public void OpenInternetHerokuapp() {
				String Url = "https://the-internet.herokuapp.com/";
			//	Driver.manage().window().maximize();
				Driver.get(Url);
			}
			public void FileUpload() throws InterruptedException, IOException {
				Driver.findElement(By.xpath("//a[normalize-space()='File Upload']")).click();
				Thread.sleep(1500);
				Driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
				Thread.sleep(1500);
				Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\Simplilearn\\AutomationProject_0.1\\Upload_Image.exe");
				Thread.sleep(1500);
				Driver.findElement(By.xpath("//input[@id='file-submit']")).click();
				Thread.sleep(1500);
				WebElement Uploaded =  Driver.findElement(By.xpath("//h1[normalize-space()='Internal Server Error']"));
				if(Driver.findElement(By.xpath("//h1[normalize-space()='Internal Server Error']")).isDisplayed()) {
					System.out.println(Uploaded.getText());
					System.out.println("--------------------------");
					System.out.println("Passed!");
			}
				else {
					System.out.println("Failed");
			}	}
			public void Quit() {
				Driver.quit();
			}	}