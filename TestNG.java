package myPro;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNG {
	
	WebDriver d;
		
	@BeforeMethod
	public void setUp() {
	d = new ChromeDriver();
	d.get("https://testautomationpractice.blogspot.com/");
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}	

	@AfterMethod
	public void tearDown() {
	if (d != null) {
	d.quit();
}
}
}