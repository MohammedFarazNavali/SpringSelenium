package com.navali.spring_selenium.googleTest;

import com.navali.spring_selenium.SpringBaseTestNGTest;
import com.navali.spring_selenium.page.google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Test
    public void googleTest() {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResults().isAt());
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() > 2);
        this.googlePage.close();
    }

}
