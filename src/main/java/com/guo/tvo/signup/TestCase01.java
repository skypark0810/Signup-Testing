package com.guo.tvo.signup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * TestCase01 : Positive testing for the SignUp functionality. 
 * @author Leping Guo
 *
 */

public class TestCase01 
{
	
	public static void main( String[] args ) throws IOException, InterruptedException   
    {
        
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");     
        System.setProperty("webdriver.chrome.driver", "./webDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mpower.tvo.org/educators/#/signup/");
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        
        driver.findElement(By.id("firstName")).sendKeys("Liping");
        driver.findElement(By.id("lastName")).sendKeys("Guo");
        
        Select selectRole = new Select(driver.findElement(By.id("educatorRoleId")));
        selectRole.selectByVisibleText("Teacher");
        
        Select selectBoard = new Select(driver.findElement(By.id("boardId")));
        selectBoard.selectByVisibleText("Algoma DSB");
        
        Select selectSchool = new Select(driver.findElement(By.id("schoolId")));
        selectSchool.selectByVisibleText("Anna McCrea Public School");
        
        driver.findElement(By.id("email")).sendKeys("guoleping@adsb.on.ca");
        driver.findElement(By.id("userEmailConfirm")).sendKeys("guoleping@adsb.on.ca");
        
        driver.findElement(By.id("userPassword")).sendKeys("guo123456");
        driver.findElement(By.id("userPasswordConfirm")).sendKeys("guo123456");
                        
        
        Select selectWhere = new Select(driver.findElement(By.id("source")));
        selectWhere.selectByVisibleText("Another Educator");
        
        driver.findElement(By.id("agreement")).click();
        
        driver.findElement(By.id("emailPromos")).click();
        
        driver.findElement(By.id("registerSubmit")).click();
        
      //Verifying successful registering
        String expectedUrl = "https://mpower.tvo.org/educators/#/confirm";  //The expected page should show up 
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Current actualUrl is " + actualUrl);				
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		Assert.assertTrue(expectedUrl.equals(actualUrl));
		
        System.out.println("TestCase01 got the expected result!");
        driver.close();
        
    }
}
