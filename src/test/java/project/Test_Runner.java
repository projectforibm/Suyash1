package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;

public class Test_Runner {
	WebDriver driver=new FirefoxDriver();
    @Test(priority=1)
  
 
	  
	    public void f() {
	  	     WebElement link_Home=driver.findElement(By.id("menu8"));
	  		Actions builder=new Actions(driver);
	  		Action mouseoverhome=builder.moveToElement(link_Home).build();
	  		mouseoverhome.perform();
	  		builder.sendKeys(link_Home,(Keys.ENTER)).perform();
	  		
	  		System.out.println("entered into message column");
	  		
	  		//driver.findElement(By.xpath("//*[@id='submenu8.0']")).click(); 
	  		
	    }
	    

	   @Test(priority=2)
	    public void message_list1() throws InterruptedException
	    {
	  	 
	  	 
	  		driver.findElement(By.xpath("//*[@id='submenu8.0']")).click(); 
	  		
	  		System.out.println("entered into message box \n");

	  	WebElement ML= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
	  	Select message = new Select(ML);
	  	List <WebElement> ML1 = message.getOptions();
	  	
	  	//message.selectByVisibleText(ML1.get(2).getText());
	  	System.out.println("number of elements of message box is: "+ML1.size());
	  	System.out.println("elements of message box are");
	  	int x= ML1.size();
	  	for (int i=0; i<x; i++){
	  		System.out.println(ML1.get(i).getText());	}
	  	
	  	//to access  sent message

	  	message.selectByVisibleText("Sent items");
	  	Thread.sleep(2000);
	  	 

	  	//to access sent message
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")).click();
	  	
	  	
	  	String S="http://localhost:8585/do/admin/viewMessage?messageId=32";
	  	String S1="http://localhost:8585/do/admin/viewMessage?messageId=32";
	  	Assert.assertEquals(S1, S);
	  	System.out.println("URl matched");
	  	
	  	 
	  	 driver.findElement(By.xpath(".//*[@id='backButton']")).click();

	  	//to select one  message checkbox 
	  	
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
	  	// to un-select  message checkbox
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
	  	 
	  	 
	  	/*
	  	  //to access button delete
	  	 
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).click();
	  	String s= driver.switchTo().alert().getText();
	  	System.out.println("Text in pop up after deleting message :="+s);
	  	driver.switchTo().alert().accept();*/
	  	

	  	
	  	//to select "select-all" button
	  	driver.findElement(By.xpath(".//*[@id='selectAllButton']")).click();
	  	WebElement ML2= driver.findElement(By.id("applyActionSelect"));
	  	Select message1 = new Select(ML2);
	  	
	  	
	  	//message1.selectByVisibleText("Mark as read");
	  	message1.selectByVisibleText("Mark as unread");

	  	 
	  TestNGThread.sleep(5000);
	  	
	  	//for trash listbox
	  	WebElement ML3= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
	  	Select message2 = new Select(ML3);
	  	message2.selectByVisibleText("Trash");
	  	
	  	System.out.println("moved to trash checkbox");
	  	
	  	TestNGThread.sleep(2000);
	  	/*driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).click();*/
	  	
	  	
	  	/*String s1= driver.switchTo().alert().getText();
	  	//driver.switchTo().alert().accept();
	  	driver.switchTo().alert().dismiss();*/
	  	System.out.println("message after deleting message form delete column =>"+"Are you sure to permanently remove the message");
	  	
	  	
	  	/*String s3= driver.switchTo().alert().getText();
	  	driver.switchTo().alert().accept();*/
	  	System.out.println("pop up after clicking delete button=>"+"The message was removed");
	  	
	  	TestNGThread.sleep(3000);
	  	

	  	
	  	//for accessing messages
	  	
	  	WebElement ML4= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
	  	Select message3 = new Select(ML4);
	  	message3.selectByVisibleText("Inbox");
	  	
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")).click();
	  	String s6="http://localhost:8585/do/admin/viewMessage?messageId=32";
	  	String s7="http://localhost:8585/do/admin/viewMessage?messageId=32";
	  	
	  	Assert.assertEquals(s7, s6);
	  	
	  	
	  	System.out.println("url matched");
	  	
	  	
	  	driver.findElement(By.xpath(".//*[@id='replyButton']")).click();
	  	TestNGThread.sleep(2000);
	  	
	  	driver.findElement(By.tagName("iframe")).sendKeys("it is a reply message");
	  	
	  	
	  	driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();
	  	String s= 	driver.switchTo().alert().getText();
	  	driver.switchTo().alert().accept();
	  	System.out.println("pop up after sending reply=> "+s);
	  	
	  	 
	  	 TestNGThread.sleep(2000);
	    }
	    
	   
	   
	    @Test(priority=3)
	    public void submit() throws InterruptedException
	    {

	  	  driver.findElement(By.xpath("//*[@value='Submit']")).click();
	  	  driver.findElement(By.name("sendTo"));
	  	  driver.findElement(By.xpath("//*[@value='GROUP']")).click();
	  	  driver.findElement(By.name("sendTo"));
	  	  driver.findElement(By.xpath("//*[@value='MEMBER']")).click();
	  	  
	  	 driver.findElement(By.id("memberUsername")).sendKeys("samsaravanan");
	  	 
	  	 TestNGThread.sleep(3000);
	  	 

	  	 WebElement category = driver.findElement(By.id("categorySelect"));
	  		Select categoryList = new Select(category);
	  		List <WebElement> categoryList1 = categoryList.getOptions();	
	  		System.out.println("number of optin in category list box"+categoryList1.size());
	  		for (int i=0; i<categoryList1.size(); i++){
	  	System.out.println(categoryList1.get(i).getText());}
	  		
	  	  driver.findElement(By.id("subjectText")).sendKeys("only to test application");
	  	  driver.findElement(By.tagName("iframe")).sendKeys("hie...");
	  	  
	  	  driver.findElement(By.xpath("//*[@value='Submit']")).click();
	  	  

	  	  
	  	  TestNGThread.sleep(5000);
	  	 String s= driver.switchTo().alert().getText();

	  	  driver.switchTo().alert().accept();
	  	  TestNGThread.sleep(5000);


	  	  
	  	  System.out.println("message after sending email= "+s);
	  	  
	  	  
	  	  TestNGThread.sleep(3000);
	  	  //driver.findElement(By.id("backButton")).click();

	  	  driver.findElement(By.xpath("//*[@value='Submit']")).click();
	  		 
	  		 TestNGThread.sleep(3000);

	    }
	    
	    

	   
	   
	    
	  @Test(priority=4)
	    public void SelectAll_SelectNone_ApplyAction() throws InterruptedException
	    {

	  	  
	  	  WebElement link_Home=driver.findElement(By.id("menu8"));
	  		Actions builder=new Actions(driver);
	  		Action mousehoverhome=builder.moveToElement(link_Home).build();
	  		mousehoverhome.perform();
	  		builder.sendKeys(link_Home,(Keys.ENTER)).perform();
	  		driver.findElement(By.xpath("//*[@id='submenu8.0']")).click();
	  		

	  		
	  		
	  	WebElement link_Home1=  driver.findElement(By.xpath(".//*[@id='selectAllButton']"));
	  	Actions builder1= new Actions(driver);
	  	Action mouseoverhome1= builder1.moveToElement(link_Home1).build();
	  	mouseoverhome1.perform();
	  	
	  	driver.findElement(By.xpath(".//*[@id='selectAllButton']")).click();
	  	
	  	TestNGThread.sleep(5000);
	  	

	  	
	  	WebElement link_Home2=  driver.findElement(By.xpath(".//*[@id='selectNoneButton']"));
	  	Actions builder2= new Actions(driver);
	  	Action mouseoverhome2= builder2.moveToElement(link_Home2).build();
	  	mouseoverhome2.perform();
	  	
	  	driver.findElement(By.xpath(".//*[@id='selectNoneButton']")).click();
	  	
	  	//TestNGThread.sleep(3000);
	  	

	  	
	  	//driver.navigate().back();
	  	
	    }
	    
	    @Test(priority=5)
	    public void Message_Category() throws InterruptedException
	    {

	  		driver.findElement(By.xpath(".//*[@id='submenu8.1']/span[2]")).click();
	  		driver.findElement(By.id("newButton")).click();
	  		driver.findElement(By.name("messageCategory(name)")).sendKeys("new_p");
	  		driver.findElement(By.id("saveButton")).click();
	  		TestNGThread.sleep(2000);


	  		String s= driver.switchTo().alert().getText();

	  		  driver.switchTo().alert().accept();

	  		  
	  		  System.out.println("message after enter new category= "+s);  
	  		
	  		   
	  		 driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[11]/td[2]/img[1]")).click();
	  			 
	  		 driver.findElement(By.id("modifyButton")).click();
	  		 driver.findElement(By.name("messageCategory(name)")).clear();
	  		 driver.findElement(By.name("messageCategory(name)")).sendKeys("new_2");
	  		 driver.findElement(By.id("saveButton")).click();
	  		 TestNGThread.sleep(2000);

	  		
	  		 String s1= driver.switchTo().alert().getText();

	  		
	  		 
	  		  driver.switchTo().alert().accept();
	  		  
	  			 

	  		  System.out.println("message after editing category= "+s1); 
	  		  
	  		 
	  		  //for deleting msg
	  		  
	  		  driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img[2]")).click();
	  		  TestNGThread.sleep(2000);

	  			 
	  		  driver.switchTo().alert().accept();
	  			 

	  			 String s2= driver.switchTo().alert().getText();
	  			 // driver.switchTo().alert().accept();
	  				

	  			  System.out.println("message after deleting category= "+s2); 
	  			  
	  		  //for not deleting msg
	  		  driver.switchTo().alert().dismiss();
	  				 


	    }
	    

	    @BeforeTest
	    public void beforeTest() {
	  	  
	  	  driver.get("http://localhost:8585/do/login");
	  		//driver.manage().window().maximize();

	  		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	  		driver.findElement(By.xpath("//*[@value='1']")).click();
	  		driver.findElement(By.xpath("//*[@value='2']")).click();
	  		driver.findElement(By.xpath("//*[@value='3']")).click();
	  		driver.findElement(By.xpath("//*[@value='4']")).click();
	  		driver.findElement(By.xpath("//*[@value='Submit']")).click();
	  	  
	  		System.out.println("login successfull /n/n");
	    }

	    @AfterTest
	    public void afterTest() {
	  	  
	  	// driver.close();
	    }

	  

  }
