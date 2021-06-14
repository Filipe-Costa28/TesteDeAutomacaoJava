package qateste;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Qa2 {
	
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
		
		WebElement button3 = driver.findElement(By.id("type"));
		button3.click();
		Select type =new Select(button3);
		type.selectByIndex(2);
		Thread.sleep(1000);
		
		WebElement button2 = driver.findElement(By.className("btn-default"));
		button2.click();
		
		List<WebElement> resultadoPesquisa = driver.findElements(By.xpath("//*[@id=\'page-top\']/div[2]/table/tbody/tr"));
		assertEquals("Caso 1",25,resultadoPesquisa.size(),0);
		System.out.println("Quantidade encontrada de TR: "+ resultadoPesquisa.size() +", esperado pelo teste 25.");
		
		WebElement resultadoPesquisa2 = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/center/ul"));
		System.out.println("Se true está correto: " + resultadoPesquisa2.isDisplayed());
		
		assertTrue("Valor é diferente",resultadoPesquisa2.isDisplayed());
	    
		Thread.sleep(4000);
	}

}
