package testBase;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//WebDriver
	public static WebDriver driver;
	
	//log
	public Logger logger;
	
	//Common properties
	public ResourceBundle rb;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String chr) {
		//logger
		logger=LogManager.getLogger(this.getClass());
		
		//common Properties
		rb= ResourceBundle.getBundle("config_1");
		if(chr.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if (chr.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("BaseUrl"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tear_down(){
		driver.close();
	}

	//random values

	//String
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	//number
	public String radomNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumberic() {
		String Alpha=RandomStringUtils.randomAlphabetic(3);
		String numb=RandomStringUtils.randomNumeric(10);
		return (Alpha+numb);

	}
	
	public String captureScreen(String sc) throws IOException {
		//TimeStamp
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt=new Date();
		String timestamp=df.format(dt);
		
		//ScreenShot method
		TakesScreenshot tc=(TakesScreenshot)driver;
		File source=tc.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+ sc +"_"+ df +".png";
 		//File trg= new File(destination);
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return destination;
	}


}


