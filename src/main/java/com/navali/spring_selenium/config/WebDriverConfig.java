package com.navali.spring_selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\XN726LM\\Desktop\\spring_selenium\\src\\main\\resources\\driver\\chromedriver.exe");
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver,Duration.ofSeconds(this.timeout));
    }
}
