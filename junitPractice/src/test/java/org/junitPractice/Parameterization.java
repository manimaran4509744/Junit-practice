package org.junitPractice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class Parameterization {
	WebDriver driver;
	public String userName;
	public String passWord;
	@Rule
	public ErrorCollector error = new ErrorCollector();

	public Parameterization(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void test_a_login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']//button")).click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		try {
			Assert.assertEquals(actualUrl, expectedUrl);
		} catch (Throwable e) {
			e.getMessage();
			error.addError(e);
		}

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> dataSupplier() {
		Object obj[][] = { { "akash", "akash123" }, { "admin", "admin123" }, { "Admin", "admin123" }

		};
		List<Object[]> list = Arrays.asList(obj);
		return list;

	}

}
