package myPro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends TestNG{
	
	@Test
	
	public void VarifyTitle() {
	String actualTitle = d.getTitle();
	String expectedTitle = "Automation Testing Practice";
	Assert.assertEquals(actualTitle, expectedTitle);
	System.out.println("Varify Title Test is Successful");
}
	
	@Test
	
	public void Alert() {
	d.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
	d.switchTo().alert().accept();
	System.out.println("Alert Test is Successful");
}
	
	@Test
	public void ConfirmAlert() {
	d.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
	d.switchTo().alert().accept();
	System.out.println("Confirm Alert Test is Successful");
}
	
	@Test
	
	public void PromptAlert() {
	d.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
	d.switchTo().alert().accept();
	System.out.println("Prompt Alert Test is Successful");
}
	
	@Test
	public void DragDrop() {
	WebElement drag = d.findElement(By.id("draggable"));
	WebElement drop = d.findElement(By.id("droppable"));
	Actions action = new Actions(d);
	action.dragAndDrop(drag, drop).perform();
	System.out.println("DragDrop Test is Successful");
}
	

	@Test
	public void DatePicker() {
    WebElement datePickerField = d.findElement(By.id("datepicker"));
    datePickerField.click();
    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
    selectDate(d, "January", "15", "2023");
    System.out.println("DatePicker Test is Successful");
}
		
	private void selectDate(WebDriver d, String string, String string2, String string3) {
		
}

	@Test
	
	public void TabTest() {
	d.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/footer/div/div[2]/div[2]/div[2]/div/div[1]/a[1]")).click();
	Set<String>allWindows=d.getWindowHandles();
	Iterator<String> it =allWindows.iterator();
	String MainWindow = it.next();
	String TabWindow = it.next();
	d.switchTo().window(TabWindow).close();
	d.switchTo().window(MainWindow).close();
	System.out.println("Tab Test is Successful");
}
	
	
	@Test

	public void SliderTest() {
	WebElement src = d.findElement(By.xpath("//body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[3]/div[1]/aside[1]/div[1]/div[6]/div[1]/div[1]/span[1]"));
	Actions act = new Actions(d);
	act.dragAndDropBy(src, 200, 0).perform();
	System.out.println("Slider Test is Successful");
}
	
	@Test
	
	public void ResizableTest() {
	WebElement element = d.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
	Actions action = new Actions(d);
	action.dragAndDropBy(element, 5, 5).build().perform();
	System.out.println("Resizable Test is Successful");
}
	
	@Test
	
	public void WindowTest() {
	d.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
	d.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	d.findElement(By.linkText("Selenium")).click();
	Set<String> windows = d.getWindowHandles();
	Iterator<String> iterator = windows.iterator();
	String ParentWindow = iterator.next();
	String ChildWindow = iterator.next();
	d.switchTo().window(ChildWindow);
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Window Test is Successful");
}

	@Test
	
	public void DoubleClickTest() {
	Actions act = new Actions(d);
	act.doubleClick(d.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"))).perform();
	System.out.println("DoubleClick Test is Successful");
}
}
