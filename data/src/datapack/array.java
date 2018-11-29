package datapack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class array {
	WebDriver driver;
	@Test(dataProvider="data")
	public void login(String Username,String password) throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:/Users/pratb/Desktop/nive/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driver.findElement(By.id("identifierId")).sendKeys(Username);
	driver.findElement(By.id("identifierNext")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input")).sendKeys(password);
	driver.findElement(By.id("passwordNext")).click();
	Thread.sleep(3000);
	Assert.assertEquals("https://mail.google.com/mail/u/0/#inbox", driver.getCurrentUrl());
	System.out.println(driver.getCurrentUrl());
}
	@Test
	private void close() {
		driver.close();
		System.out.println();
		
	}
	@DataProvider(name="data")
	public Object[][] passdata()
	{
		
		
		Object[][]data=new Object[3][2];
		data[0][0]="admin";
		data[0][1]="admin";
		data[1][0]="snivedhaonmail@gmail.com";
				data[1][1]="nivedhasekar93";
				data[2][0]="admin";
				data[2][1]="admin";
				System.out.println(data);
				return data;
	}
}
