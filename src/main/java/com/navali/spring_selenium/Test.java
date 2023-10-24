package com.navali.spring_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\XN726LM\\Desktop\\spring_selenium\\src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com");
        System.out.println("BrowserStack is launched successfully on Chrome!");
        driver.close();
    }
}
