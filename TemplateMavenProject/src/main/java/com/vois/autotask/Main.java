package com.vois.autotask;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
	
	public static String Email;
	public static String password;
	
	public static void get_data_from_app_file () {
		
		try (InputStream input = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//app.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            Email = prop.getProperty("email");
            password = prop.getProperty("password");
            
		 } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	public static void main(String[] args) throws Exception {
		
		get_data_from_app_file();
		Sikuli excel = new Sikuli();
		SendEmail sendEmailObj = new SendEmail();
		excel.openExcelSheet();
		excel.sortByJoinDate();
		excel.removeDuplicateInName();
		excel.saveAndClose();
		sendEmailObj.openYahoo();
		sendEmailObj.openSignInPage();
		sendEmailObj.signIn(Email,password);
		sendEmailObj.SendNewEmailTo("mohamed.almokadem@vodafone.com");
		sendEmailObj.closeBrowser();
		
	}

}