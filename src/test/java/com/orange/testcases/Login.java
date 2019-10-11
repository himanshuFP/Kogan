package com.orange.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.orange.base.TestBase;

public class Login extends TestBase
{
@Test
public void test() throws InterruptedException
{
	
driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("mercury");
Thread.sleep(2000);
driver.findElement(By.name("password")).sendKeys("mercury");
Thread.sleep(2000);
driver.findElement(By.name("login")).click();
}
}