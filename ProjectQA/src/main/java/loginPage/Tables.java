package loginPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tables {	
	
	
	public void clickHeader(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul[1]/li[3]")).click();
		driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[1]")).click();
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
		int totalRecords = tableRows.size();
		List<WebElement> paginationList = driver.findElements(By.xpath("//ul[@id='myPager']/li"));
		int count=0;
		for(int i=1; i<paginationList.size();i++){
			paginationList.get(i).click();
			Thread.sleep(1000);
			count=count+driver.findElements(By.xpath("//table/tbody/tr[@style='display: table-row;']")).size();
		}
		if(totalRecords == count)
			System.out.println("All Records are equal..!");
		else
			System.out.println("Something went Wrong..!");
	}

}
