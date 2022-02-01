package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryOptionScreen {
	
public WebDriver driver;
	
	By inventoryitem=By.xpath("//a[@id='result_app_1']");
	
	
	public InventoryOptionScreen(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public WebElement getInventory()
	{
		return driver.findElement(inventoryitem);
	}
	

}
