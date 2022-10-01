package com.vois.autotask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendEmail {

	private WebDriver driver ;
	private WebDriverWait wait ;
	Sikuli sikuliObj;
	private By signInPage = By.xpath("//a[@alt='Sign in']");
	private By EmailBar = By.id("login-username");
	private By PasswordBar = By.id("login-passwd");
	private By nextBtn = By.id("login-signin");
	private By compose = By.xpath("//a[@aria-label='Compose']");
	private By To = By.id("message-to-field");
	private By subject = By.xpath("//input[@placeholder='Subject']");
	private By attach = By.xpath("//button[@title='Attach files']//span[@class='D_F ab_C gl_C W_6D6F']");
	private By browse = By.xpath("//span[contains(text(),'Attach files from computer')]");
	private By send = By.xpath("//button[@title='Send this email']");
	String path = System.getProperty("user.dir")+"\\ExcelSheet\\Data.xlsx";

	public void openYahoo() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://mail.yahoo.com/");
	}

	public void openSignInPage () {

		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signInPage));
		driver.findElement(signInPage).click();
	}

	public void signIn (String Email,String pass) {

		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EmailBar));
		driver.findElement(EmailBar).sendKeys(Email);
		driver.findElement(nextBtn).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PasswordBar));
		driver.findElement(PasswordBar).sendKeys(pass);
		driver.findElement(nextBtn).click();

	}

	public void AttachFileToMail () throws Exception {

		sikuliObj = new Sikuli();
		wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(attach));
		driver.findElement(attach).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(browse));
		driver.findElement(browse).click();
		Thread.sleep(5000);
		sikuliObj.uploadFile(path);


	}

	public void SendNewEmailTo (String receiver) throws Exception {

		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(compose));
		driver.findElement(compose).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(To));
		driver.findElement(To).sendKeys(receiver);
		driver.findElement(subject).sendKeys("Test send ExcelSheet");
		AttachFileToMail();
		Thread.sleep(5000);
		driver.findElement(send).click();

	}
	
	public void closeBrowser () {
		
		driver.quit();
	}



}
