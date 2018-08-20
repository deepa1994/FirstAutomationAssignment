import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import okio.Timeout;

public class parentchildconcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("chromedriver driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://WWW.google.com");
		driver.navigate().to("https://WWW.udemy.com");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.close();

	}

}
