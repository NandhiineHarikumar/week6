package week6.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadFromExcel_EditLead;
public class EditLead extends ProjectSpecificMethods {
	@Test(dataProvider = "testData",enabled=false)
	public void editLead(String uName,String pwd,String pNum,String cName) throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] testData() throws IOException
	{
		String[][] data= ReadFromExcel_EditLead.readDataFromExcel("Editlead");
		return data;
	}
	/*public String[][] testData()
	{
		String array[][] = new String[2][4];
		array[0][0] ="DemosalesManager";
		array[0][1] ="crmsfa";
		array[0][2] ="99";
		array[0][3] ="TCS";
		array[1][0] ="DemosalesManager";
		array[1][1] ="crmsfa";
		array[1][2] ="11";
		array[1][3] ="TL";
		
		return array;
	}*/
}
