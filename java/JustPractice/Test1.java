package JustPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Test1 {
private static final String dependsOnMethod = null;
WebDriver driver;
	
	@Parameters("browser")
    @BeforeMethod
	public void main(String browser) throws IOException {
	
		/*FileInputStream reads=new FileInputStream("C:\\Users\\SHIV\\eclipse-workspace\\Practice\\Data.properties");
		Properties reader=new Properties();
		reader.load(reads);
		
		
		String name=reader.getProperty("browser");
	System.out.println(name);
	*/
		String name=browser;
		
	if(name.equals("Firefox"))
	{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium Project\\geckodriver.exe");
		     driver=new FirefoxDriver();
		    driver.get("https://www.google.com/");
	}	
	else
	{

		System.setProperty("webdriver.chrome.driver","C:\\Selenium Project\\chromedriver.exe");
	     driver=new ChromeDriver();
	    driver.get("https://www.google.com/");
	}
	
    }
	
	@BeforeSuite
	public void stest()
	{
		System.out.println("I am a suite");
	}
	
	@BeforeClass
	public void ctest() {
		System.out.println("I am a class");
	}
	
   @BeforeTest
   public void btest() {
	   System.out.println("Hi I am there");
   }
	
	@Test(priority=1,enabled=true)
	public void test2() {
		System.out.println("My name is Manzil");
	}
    
    
	@Test(priority=2,dataProvider="dataprovider",groups="G")
	public void test(String value) {
		System.out.println(value);
		
	}
	
	
	
	@Test(priority=4,dependsOnMethods="test")
	public void test3()
	{
		System.out.println("I am from saduthala");
	}
	
	@Test(priority=3,groups="G")
	public void test4() {
		System.out.println("I live currently in brampton");
	}
	

	@DataProvider(name="dataprovider")
	public static Object[][] data() {
		
		return new Object[][] {{"Manzil"},{"Saduthala"}};
		
		}
	

	
	
	//@AfterMethod
	public void close() {
		driver.quit();
	}
	
	
	
	
}
