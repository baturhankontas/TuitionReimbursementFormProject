package com.kontas.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kontas.pages.TuitionProMain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.kontas.steps")
public class TuitionProRunner {
	public static WebDriver driver;
	public static TuitionProMain tuitionpromain;
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();

		tuitionpromain= new TuitionProMain(driver);
		
		

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
