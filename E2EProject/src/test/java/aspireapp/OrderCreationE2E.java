package aspireapp;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.InventoryOptionScreen;
import pageObjects.LoginPage;
import pageObjects.ManufacturingPage;
import pageObjects.TopMenuBar;
import resources.base;

public class OrderCreationE2E extends base{
	public WebDriver driver;
	
//Creating a global variable which can be accessed from anywhere	
	public static String ProductName;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
//Flow to login and navigate to Home Page	
	@Test(dataProvider="getData")
	
	public void homePageNavigation(String Username,String Password) throws IOException
	{
		//one is inheritance
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);	
		lp.getLogin().click();	
		}

// Selecting Inventory option	
@Test(priority=1)
	
	public void validateInventory() throws IOException
	{
		//one is inheritance
		// creating object to that class and invoke methods of it
	InventoryOptionScreen los=new InventoryOptionScreen(driver);
	los.getInventory().click();
	Assert.assertTrue("Clicked on Inventory successfully", true);
	
		}

//Flow to create a product type and add the quantiyt to more than 10 

@Test(priority=2)

public void topmenubar() throws IOException, InterruptedException
{
	//one is inheritance
	// creating object to that class and invoke methods of it
	
	TopMenuBar tmb=new TopMenuBar(driver);
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Inventory Overview']")));
	tmb.getmenuproducts().click();
	tmb.getdropdownProducts().click();
	tmb.getCreatebutton().click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New']")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Product Name']")));
	long uniqueid = System.currentTimeMillis();
	ProductName = "Auto_Product_"+uniqueid;
	System.out.print(ProductName);
	tmb.getInputName().sendKeys(ProductName);
	Select producttype = new  Select(tmb.getProductType());
	producttype.selectByIndex(3);
	tmb.getUnitOfMesaurement().click();
	tmb.getUnitOfMesaurement_option().click();
	tmb.getSaveButton().click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+ProductName+"']")));
	tmb.getUpdateQuantity().click();
	tmb.getCreateQuantity().click();
	tmb.getCountedQuantity().click();
	tmb.getCountedQuantity().clear();
	tmb.getCountedQuantity().sendKeys("15.00");
	tmb.getSaveQuantity().click();
	tmb.getHomeMenu().click();
}

//Flow to create a manufacturing order and move it to done status
@Test(priority=3)
public void manufacturingpage() throws InterruptedException
{
	ManufacturingPage cmp=new ManufacturingPage(driver);
	cmp.getmanufacturingoption().click();
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Manufacturing Orders']")));
	cmp.getmanufacturingordercreate().click();
	cmp.getProductName().sendKeys(ProductName);
	cmp.driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	cmp.getConfirmOrder().click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'WH')]")));
	wait.until(ExpectedConditions.invisibilityOf(cmp.getConfirmOrder()));
	cmp.getMarkasDone().click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Confirmation']")));
    cmp.getAlertOk().click();
    wait.until(ExpectedConditions.visibilityOf(cmp.getAlertboxtitle()));
    cmp.getApplyText().click();
    wait.until(ExpectedConditions.visibilityOf(cmp.getDoneStatus()));
    String Productnamecreated = cmp.getProducttext().getText();   
    Assert.assertEquals("Order is successfully created with verified Product Name", Productnamecreated, ProductName);
}

//TearDown function to close the browser after the test
	@AfterTest
	public void teardown()
	{		
		driver.quit();
		
	}

//Passing User credentails	
	@DataProvider
	public Object[][] getData()
	{
	// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][2];
		//0th row
		data[0][0]="user@aspireapp.com";
		data[0][1]="@sp1r3app";		
		return data;		
	}
	
}
