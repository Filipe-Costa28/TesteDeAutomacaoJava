package qateste;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


public class Qa3 {
	
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
		textbox.sendKeys("Coldflame");
		Thread.sleep(2000);
		
		WebElement button3 = driver.findElement(By.id("type"));
		button3.click();
		Select type =new Select(button3);
		type.selectByIndex(1);
		Thread.sleep(1000);
		
		WebElement button2 = driver.findElement(By.className("btn-default"));
		button2.click();
		
		List<WebElement> resultadoPesquisa = driver.findElements(By.xpath("//*[@id=\"page-top\"]/div[2]/table/tbody/tr"));
		assertEquals("Caso 1",8,resultadoPesquisa.size(),0);
		System.out.println("Quantidade encontrada de TR: "+ resultadoPesquisa.size() +", esperado pelo teste 8.");
		
		WebElement click2 = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/table/tbody/tr[1]/td[6]/a"));
		click2.click();
		Thread.sleep(2000);
		
		WebElement resultadoPesquisa2 = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/table[1]/tbody/tr/td[1]"));
		String result = resultadoPesquisa2.getText();
		System.out.println("Número de questões verificadas " + result + ", esperado pelo teste 8.");
		int resultconvert = Integer.parseInt(result);
				
		List<WebElement> resultadoPesquisa3 = driver.findElements(By.xpath("//*[@id=\"page-top\"]/div[2]/table[2]/tbody/tr"));
		System.out.println(resultadoPesquisa3.size());
						
		WebElement click3 = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[2]/center/ul/li[3]/a"));
		click3.click();
		Thread.sleep(2000);
		
		List<WebElement> resultadoPesquisa4 = driver.findElements(By.xpath("//*[@id=\"page-top\"]/div[2]/table[2]/tbody/tr"));
		System.out.println(resultadoPesquisa4.size());
				
		int resultFinal = (resultadoPesquisa4.size() + resultadoPesquisa3.size());
		System.out.println("Soma das linhas da paginacão: " + resultFinal);
				
		assertEquals("Caso 2",resultFinal,resultconvert,0);
		
		Thread.sleep(10000);
	}

}
