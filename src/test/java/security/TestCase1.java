package security;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashBoard;
import pages.PassingPage;
import pages.SecurityDomain;

public class TestCase1 extends BaseClass {

	private static Logger log = LogManager.getLogger(TestCase1.class);

	@BeforeTest
	public void initialisebrowser() throws IOException {
		TestCase1 frame = new TestCase1();
		frame.browser("chrome");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@Test(priority = 1)
	public void test() throws Exception {

		login();
		log.info("login page opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		select(PassingPage.hospital, 1);
		select(PassingPage.role, 1);
		driver.findElement(PassingPage.click).click();
		Assert.assertEquals(prop.getProperty("url2"), driver.getCurrentUrl());
		log.info("home page opened");
	}

	@Test(priority = 2)
	public void selectingsecurityuser() {

		hover(DashBoard.settings);
		hover(SecurityDomain.security);
		driver.findElement(SecurityDomain.user).click();
		Assert.assertEquals(prop.getProperty("url4"), driver.getCurrentUrl());

	}

	@Test(priority = 3)
	public void validatingusertable() {
		WebElement table = driver.findElement(SecurityDomain.usertable);
		List<WebElement> rows = table.findElements(SecurityDomain.tablerows);
		int rowcount = rows.size();
		System.out.println(rowcount);
		List<WebElement> columns = table.findElements(SecurityDomain.tablecolumns);
		int columncount = columns.size();
		System.out.println(columncount);
		for (int i = 1; i <= columncount; i++) {
			boolean value = table.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/table/thead/tr/th[" + i + "]"))
					.isDisplayed();
			Assert.assertTrue(value);

		}
		boolean value2 = driver.findElement(SecurityDomain.useradd).isDisplayed();
		Assert.assertTrue(value2);
	}
}
