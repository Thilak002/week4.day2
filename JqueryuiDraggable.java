package week4.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryuiDraggable {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/draggable");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.switchTo().frame(0);
			Actions builder = new Actions(driver);
			WebElement drag = driver.findElement(By.id("draggable"));
			builder.dragAndDropBy(drag, 80, 140).perform();
	}

}
