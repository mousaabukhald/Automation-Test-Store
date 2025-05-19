
import java.net.http.WebSocket.Listener;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.PrinterInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AotumationTestScors {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.automationteststore.com/";

	String LoginOrRegisterPageURL = "https://automationteststore.com/index.php?rt=account/login";
	
	String AddedToTheCart = "https://automationteststore.com/index.php?rt=checkout/cart";

	String[] firstnames = {"John", "Emma", "Liam", "Olivia", "Noah"};
	String[] lastnames = { "Smith", "Johnson", "Williams", "Brown", "Davis" };

	String Continue = "https://automationteststore.com/index.php?rt=checkout/cart";
			
	String logoutPage = "https://automationteststore.com/index.php?rt=account/logout";
	String MenProdect = "https://automationteststore.com/index.php?rt=product/category&path=58";
	String AddOneProdect ="https://automationteststore.com/index.php?rt=product/product&amp;path=58_63&amp;product_id=107";

	Random rand = new Random();

	
       Random randQuantity = new Random();
       
       
	String PublicUserName = "";

	@BeforeTest
	public void mySetup() {
		driver.get(URL);

		driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public void SignUp() throws InterruptedException {

		// driver.get(LoginOrRegisterPageURL);
		// driver.findElement(By.linkText("Login or register")).click();;
		// driver.findElement(By.cssSelector(".btn.btn-orange.pull-right")).click();;
		driver.findElement(By.partialLinkText("Login or")).click();
		
		

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		
		// xpath : //Tagname[@attributename='value']
		          //Button[@title='Continue']
		
		
		int randomIndex = rand.nextInt(5);
		

		
		//WebElement Firstname = driver.findElement(By.id("AccountFrm_firstname"));
		//Firstname.sendKeys(firstname[randomIndex]);
		
		WebElement Firstname = driver.findElement(By.id("AccountFrm_firstname"));

		String RandomFirstName = firstnames[randomIndex];
		Firstname.sendKeys(RandomFirstName);
		
		//WebElement Lastname= driver.findElement(By.id("AccountFrm_lastname"));
		//Lastname.sendKeys(lastname[randomIndex]);

		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		String RandomLastName = lastnames[randomIndex];
		LastName.sendKeys(RandomLastName);

		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		int RandomIndexForTheEmail = rand.nextInt(54871);

		String username = RandomFirstName + RandomLastName + RandomIndexForTheEmail;

		PublicUserName = username;
		Email.sendKeys(username + "@gmail.com");

		WebElement Address = driver.findElement(By.id("AccountFrm_address_1"));

		Address.sendKeys("random address soso");

		WebElement City = driver.findElement(By.id("AccountFrm_city"));

		City.sendKeys("Amman");

		WebElement countrySelectTag = driver.findElement(By.id("AccountFrm_country_id"));

		Select mySelect = new Select(countrySelectTag);

		mySelect.selectByVisibleText("Jordan");
		
		//MySelect.selectByValue("108");

		Thread.sleep(1000);
		WebElement mySelectForRegion = driver.findElement(By.id("AccountFrm_zone_id"));

		Select mySelect2 = new Select(mySelectForRegion);

		mySelect2.selectByValue("1704");

		driver.findElement(By.id("AccountFrm_postcode")).sendKeys("199310");

		driver.findElement(By.id("AccountFrm_loginname")).sendKeys(username);

		driver.findElement(By.id("AccountFrm_password")).sendKeys("P@ssw0rd");

		driver.findElement(By.id("AccountFrm_confirm")).sendKeys("P@ssw0rd");

		driver.findElement(By.id("AccountFrm_agree")).click();

		driver.findElement(By.xpath("//button[@title='Continue']")).click();

		Thread.sleep(2000);
		
		driver.get(Continue);

	//driver.get(logoutPage);

	}

	@Test(priority = 2, enabled = false)

	public void LoginTest() throws InterruptedException {
		driver.get(LoginOrRegisterPageURL);

		WebElement username = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));

		username.sendKeys(PublicUserName);
		password.sendKeys("P@ssw0rd");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}
	
	
	@Test(priority = 3, invocationCount = 1)
	 
	public void AddOneRandomItem() throws InterruptedException {
 
		driver.get(MenProdect);
		
 
		List<WebElement> Items = driver.findElements(By.cssSelector(".col-md-2.col-sm-2.col-xs-6.align_center"));

	int RandomItem = rand.nextInt(Items.size());
    Items.get(RandomItem).click();;

		
		
	
    //WebElement AddToCartButton = driver.findElement(By.cssSelector("a.productcart[data-id='107']"));
    //AddToCartButton.click();
    //WebElement cartMenu = driver.findElement(By.cssSelector("li[data-id='menu_cart'] a"));
    //cartMenu.click();
   
 
      //  Random rand = new Random();
        //int randomQuantity = rand.nextInt(9) + 2; 
        
        //WebElement quantityInput = driver.findElement(By.id("cart_quantity107"));
        //quantityInput.clear(); 
        //quantityInput.sendKeys(String.valueOf(randomQuantity)); 
     
    //    WebElement checkoutButton = driver.findElement(By.id("cart_checkout1"));
      //  checkoutButton.click();
       // WebElement confirmOrderButton = driver.findElement(By.id("checkout_btn"));
        //confirmOrderButton.click();
        
      
          //      System.out.println(" Your Order Has Been Processed!");
	
		
		Thread.sleep(2000);
	}
	

	@Test(priority = 4 )	
	
	public void AddRandomItems() throws InterruptedException {
		
	//div : that mean division  	
		
	List<WebElement> AddRandomItems = driver.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12"));
	
	
		AddRandomItems.get(0).click();
		Thread.sleep(3000);
		System.out.println(AddRandomItems.size());
		
		
		
		
		Thread.sleep(2000);
		String ItemMassage = driver.findElement(By.className("productpagecart")).getText();
		
		if( ItemMassage.contains("Out")) {
			
			
			
			Thread.sleep(2000);
			
			driver.navigate().back();
			
		} else {
			
			
		driver.findElements(By.cssSelector(".fa.fa-cart-plus.fa-fw")).get(rand.nextInt(1)).click();;	
			
			
		}
		
		int AddRandomQuantity = randQuantity.nextInt();
		
		
		
		}
				
				
				
				
				
				
			
			
			
			
			
			
			
			
			
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
