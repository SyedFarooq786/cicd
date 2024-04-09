package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0); // by frame index
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']"))); // by xpath
		System.out.println(driver.findElements(By.tagName("iframe")).size()); //to get index
		Actions a = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop  = driver.findElement(By.id("droppable"));
		a.dragAndDrop(drag, drop).build().perform();
		
		if (driver.findElement(By.id("droppable")).getText().contains("Dropped!"))
		{
			System.out.println("Sucess");
		}
		
		else { 
			System.out.println("no");
		}
		
		
	}

}
