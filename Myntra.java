package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement findElement = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(findElement).perform();
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        
        String text = driver.findElement(By.xpath("//span[contains(@class,'title-count')]")).getText();
        System.out.println(text);
        String replace = text.replaceAll("[^0-9]","");
        int sum1 = Integer.parseInt(replace);
        
        WebElement findElement2 = driver.findElement(By.xpath("(//label[contains(@class,'common-customCheckbox vertical-filters-label')])[1]"));
        String text2 = findElement2.getText();
        String replace1 = text2.replaceAll("[^0-9]","");
        int sum2 = Integer.parseInt(replace1);
        
        WebElement findElement3 = driver.findElement(By.xpath("(//label[contains(@class,'common-customCheckbox vertical-filters-label')])[2]"));
        String text3 = findElement3.getText();
        String replace2 = text3.replaceAll("[^0-9]","");
        int sum3 = Integer.parseInt(replace2);
        
        int sum = sum2 + sum3;
        if(sum==sum1) {
        	System.out.println("sum of categories of count is matched");
        }
        else {
        	System.out.println("sum of categories of count is not matched ");
        }
        
        driver.findElement(By.xpath("(//label[contains(@class,'common-customCheckbox vertical-filters-label')])[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'brand-more')]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(0));
		
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
	    driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
        driver.switchTo().defaultContent();
		WebElement findelement4 = driver.findElement(By.xpath("(//input[@value='Duke']/following::span)[1]"));
        String text4= findelement4.getText();
	    String replace3 = text4.replaceAll("[^0-9]","");
	    int duke = Integer.parseInt(replace3);
        List<WebElement>lt = new ArrayList<WebElement>();
	    for (int i = 0; i <duke ; i++) {
		  lt.add(findelement4);
	}	
		
	      int size = lt.size();
		
	       if(size==duke) {
			
			System.out.println("Only Duke brand is added to the list");
		}   else {
			
			System.out.println("Contains other brands");
		}
		
	    WebElement findelement5 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
	    WebElement findelement6 = driver.findElement(By.xpath("//div[@class='sort-sortBy']/span"));
	    builder.moveToElement(findelement5).moveToElement(findelement6).click(findelement6).perform();
	    WebElement findelement7 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
	    String text5 = findelement7.getText();
	    System.out.println("Price of 1st item:" + text5);
	    driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
	    Set<String> windowHandles2 = driver.getWindowHandles();
	    List<String> window2 = new ArrayList<String>(windowHandles2);
	    driver.switchTo().window(window2.get(1));
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File destination = new File("./images/DukeJacket.png");
	    FileUtils.copyFile(source, destination);
	    driver.findElement(By.xpath("//span[contains(text(),'WISHLIST')]")).click();
	    driver.switchTo().defaultContent();
	    driver.quit();
	

        
        
        
        
        
        
	}

}
