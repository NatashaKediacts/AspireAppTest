package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturingPage {
	
public WebDriver driver;
	
    By Manufacturingoption= By.xpath("//div[text()='Manufacturing']");
    By Manufacturingordercreate= By.xpath("//button[@data-original-title='Create record']");
	By ProductName= By.xpath("//div[@name='product_id']//input");
	By SaveButton= By.xpath("//button[@title='Save record']");
	By ConfirmOrder= By.xpath("//button[@name='action_confirm']");
	By MarkasDone= By.xpath("(//button[@name='button_mark_done']//span[text()='Mark as Done'])[2]");
	By AlertOk= By.xpath("//span[text()='Ok']");
	By ApplyText=By.xpath("//span[text()='Apply']");
	By Alertboxtitle= By.xpath("//h4[text()='Immediate Production?']");
	By DoneStatus= By.xpath("//ul[@class='o_Message_trackingValues']//div[text()='Done']");
	By Producttext= By.xpath("//a[@name='product_id']//span");
	By NewProductCreate= By.xpath("//span[text()='Create']");
	
	
	public ManufacturingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;	
	}

	public WebElement getmanufacturingoption()
	{
		return driver.findElement(Manufacturingoption);
	}
	
	public WebElement getmanufacturingordercreate()
	{
		return driver.findElement(Manufacturingordercreate);
	}
	
	public WebElement getProductName()
	{
		return driver.findElement(ProductName);
	}
	
	public WebElement getSaveButton()
	{
		return driver.findElement(SaveButton);
	}
	
	public WebElement getConfirmOrder()
	{
		return driver.findElement(ConfirmOrder);
	}
	
	public WebElement getMarkasDone()
	{
		return driver.findElement(MarkasDone);
	}
	
	public WebElement getAlertOk()
	{
		return driver.findElement(AlertOk);
	}
	
	public WebElement getApplyText()
	{
		return driver.findElement(ApplyText);
	}
	
	public WebElement getAlertboxtitle()
	{
		return driver.findElement(Alertboxtitle);
	}
	
	public WebElement getDoneStatus()
	{
		return driver.findElement(DoneStatus);
	}
	
	public WebElement getProducttext()
	{
		return driver.findElement(Producttext);
	}
	
	public WebElement getNewProductCreate()
	{
		return driver.findElement(NewProductCreate);
	}
	

}
