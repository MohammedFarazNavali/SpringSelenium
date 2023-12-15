package com.navali.spring_selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;
@Lazy
@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @ConditionalOnProperty(name="Browser",havingValue = "Chrome")
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\XN726LM\\Desktop\\spring_selenium\\src\\main\\resources\\driver\\chromedriver.exe");
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name="Browser",havingValue = "Edge")
    public WebDriver edgeDriver() {
        System.setProperty("webdriver.edge.driver","C:\\Users\\XN726LM\\Desktop\\spring_selenium\\src\\main\\resources\\driver\\msedgedriver.exe");
        return new EdgeDriver();
    }

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver,Duration.ofSeconds(this.timeout));
    }
}
