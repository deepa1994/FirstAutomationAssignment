import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("chromedriver,driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.spicejet.com");
		driver.findElement(By.xpath("//*[@id=\"ctl00_HyperLinkLogin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"smoothmenu1\"]/ul/li[14]/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.close();
		
		
        
	}

}
