package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MS");
		from.sendKeys(Keys.TAB);
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("MDU");
		To.sendKeys(Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		int rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainNames = new ArrayList<String>();
		for (int i = 1; i <= rows; i++) {
			 String trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i +"]/td[2]")).getText();
			 trainNames.add(trainName);	
		}
		Set<String> trains = new HashSet<String>(trainNames);
		if(trainNames.size()== trains.size() ) {
			System.out.println("there is no duplicates");
		}else {
			System.out.println("There is some duplicates");
		}
		}
			

	}


