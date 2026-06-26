package Hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	FileInputStream fis;
	Properties props;
	
	@Before
	public void setup() throws IOException {
		fis=new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Final\\src\\test\\java\\Properties\\PropFile");
		props=new Properties();
		props.load(fis);
		System.out.println("Launching Browser . . .");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url=props.getProperty("url");
		driver.get(url);
	}
	@After
	public void tearDown(Scenario scenario) throws Exception{
		if(scenario.isFailed()) {
			//create unique file name
			String fileName=scenario.getName().replaceAll(" ", "_")+"_"+System.currentTimeMillis();
			//Taking Screenshot
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			//Defining path
			String path="./screenshot/"+fileName+".png";
			//Enduring folder exists
			File folder=new File("./screenshot");
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			//Save screenshot
			Files.copy(src.toPath(),Paths.get(path));
			//Attach to report
			scenario.attach(ts.getScreenshotAs(OutputType.BYTES),"image/png",fileName);
			System.out.println("Screenshot saved "+path);
		}
		driver.quit();
	}
}
