package cart;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement udemy = footer.findElement(By.xpath("(//ul)[1]"));
		System.out.println(udemy.findElements(By.tagName("a")).size());

		for (int i = 1; i < udemy.findElements(By.tagName("a")).size(); i++) {

			String clicklin = Keys.chord(Keys.COMMAND, Keys.ENTER);
			udemy.findElements(By.tagName("a")).get(i).sendKeys(clicklin);
		}
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
