package setup;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSetup {
	// Driver setup function
	
	public static WebDriver driverSetup(String browser, String property, String location, String chromeOption) {
		WebDriver driver = null;
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions options = chromeOptionGenerator(chromeOption);
			System.setProperty("webdriver,driver", "chromedriver.exe");
			// You have to pass options to the chrome driver my sweet heart
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			break;
		case "firefox":
			break;
		case "ie":
			break;
		case "safari":
			break;
		default:
			System.out.println("Not compatible browser");
			break;
		}
		return driver;
	}

	// Driver options for chrome driver
	public static ChromeOptions chromeOptionGenerator(String option) {
		ChromeOptions options = new ChromeOptions();
		// Here we can add options needed including resolutions, zoom level, maximized
		// window and all
		options.addArguments(option);
		// Super darling hug you, but really appreciate this move kiss you baby
		// But some times namma notifications handle pannanumla
		// First aen chellam disable pannatha vachi panraen
		return options;
	}

	// Static function means we dont need to create instances.
	// This is a function and we should not place the function inside the another
	// function
	public static void CloseAlertIfPresent(WebDriver driver, boolean confirm) {
		try {
			driver.switchTo().alert().dismiss();
			if (confirm) {
				// if we need to click yes do that here by passing confirm = true in the calling
				// place
			} else {
				// to just close the alert
			}
			// If Alert exists it will get switched to it
			// do something with the alert here
			// Seems that is not the alert darling it is something else
		} catch (NoAlertPresentException exception) {
			System.out.println("Seems alert is not present");
		}
	}

	public static void closeDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent().close();
		
	}
}
