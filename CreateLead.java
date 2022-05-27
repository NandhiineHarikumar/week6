package week6.day1;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadExcelData_CreateLead;
public class CreateLead extends ProjectSpecificMethods 
{
	@Test(dataProvider = "testData",priority=-1)
	public void createLead(String uName,String pwd,String cName,String fName,String lName) {

		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	

	}

	@DataProvider
	public String[][] testData() throws IOException
	{
		String[][] data = ReadExcelData_CreateLead.readData("tc001");
		return data;
	}
	/*@DataProvider
	public String[][] testData()
	{
		String array[][]=new String[2][5];
		array[0][0] = "Demosalesmanager";
		array[0][1] = "crmsfa";
		array[0][2] = "TestLeaf";
		array[0][3] = "Hari";
		array[0][4] = "R";
		array[1][0] = "DemoCSR";
		array[1][1] = "crmsfa";
		array[1][2] = "TestLeaf";
		array[1][3] = "Babu";
		array[1][4] = "M";
		return array;


	}*/

}
