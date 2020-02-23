package com.Main;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class MainDriver extends MethodsDriver {
static MethodsDriver MD = new MethodsDriver();

	public static void main(String[] args) {

		
		MD.launch_Browser("http://demo.guru99.com/test/web-table-element.php");

		try {
			// Shutterbug.shootPage(driver).save("C:\\Users\\K Avinash\\Downloads\\");
		} catch (Exception e) {
			System.out.println("You are fucked");
		}
		
		
		
		

		String xpath_Company = MD.getXpath("CompanyName");
		String company_name = "Bata";
		String xpath_for_CP = xpath_Company.replace("$", company_name);
		System.out.println(xpath_for_CP);
		if (driver.findElements(By.xpath(xpath_for_CP)).size() != 0) {
			WebElement CP = driver.findElement(By.xpath(xpath_for_CP));
			String cp_value = CP.getText();
			System.out.println(cp_value);
		} else {
			System.out.println("Company is not present");
		}

	}

}
