package tispr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {

	public static void main(String[] args) throws InterruptedException {
		//Initialize webdriver
		System.setProperty("webdriver.chrome.driver", "C:/Users/osik/Desktop/automatiom/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		WebDriver myChrome = new ChromeDriver(options);
		//Launch tispr
		myChrome.get("https://tispr.com/");
		myChrome.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) myChrome;
		//Scroll down
		jse.executeScript("window.scrollBy(0,10250)", "");
		Thread.sleep(1000);
		//Scroll up
		jse.executeScript("window.scrollBy(0,-10250)", "");
		WebElement aboutUs = myChrome.findElement(By.id("menu-item-1264"));
		//Click thru main menu buttons
		aboutUs.click();
		Thread.sleep(1000);
		myChrome.navigate().back();
		WebElement careersLink = myChrome.findElement(By.id("menu-item-617"));
		careersLink.click();
		Thread.sleep(1000);
		myChrome.navigate().back();
		WebElement blogLink = myChrome.findElement(By.id("menu-item-134"));
		blogLink.click();
		Thread.sleep(1000);
		myChrome.navigate().back();
		//Get current handler
		String winHandleBefore = myChrome.getWindowHandle();
		WebElement bittenApple = myChrome.findElement(By.xpath("//*[@id='nav_download_link']/div/a[2]/img"));
		// Perform the click operation that opens new window
		bittenApple.click();
		Thread.sleep(1000);
		// Switch to new window opened
		for (String winHandle : myChrome.getWindowHandles()) {
			myChrome.switchTo().window(winHandle);
		}
		Thread.sleep(2500);
		// Close the new window
		myChrome.close();
		// Switch back to original browser (first window)
		myChrome.switchTo().window(winHandleBefore);
		// Continue with original browser (first window)
		Thread.sleep(3000);
		WebElement greenRobot = myChrome.findElement(By.xpath("//*[@id='nav_download_link']/div/a[1]/img"));
		// Perform the click operation that opens new window
		greenRobot.click();
		Thread.sleep(1000);
		// Switch to new window opened
		for (String winHandle : myChrome.getWindowHandles()) {
			myChrome.switchTo().window(winHandle);
		}
		Thread.sleep(2500);
		// Close the new window
		myChrome.close();
		// Switch back to original browser (first window)
		myChrome.switchTo().window(winHandleBefore);
	}
}
