package week4.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Jqueryuisortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);

		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
		WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[5]"));
		WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']//li[6]"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item6, item1).dragAndDrop(item5, item3).dragAndDrop(item4, item4).dragAndDrop(item3, item5)
				.dragAndDrop(item2, item6).perform();

	}

	}


