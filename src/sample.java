
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method 
		System.setProperty("webdriver driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("htttps://www.google.com");
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dheepayadav@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("8870429721");
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.close();
		

	}

}
