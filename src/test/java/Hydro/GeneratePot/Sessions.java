package Hydro.GeneratePot;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sessions 
{
	

	
	    private WebDriver driver;

	    @Test
	    public void testBrowser() throws InterruptedException {
	    	 WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	            
	            ArrayList<String> websites=new ArrayList<String>();
	            ArrayList<String> handles;
	           
	            
//	            websites.add("https://3kuldeep-singh-12-08.netlify.app");
//	            websites.add("https://kuldeep-singh-12-08.netlify.app");
//	            websites.add("https://kuldeep2-singh-12-08.netlify.app");
//	            
//	            websites.add("https://1skuldeepsingh-12-08.netlify.app");
//	            websites.add("https://2skuldeepsingh-21-08.netlify.app");
//	            
//	            websites.add("https://kartik-saini-antier-13-08.netlify.app");
//	            
//	            websites.add("https://moonpaytest3-13-08.netlify.app");
//	            websites.add("https://moonpay-2-test-21-08.netlify.app");
//	            websites.add("https://moonpay-3-test-21-08.netlify.app");
//	            websites.add("https://moonpay-4-test-21-08.netlify.app");
//	            
//	            websites.add("https://publisher-13-08.netlify.app");
//	            
//	           
//	            
//	            
//	            
//	            
//	            
//	            // uat
	            websites.add("https://fluffy-mandazi-8c011c.netlify.app");		// kuldeep.singh
	            websites.add("https://velvety-brigadeiros-94e96e.netlify.app"); // uat@yopmail.com
	            websites.add("https://lucky-kataifi-ccc848.netlify.app");		// skuldeepsingh
	            websites.add("https://gleeful-pothos-df7487.netlify.app");
	            websites.add("https://spiffy-madeleine-af5144.netlify.app");
	            websites.add("https://glittery-douhua-fbc8ef.netlify.app");     // dhananjay	
	            websites.add("https://capable-boba-03a124.netlify.app");		// leezasingh11
	            websites.add("https://ornate-cat-508290.netlify.app");	
	            websites.add("https://kaleidoscopic-cendol-25d1b7.netlify.app/");
	           
	            //prod
	            websites.add("https://majestic-mermaid-6c6ceb.netlify.app"); //kuldeep.singh
	            websites.add("https://cute-pithivier-4d8c76.netlify.app");
	            websites.add("https://rococo-piroshki-da9290.netlify.app");  // skuldeepsingh
	            websites.add("https://steady-concha-313303.netlify.app");    // publisher
	            
	     
	        	
            		while(!websites.isEmpty())
            		 {
            			driver.get(websites.get(0));
                		driver.findElement(By.xpath("//button[@id='myButton']")).click();
                		websites.remove(0);
            			if(!websites.isEmpty())
            			{
            				driver.switchTo().newWindow(WindowType.TAB);
            			}
            		 }
					Thread.sleep(100);
				
	            handles=new ArrayList<>(driver.getWindowHandles());
	            int length=handles.size();
	           
	            
	            for(int r=0;r<10;r++)
	            {
		    	   	for(int round=0;round<=(length*2);round++)
	   				{
		    	   		Random rand1 = new Random();
	   					int randomNumber1 = rand1.nextInt(length);
	   					driver.switchTo().window(handles.get(randomNumber1));	
	   					Thread.sleep(100);
	   					driver.findElement(By.xpath("//button[@id='myButton']")).click();
	   					Random rand = new Random();
	   					int randomNumber = rand.nextInt(30000) + 10;
	   					System.out.println(randomNumber);
	   					Thread.sleep(randomNumber);
	   				}
	            }
	        driver.quit();
	    }
	}

// Steps to configure the trigger of the automations script when new commits are made to the test application repo 
// 
//1) Install Git plugin in Jenkins >> Manage Jenkins >> Plugins >> Available >> Git plugin
//2) Also check if the git is installed on your machine using git --version
//3) Create a Jenkins job, Jenkins dashboard >> New item >> Freestyle project 
//4) Setup GitHub webhook to trigger for the automation script when any new changes are introduced in the test application repo, enable trigger in the Jenkins job for the automation script project- Goto the job >> Configure >> Build triggers >> Check GitHub hook trigger for GITScm polling >> Save
//5) For initiating trigger from the test application repo- Goto GitHub repo for the application >> Settings >> Add webhook by filling up Payload URL, Content type: application/json, Which events: Just the push event >> Add webhook
//	For the payload url: Download ngork and run >> run in ngrok terminal- ngrok http 8080 >> copy the forwarding url (which will be equivalent and publically accessible alternative to the localhost url) like: https://6ff3-182-73-190-216.ngrok-free.app 
//6) Also specify for the Source code management- Jenkins job >> configure >> Source code management >> Specify repository url (of application repo) and credentials, and branch also
//7) Now commit any changes to the test application repo >> it will trigger the automation script using webhook added to it >> which will get detected by the Jenkins job

