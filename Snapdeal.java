package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement findElement = driver.findElement(By.xpath("//a[contains(@class,'menuLinks leftCategoriesProduct')]//span[contains(@class,'catText')]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(findElement).perform();
        driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]")).click();
        String text = driver.findElement(By.xpath("//span[contains(@class,'category-name category-count')]")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click(); 
        driver.findElement(By.xpath("//div[contains(@class,'sort-selected')]")).click();
        driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]")).click();
        WebElement el1 = driver.findElement(By.className("input-filter"));
        el1.clear();
        el1.sendKeys("900");
        WebElement el2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
        el2.clear();
        el2.sendKeys("1200");
        driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line btn-theme-secondary')]")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'sdCheckbox filters-list')]//label)[4]")).click();
        WebElement findElement2 = driver.findElement(By.xpath("//picture[contains(@class,'picture-elem')]"));
        Actions builder1 = new Actions(driver);
        builder1.moveToElement(findElement2).perform();

        driver.findElement(By.xpath("//div[contains(@class,'clearfix row-disc')]//div")).click();
        String text2 = driver.findElement(By.xpath("//span[contains(@class,'payBlkBig')]")).getText();
        System.out.println(text2);
        String text3 = driver.findElement(By.xpath("(//span[contains(text(),'83% Off')])[1]")).getText();
        System.out.println(text3);
      
      	File source = driver.getScreenshotAs(OutputType.FILE);
      	File destination = new File("./images/TrainingShoes.png");
      	FileUtils.copyFile(source, destination);		
      	driver.switchTo().defaultContent();
      	driver.close();
        
        
	}

}
