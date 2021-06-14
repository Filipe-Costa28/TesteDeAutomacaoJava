package qateste;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qa1 {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://opentdb.com/");
		Thread.sleep(1000);
				
		WebElement button1 = driver.findElement(By.className("btn-primary"));
		button1.click();
		Thread.sleep(1000);
		
		WebElement textbox = driver.findElement(By.id("query"));
		textbox.sendKeys("Science: Computers");
		Thread.sleep(2000);
		
		WebElement button2 = driver.findElement(By.className("btn-default"));
		button2.click();
		
		WebElement resultadoPesquisa = driver.findElement(By.className("alert-danger"));
		String resultado = resultadoPesquisa.getText();
				
		System.out.println(resultado);
		
		assertTrue("Valor é diferente",resultadoPesquisa.getText().contentEquals("No questions found."));
		Thread.sleep(4000);
	}

}
