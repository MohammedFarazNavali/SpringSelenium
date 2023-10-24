package com.navali.spring_selenium.page.google;

import com.navali.spring_selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "callout")
    private WebElement signOutFrame;

    @FindBy(xpath = "//*[text()='Stay signed out']")
    private WebElement signOutBtn;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.driver.switchTo().frame(signOutFrame);
        this.signOutBtn.click();
        this.driver.switchTo().defaultContent();
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}