package tispr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/osik/Desktop/automatiom/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");

		WebDriver myChrome = new ChromeDriver(options);
		myChrome.get("https://tispr.com/");
		myChrome.manage().window().maximize();

		JavascriptExecutor jse = (JavascriptExecutor) myChrome;
		jse.executeScript("window.scrollBy(0,10250)", "");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-10250)", "");
		WebElement aboutUs = myChrome.findElement(By.id("menu-item-1264"));
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

		String winHandleBefore = myChrome.getWindowHandle();
		WebElement bittenApple = myChrome.findElement(By.xpath("//*[@id='nav_download_link']/div/a[2]/img"));
		// Perform the click operation that opens new window
		bittenApple.click();
		Thread.sleep(1000);
		// myChrome.navigate().back();

		// Switch to new window opened
		for (String winHandle : myChrome.getWindowHandles()) {
			myChrome.switchTo().window(winHandle);
		}
		Thread.sleep(2500);
		// Close the new window, if that window no more required
		myChrome.close();

		// Switch back to original browser (first window)
		myChrome.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		Thread.sleep(3000);
		WebElement greenRobot = myChrome.findElement(By.xpath("//*[@id='nav_download_link']/div/a[1]/img"));
		// Perform the click operation that opens new window
		greenRobot.click();
		Thread.sleep(1000);
		// myChrome.navigate().back();

		// Switch to new window opened
		for (String winHandle : myChrome.getWindowHandles()) {
			myChrome.switchTo().window(winHandle);
		}
		Thread.sleep(2500);
		// Close the new window, if that window no more required
		myChrome.close();

		// Switch back to original browser (first window)
		myChrome.switchTo().window(winHandleBefore);

		
		// Continue with original browser (first window)
	}
}
