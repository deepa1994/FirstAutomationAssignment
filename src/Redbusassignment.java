import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setup.TestSetup;

public class Redbusassignment {

	public static void main(String[] args) throws InterruptedException {
		// All the driver setup are moved to a single function
		// here driver setup is the function you can pass in any chrome driver location
		// or options.
		// We can even move the below function into separate class and we can call for
		// multiple test cases
		WebDriver driver = TestSetup.driverSetup("chrome", "webdriver,driver", "chromedriver.exe", "--disable-notifications");
		driver.get("https://www.redbus.com/");
		driver.findElement(By.xpath("//*[contains(@class,'close')]")).click();

		// HOW TO USE TAG NAMES AND HOW IT IS DIFFERENT FROM THE ATTRIBUTES AND WHEN TO
		// USE CONTAINS
		// @ => represents attribute you used tag name "img" *//[contains()] means anyt
		// tag name contains
		// This is what we have to say actually.
		// I need an img element whose attribute src contains india.png
		// Contains is needed for text comparision not for attribute comparision
		// Second there is no need for \ after png
		// driver.findElement(By.xpath("//*[contains(@img,'/images/India.png\')]")).click();
		// .. will aso point to the immediate parent of the element

		// WHY I USED THE LINK RATHER THAN THE IMAGE
		// image is just a image better to click on the linkl so I went to parent link

		// HOW TO SELECT THE PARENT OR SIBILINGS WITHOUT SELENIUM XPATH METHODS
		// a/B/C/D/E/F => If elements like this //E/.. => point to D
		// if you put like this //E/../ => From the immediate parent of E so this will
		// not point to parent it is used to point to sibilings of E
		// To point ot parent and it sibilings you have to go upto grand parent
		// That is why I used ../../

		// WHY TO BE SPECIFIC TO AN ELEMENT
		// You can see the below xpath will match two elements
		// driver.findElement(By.xpath("//img[@src='/images/India.png']/../../a")).click();
		// to make it more specific we have to use some divisional elements or other
		// parent unique element by that way everything can be matched as needed
		// driver.findElement(By.xpath("//div[@class=\"countries\"]//img[@src='/images/India.png']/../../a")).click();

		// DIFFERENCE BETWEEN // AND /
		// // => Matches any element from the relative position //div means any div from
		// the root element
		// //div//img means => any image considering the selected div as the root
		// element

		// The below codew will trigger the new tab
		driver.findElement(By.xpath("//div[@class='countries']//img[@src='/images/India.png']/../../a")).click();
		// CloseAlertIfPresent(driver, true);
		// Thus you need to switch tab before using the any code for the DOM elements in
		// new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// lets see whether the code is working proper
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		// after the above code the chrome icon will blink notifying that tab got
		// switched in selenium
		// before doing the below operation you need to wait for ajax and page loads to
		// be completed for now I am gonna use sleep.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='sign-in-icon-down']")).click();
		driver.findElement(By.xpath("//li[@id='signInLink']")).click();
		// the below step is not possible since the popup came for signup is inside a
		// frame which I mentioned already here
		// One more thing ABOUT FRAMES
		// If your xpath doesnt find some element check in this order to verify your
		// xpath
		// 1. Copy and paste your xpath to the console find window to check whether it
		// is pointing to the expected element
		// 2. If it points correctly, next step is to check if it is inside some frame.
		// 3. If it is inside frame you need to switch to the frame.
		// 4. If it is not then it may be taking time to load the elements on the dom so
		// you may have to wait for the element or page to load or ajax to complete
		// or use Thread.Sleep(xxxx) in worst case
		WebElement signUpModalFrame = driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(signUpModalFrame);
		driver.findElement(By.xpath("//button[@class='action-button signup-screen signup-btn']")).click();
		driver.findElement(By.xpath("//input[@id='emailID']")).sendKeys("deepapriya393@gmail.com");
		System.out.println("Crossed the sign in...");
		// driver.findElement(By.xpath(""))
		driver.findElement(By.xpath("//button[@class='action-button M12A mobile-screen']")).click();
		TestSetup.closeDriver(driver);
	}

}
