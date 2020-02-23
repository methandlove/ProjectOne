package com.Main;

import java.io.*;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MethodsDriver {
	static WebDriver driver;

	public void launch_Browser(String URL) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\K Avinash\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public WebElement getControl(String ObjName) {
		WebElement obj = null;
		String xpath = null;
		try {
			xpath = getXpath(ObjName);
			obj = driver.findElement(By.xpath(xpath));

		} catch (Exception e) {
			System.out.println("element with xpath: " + xpath + " not found");
		}
		return obj;
	}

	public void click(String ObjName) {
		try {

			WebElement ele = getControl(ObjName);
			ele.click();

		} catch (Exception e) {
			System.out.println("element not clicked");
		}

	}

	public void VerifyText(String ObjName, String ExpectedText) {
		WebElement ele = getControl(ObjName);
		String ActualText = ele.getText().trim();
		if (ActualText.equals(ExpectedText.trim()))
			System.out.println("Passed..... Actual Text is matched to Expected");
		else
			System.out.println("Failed..... Actual Text is not matched to Expected");
	}

	public void SetValueWeb(String xpath, String Value) {
		try {
			// select
			WebElement ele = getControl(xpath);

			if ((ele.getAttribute("type")).equals("text")) {
				ele.sendKeys(Value);
			}

			if ((ele.getAttribute("type")).equals("select")) {
				Select sl = new Select(ele);
				sl.selectByVisibleText(Value);
			}

			if ((ele.getAttribute("type")).equals("radio")) {
				ele.click();
			}

			if ((ele.getAttribute("type")).equals("checkbox")) {
				ele.click();
			}

		} catch (Exception e) {
			System.out.println("element not selected");
		}

	}

	public String getXpath(String Object_Name) {
		String Xpath = null;
		try {
			// Specify the path of file
			File src = new File(
					"C:\\DrIvE\\JAVA\\Selenium\\WorkSpace\\NewProectOne\\ProectOne_CJ\\Sheets\\UI_Map.xlsx");
			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load sheet- Here we are loading sheet by name
			XSSFSheet sh1 = wb.getSheet("Xpaths");

			for (int i = 1; i < sh1.getLastRowNum(); i++) {
				if (Object_Name.equals(sh1.getRow(i).getCell(0).getStringCellValue())) {
					Xpath = sh1.getRow(i).getCell(1).getStringCellValue();
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Xpath;

	}

	public void writeToExcel() {

	}

}
