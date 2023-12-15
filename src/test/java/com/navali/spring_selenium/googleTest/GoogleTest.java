package com.navali.spring_selenium.googleTest;

import com.navali.spring_selenium.SpringBaseTestNGTest;
import com.navali.spring_selenium.page.google.GooglePage;
import com.navali.spring_selenium.utils.ScreenShots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShots screenShots;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResults().isAt());
        Assert.assertTrue(this.googlePage.getSearchResults().getCount() > 2);
        this.screenShots.takeScreenShots();
        this.googlePage.close();
    }

}
