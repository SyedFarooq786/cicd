package cart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

		String[] itemsneeded = { "Cucumber", "Beetroot", "Carrot", "Beans" };

		additem(driver,itemsneeded,w);

		checkout(driver,w);

	}


	private static void checkout(WebDriver driver, WebDriverWait w) {

		String code = "rahulshettyacademy";

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[1]")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys(code);
		driver.findElement(By.cssSelector(".promoBtn")).click();		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='promoInfo']")));
		
		

		if (driver.findElement(By.xpath("//span[@class='promoInfo']")).getText().contains("Invalid code ..!")) {

			String error = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
			System.out.println(error + "Please enter crt promo code");
			return;

		}

		else

		{
 
			System.out.println("Thanks " + driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

		}

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement StaticDropdown = driver.findElement(By.xpath("(//select)[1]"));
		Select dropdown = new Select(StaticDropdown);
		dropdown.selectByValue("India");
		driver.findElement(By.cssSelector("input[class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		
	}


	private static void additem(WebDriver driver, String[] itemsneeded,WebDriverWait w) {
		// TODO Auto-generated method stub

		int j = 0;

		{
			List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
			for (int i = 0; i < products.size(); i++) {
				String[] name = products.get(i).getText().split("-");
				String formated = name[0].trim();

				List itemlist = Arrays.asList(itemsneeded);

				if (itemlist.contains(formated))

				{
					
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

					j++;

					if (j == itemsneeded.length) {
						break;
					}
				}

			}
		}

	}
}
