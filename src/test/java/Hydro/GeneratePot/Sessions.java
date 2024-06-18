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
	            websites.add("https://musical-lokum-47e4a7.netlify.app");
	            websites.add("https://fascinating-malabi-919567.netlify.app");
	            websites.add("https://stupendous-strudel-736574.netlify.app");
	            websites.add("https://cheery-praline-8d65d4.netlify.app");
	            websites.add("https://added-to-multiple-accounts.netlify.app");
	            websites.add("https://serene-puppy-fb39a1.netlify.app");
	                
	            websites.add("https://cute-fox-52d358.netlify.app");
	            websites.add("https://sweet-quokka-7fab8a.netlify.app");
	            websites.add("https://unrivaled-travesseiro-38a93b.netlify.app");
	            
	            websites.add("https://teal-medovik-5f8dd8.netlify.app/");
	            websites.add("https://eclectic-cassata-8d303e.netlify.app");
	            websites.add("https://luxury-cassata-a1a429.netlify.app");
	            
	            websites.add("https://playful-pithivier-64b681.netlify.app");
	            websites.add("https://polite-melba-59fde8.netlify.app");
	            
	            // uat
	            websites.add("https://fluffy-mandazi-8c011c.netlify.app");		// kuldeep.singh
	            websites.add("https://velvety-brigadeiros-94e96e.netlify.app"); // uat@yopmail.com
	            websites.add("https://lucky-kataifi-ccc848.netlify.app");		// skuldeepsingh
	            websites.add("https://gleeful-pothos-df7487.netlify.app");
	            
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
	           
	            
	            for(int r=0;r<10;r++)
	            {
		    	   	for(String handle:handles)
	   				{
	   					driver.switchTo().window(handle);	
	   					Thread.sleep(100);
	   					driver.findElement(By.xpath("//button[@id='myButton']")).click();
	   					Random rand = new Random();
	   					int randomNumber = rand.nextInt(30000) + 1;
	   					System.out.println(randomNumber);
	   					Thread.sleep(randomNumber);
	   				}
	            }
	        driver.quit();
	    }
	}

