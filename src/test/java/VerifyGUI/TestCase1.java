/*
 * package VerifyGUI;
 * 
 * import java.io.FileInputStream; import java.io.IOException; import
 * java.io.InputStream; import java.util.List; import java.util.Properties;
 * import java.util.concurrent.TimeUnit;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import org.openqa.selenium.By; import
 * org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.Select; import org.testng.Assert; import
 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeTest;
 * import org.testng.annotations.Test;
 * 
 * import base.BaseClass; import pages.DashBoard; import pages.DomainValues;
 * import pages.LoginPage; import pages.PassingPage;
 * 
 * 
 * public class TestCase1 extends BaseClass {
 * 
 * private static Logger log = LogManager.getLogger(TestCase1.class);
 * 
 * @BeforeTest public void initialisebrowser() throws IOException { TestCase1
 * frame = new TestCase1(); frame.browser("chrome");
 * 
 * }
 * 
 * @AfterTest public void teardown() { driver.close(); }
 * 
 * @Test public void test() throws Exception {
 * 
 * login();
 * 
 * select(PassingPage.hospital, 1); select(PassingPage.role, 1);
 * 
 * driver.findElement(PassingPage.click).click();
 * Assert.assertEquals(prop.getProperty("url2"), driver.getCurrentUrl());
 * log.info("home page opened"); hover(DashBoard.settings);
 * 
 * driver.findElement(DashBoard.domainvalues).click();
 * 
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * Thread.sleep(3000);
 * 
 * Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("url3"));
 * 
 * boolean default1 =
 * driver.findElement(DomainValues.default_button1).isDisplayed();
 * Assert.assertTrue(default1); boolean default2 =
 * driver.findElement(DomainValues.default_button2).isDisplayed();
 * Assert.assertTrue(default2);
 * 
 * List<WebElement> list = driver.findElements(DomainValues.fulllist); int size
 * = list.size(); for (int i = 1; i <= size; i++) { boolean value =
 * driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/ul/li[" + i +
 * "]")) .isDisplayed(); Assert.assertTrue(value); } for (int i = 1; i <= size;
 * i++) { driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/ul/li[" +
 * i + "]")).click(); JavascriptExecutor js;
 * 
 * js = (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,50)",
 * ""); try { driver.findElement(DomainValues.error_message).click(); } catch
 * (Exception e) {
 * 
 * } }
 * 
 * } }
 */