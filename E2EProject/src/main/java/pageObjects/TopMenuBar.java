package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuBar {

	public WebDriver driver;

	By MenuProducts=By.xpath("//button[@title='Products']");
	By DropdownProducts=By.xpath("//a[text()='Products']");
	By Createbutton=By.xpath("//button[@title='Create record']");
	By InputName=By.xpath("//input[@id='o_field_input_11']");
	By ProductType= By.xpath("//select[@name='detailed_type']");
	By UnitOfMesaurement= By.xpath("//div[@name='uom_id']//input");
	By UnitOfMeasurement_option= By.xpath("//a[text()='oz']");
	By SaveButton= By.xpath("//button[@title='Save record']");
	By UpdateQuantity=By.xpath("//span[text()='Update Quantity']");
	By CreateQuantity= By.xpath("//button[@data-original-title='Create record']");
	By CountedQuantity= By.xpath("//input[@name='inventory_quantity']");
	By SaveQuantity= By.xpath("//button[@title='Save record']");
	By HomeMenu= By.xpath("//a[@title='Home menu']");


	public TopMenuBar(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;


	}

	public WebElement getmenuproducts()
	{
		return driver.findElement(MenuProducts);
	}

	public WebElement getdropdownProducts()
	{


		return driver.findElement(DropdownProducts);
	}

	public WebElement getCreatebutton()
	{


		return driver.findElement(Createbutton);
	}

	public WebElement getProductType()
	{


		return driver.findElement(ProductType);
	}

	public WebElement getInputName()
	{


		return driver.findElement(InputName);
	}

	public WebElement getUnitOfMesaurement()
	{


		return driver.findElement(UnitOfMesaurement);
	}

	public WebElement getUnitOfMesaurement_option()
	{


		return driver.findElement(UnitOfMeasurement_option);
	}




	public WebElement getSaveButton()
	{


		return driver.findElement(SaveButton);
	}

	public WebElement getUpdateQuantity()
	{


		return driver.findElement(UpdateQuantity);
	}


	public WebElement getCreateQuantity()
	{


		return driver.findElement(CreateQuantity);
	}

	public WebElement getCountedQuantity()
	{


		return driver.findElement(CountedQuantity);
	}



	public WebElement getSaveQuantity()
	{	
		return driver.findElement(SaveQuantity);
	}




	public WebElement getHomeMenu()
	{

		return driver.findElement(HomeMenu);
	}

}
