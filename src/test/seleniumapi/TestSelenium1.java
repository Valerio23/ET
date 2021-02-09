package test.seleniumapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String newUsername = "Valerio123";
		String actualUsername = "";
		driver.get("http://localhost:8080/EasyTravel/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("Valerio23");
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("Valerio23.");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[3]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[1]/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"trvls\"]/form[1]/div/input[1]")).sendKeys(newUsername);
		driver.findElement(By.xpath("//*[@id=\"trvls\"]/form[1]/div/input[2]")).click();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"usrInf\"]/h4[1]"));
		
		actualUsername = element.getText();
		assertEquals(newUsername, actualUsername);
		
		driver.close(); 
	}

}
